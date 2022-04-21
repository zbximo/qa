package com.example.zuccqa.impl;

import com.example.zuccqa.controller.DynamicTask;
import com.example.zuccqa.entity.Course;
import com.example.zuccqa.entity.Feedback;
import com.example.zuccqa.exception.BusinessException;
import com.example.zuccqa.repository.FeedbackRepository;

import com.example.zuccqa.service.CourseService;
import com.example.zuccqa.service.FeedbackService;
import com.example.zuccqa.utils.Constant;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import io.netty.util.internal.StringUtil;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
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
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private CourseService courseService;
    @Autowired
    private RedisTemplate redisTemplate;

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
        System.out.println(redisTemplate.opsForHash().entries(feedbackId + "finishedTable"));
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
        System.out.println(redisTemplate.opsForHash().entries(feedbackId + "finishedTable"));
        System.out.println(map.size());
        return map;
    }


    @Override
    public List<String> getAllCache() {

        List<String> list = new ArrayList<>();
        //key("*") 获取所有键
        Set<String> keys = redisTemplate.keys("*");
        System.out.println("cacheSize: "+String.valueOf(keys.size()));
        for (String key : keys) {
            Map<Object, Object> map = redisTemplate.opsForHash().entries(key);
            map.forEach((key1, value) -> {
                if ((Integer) value == 0) {
                    // 发送消息
                    System.out.println("post: " + "feedbackId:" + key + "studentId:" + key1);
                }

            });
            list.add(StringUtils.substringBefore(key,"finishedTable"));
        }
        return list;
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
            throw new BusinessException(Constant.PARAM_ERROR, "模板名称为空");
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
            throw new BusinessException(Constant.PARAM_ERROR, "问卷ID不能为空");
        }
        if (feedbackRepository.findByFeedbackId(id) == null) {
            throw new BusinessException(Constant.PARAM_ERROR, "找不到该问卷, 问卷ID: " + id);
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
            throw new BusinessException(Constant.PARAM_ERROR, "问卷ID不能为空");
        }
        if (feedbackRepository.findByFeedbackId(feedback.getFeedbackId()) == null) {
            throw new BusinessException(Constant.PARAM_ERROR, "找不到该问卷, 问卷ID: " + feedback.getFeedbackId());
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
            throw new BusinessException(Constant.PARAM_ERROR, "问卷ID不能为空");
        }
        Feedback feedback = feedbackRepository.findByFeedbackId(feedBackId);
        if (feedback == null) {
            throw new BusinessException(Constant.PARAM_ERROR, "未找到该问卷, 问卷ID: " + feedBackId);
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
            throw new BusinessException(Constant.PARAM_ERROR, "未找到该课程的问卷, 课程ID: " + courseId);
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
