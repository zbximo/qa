package com.example.zuccqa.impl;

import com.example.zuccqa.controller.DynamicTask;
import com.example.zuccqa.entity.Course;
import com.example.zuccqa.entity.Feedback;
import com.example.zuccqa.exception.BusinessException;
import com.example.zuccqa.mq.ZuccEchoMessage;
import com.example.zuccqa.repository.FeedbackRepository;

import com.example.zuccqa.result.ResponseData;
import com.example.zuccqa.service.CourseService;
import com.example.zuccqa.service.FeedbackService;
import com.example.zuccqa.utils.Constants;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;


import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author: ximo
 * @date: 2022/4/17 14:10
 * @description:
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {
    private final Logger logger = LoggerFactory.getLogger(FeedbackServiceImpl.class);
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private CourseService courseService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Qualifier("rpc")
    @Autowired
    private DirectExchange rpcExchange;
    @Autowired
    private AmqpTemplate mqService;

    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        this.redisTemplate = redisTemplate;
    }


    /**
     * 创建问卷后，将feedbackId + "finishedTable" + courseId作为key，学生填写状态Map作为value存入cache
     *
     * @param feedbackId 问卷Id
     * @param courseId   课程Id
     * @return
     */
    @Override
    public Map<String, Integer> addFinishCache(String feedbackId, String courseId) {
        Map<String, Integer> map = new HashMap<>();
        Course course = courseService.findById(courseId);
        course.getStudentIdList().stream().forEach(
                s -> {
                    map.put(s, 0);
                }
        );
        System.out.println(map.size());
        // 存入数据
        redisTemplate.opsForHash().putAll(feedbackId + "finishedTable", map);
        Feedback feedback = feedbackRepository.findByFeedbackId(feedbackId);
        Date start = feedback.getStartTime();
        Date end = feedback.getEndTime();
        // 设置缓存时间: 结束时间-开始时间
        long sub = Math.abs(start.getTime() - end.getTime());
        redisTemplate.expire(feedbackId + "finishedTable", sub, TimeUnit.MILLISECONDS);
        return map;
    }

    /**
     * 填写完用户后，更新状态
     *
     * @param feedbackId 问卷Id
     * @param courseId   课卷Id
     * @param studentId  学生Id
     * @return
     */
    @Override
    public Map<String, Integer> FinishedCache(String feedbackId, String courseId, String studentId) {

        Map<String, Integer> map = redisTemplate.opsForHash().entries(feedbackId + "finishedTable");

        map.put(studentId, 1);
        redisTemplate.opsForHash().putAll(feedbackId + "finishedTable", map);
        logger.info("add cache: key:{}", feedbackId + "finishedTable");
        return map;
    }


    @Override
    public List<String> postTips(String fbId) {

        List<String> fbIdList = new ArrayList<>();
        //key("*") 获取所有键
        Set<String> keys = redisTemplate.keys("*");
        keys.forEach(
                s -> {
                    fbIdList.add(StringUtils.substringBefore(s, "finishedTable"));
                }
        );
        boolean last = (System.currentTimeMillis() - feedbackRepository.findByFeedbackId(fbId).getEndTime().getTime()) <= 10 * 1000;
        if (!fbIdList.contains(fbId)) {
            System.out.println("cancle: " + fbId);
            DynamicTask.map.get(fbId).cancel(true);
            DynamicTask.map.remove(fbId);
        } else {
            Map<Object, Object> map = redisTemplate.opsForHash().entries(fbId + "finishedTable");
            map.forEach((key1, isFin) -> {

                if ((Integer) isFin == 0) {
                    ZuccEchoMessage msg = new ZuccEchoMessage(ZuccEchoMessage.POST_TIP);
                    msg.appendContent("msg", "send tips need to confirm.");
                    msg.appendContent("fbId",fbId);
                    msg.appendContent("studentId",key1);
                    // 发送消息
                    logger.info("postInfo: " + "feedbackId:" + fbId + "  studentId:" + key1);
                    // 最后一次通知
                    if (last) {
                        logger.warn("last postInfo.");
                        //需要确认送达的消息

                        logger.warn("send msg to [{}]", rpcExchange.getName());
                        String ret = (String) mqService.convertSendAndReceive(rpcExchange.getName(), Constants.KEY_RPC, msg);
                        logger.warn("send msg got response[{}]", ret);
                    }else {
                        mqService.convertAndSend(Constants.QUE_WORK_QUEUE, msg);
                    }
                }

            });
        }
        logger.info("endPostTips");
        return fbIdList;
    }

    /**
     * @param feedbackMap 问卷信息
     * @return
     */

    @Override
    public String addFeedback(Feedback feedbackMap) {
        Feedback feedback = new Feedback();
        BeanUtils.copyProperties(feedbackMap, feedback);
        if (feedback.getFeedbackTitle() == null || feedback.getFeedbackTitle().equals("")) {
            throw new BusinessException(Constants.PARAM_ERROR, "模板名称为空");
        }
        ObjectId id = new ObjectId();
        feedback.setFeedbackId(id.toString());
        feedback.setCreatTime(new Date(System.currentTimeMillis()));
        feedbackRepository.save(feedback);
//        addFinishCache(feedback.getFeedbackId(), feedback.getFeedbackCourseId());
        return feedback.getFeedbackId();
    }

    /**
     * @param id 问卷ID
     * @return
     */
    @Override
    public String deleteFeedback(String id) {
        if (id.equals("")) {
            throw new BusinessException(Constants.PARAM_ERROR, "问卷ID不能为空");
        }
        if (feedbackRepository.findByFeedbackId(id) == null) {
            throw new BusinessException(Constants.PARAM_ERROR, "找不到该问卷, 问卷ID: " + id);
        }
        feedbackRepository.deleteByFeedbackId(id);
        return id;
    }


    /**
     * @param feedbackMap 问卷信息
     * @return
     */
    @Override
    public String updateFeedback(Feedback feedbackMap) {
        Feedback feedback = new Feedback();
        BeanUtils.copyProperties(feedbackMap, feedback);
        if (feedback.getFeedbackId() == null || feedback.getFeedbackId().equals("")) {
            throw new BusinessException(Constants.PARAM_ERROR, "问卷ID不能为空");
        }
        if (feedbackRepository.findByFeedbackId(feedback.getFeedbackId()) == null) {
            throw new BusinessException(Constants.PARAM_ERROR, "找不到该问卷, 问卷ID: " + feedback.getFeedbackId());
        }
        feedbackRepository.save(feedbackMap);
        return feedback.getFeedbackId();
    }

    /**
     * @param feedBackId 问卷ID
     * @return
     */
    @Override
    public Feedback findById(String feedBackId) {
        if (feedBackId.equals("")) {
            throw new BusinessException(Constants.PARAM_ERROR, "问卷ID不能为空");
        }
        Feedback feedback = feedbackRepository.findByFeedbackId(feedBackId);
        if (feedback == null) {
            throw new BusinessException(Constants.PARAM_ERROR, "未找到该问卷, 问卷ID: " + feedBackId);
        }
        return feedback;
    }

    /**
     * @param courseId 课程ID
     * @return
     */
    @Override
    public List<Feedback> findByCourseId(String courseId) {
        courseService.findById(courseId);
        List<Feedback> feedbackList = feedbackRepository.find(courseId);
        if (feedbackList.size() == 0) {
            throw new BusinessException(Constants.PARAM_ERROR, "未找到该课程的问卷, 课程ID: " + courseId);
        }
        return feedbackList;
    }

    /**
     * @return
     */
    @Override
    public List<Feedback> getAll() {
        return feedbackRepository.findAll();
    }
}
