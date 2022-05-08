package com.example.zuccqa.controller;

import com.example.zuccqa.entity.AnswerSheet;
import com.example.zuccqa.entity.Course;
import com.example.zuccqa.entity.Feedback;
import com.example.zuccqa.mq.ZuccEchoMessage;
import com.example.zuccqa.result.ExceptionMsg;
import com.example.zuccqa.result.Response;
import com.example.zuccqa.result.ResponseData;
import com.example.zuccqa.service.AnswerSheetService;
import com.example.zuccqa.service.CourseService;
import com.example.zuccqa.service.FeedbackService;

import com.example.zuccqa.utils.Constants;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: ximo
 * @date: 2022/3/24 14:31
 * @description:
 */
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(FeedbackController.class);
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private AnswerSheetService answerSheetService;
    @Autowired
    private DynamicTask dynamicTask;
    @Autowired
    private AmqpTemplate mqService;
    @Autowired
    private FanoutExchange fanout;

    @Qualifier("direct")
    @Autowired
    private DirectExchange directExchange;
    @Autowired
    private TopicExchange topicExchange;

    /**
     * 发送问卷后，给所有人初始化答卷。
     * Simple模式 消息队列 创建答卷
     *
     * @param feedbackMap 问卷信息
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData addFeedback(@RequestBody Feedback feedbackMap) {

        String feedbackId = feedbackService.addFeedback(feedbackMap);
        feedbackMap.setFeedbackId(feedbackId);

        ZuccEchoMessage msg = new ZuccEchoMessage(ZuccEchoMessage.CATEGORY_BLANKSHEET_CREATE);
        msg.appendContent("feedback",feedbackMap);
        mqService.convertAndSend(Constants.QUE_SIMPLE, msg);
        // 添加缓存、 定时任务
        feedbackService.addFinishCache(feedbackId, feedbackMap.getFeedbackCourseId());
        logger.warn("create feedback id: {}", feedbackId);
        dynamicTask.startCron(feedbackId);
        return new ResponseData(ExceptionMsg.CREATE_SUCCESS, feedbackId);
    }

    /**
     * @param id 问卷ID
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Response deleteFeedback(@RequestParam("id") String id) {
        String feedbackId = feedbackService.deleteFeedback(id);
        logger.warn("delete feedback id: {}", feedbackId);

        return new Response(ExceptionMsg.DELETE_SUCCESS);
    }


    /**
     * @param feedbackMap 问卷信息
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseData updateFeedback(@RequestBody Feedback feedbackMap) {
        String feedbackId = feedbackService.updateFeedback(feedbackMap);
        logger.warn("update feedback id: {}", feedbackId);
//        ZuccEchoMessage msg = new ZuccEchoMessage(ZuccEchoMessage.CATEGORY_FEEDBACK_CREATE);
//        msg.appendContent("FeedBack Submit",feedbackMap);
//        mqService.convertAndSend(Constants.QUE_SUB_QUEUE,msg);
//        feedbackService.updateFeedback(feedbackMap);
        return new ResponseData(ExceptionMsg.UPDATE_SUCCESS, feedbackMap);
    }
//    /**
//     * @param feedbackMap 问卷信息
//     * @return
//     */
//    @RequestMapping(value = "/submit", method = RequestMethod.PUT)
//    public ResponseData SubmitFeedback(@RequestBody Feedback feedbackMap) {
//        String feedbackId = feedbackService.updateFeedback(feedbackMap);
//        logger.warn("update feedback id: {}", feedbackId);
//        ZuccEchoMessage msg = new ZuccEchoMessage("FeedBack state rectify");
//        msg.appendContent("feedbackid",feedbackId);
//        msg.appendContent("msg","feedback info has rectified");
//        mqService.convertAndSend(Constants.QUE_SUB_QUEUE,msg);
//        return new ResponseData(ExceptionMsg.UPDATE_SUCCESS, feedbackMap);
//    }

    /**
     * 通过问卷ID获取问卷信息
     *
     * @param id 问卷ID
     * @return
     */
    @RequestMapping(value = "/viewFeedbackById", method = RequestMethod.GET)
    public ResponseData viewFeedbackById(@RequestParam("id") String id) {
        Feedback feedback = feedbackService.findById(id);
        logger.warn("query feedback id: {}", feedback.getFeedbackId());

        return new ResponseData(ExceptionMsg.QUERY_SUCCESS, feedback);

    }

    /**
     * 通过课程ID获取该课程的所有问卷
     *
     * @param courseId 课程ID
     * @return
     */
    @RequestMapping(value = "/viewFeedbacksByCourseId", method = RequestMethod.GET)
    public ResponseData viewFeedbacksByCourseId(@RequestParam("courseId") String courseId) {
        List<Feedback> feedback = feedbackService.findByCourseId(courseId);
        logger.warn("query feedbacks courseId: {}", courseId);

        return new ResponseData(ExceptionMsg.QUERY_SUCCESS, feedback);
    }

    /**
     * @return
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseData getAll() {
        List<Feedback> feedbackList = feedbackService.getAll();
        logger.warn("query all feedbacks");

        return new ResponseData(ExceptionMsg.QUERY_SUCCESS, feedbackList);
    }
}
