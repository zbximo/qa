package com.example.zuccqa.controller;

import com.example.zuccqa.entity.Feedback;
import com.example.zuccqa.result.ExceptionMsg;
import com.example.zuccqa.result.Response;
import com.example.zuccqa.result.ResponseData;
import com.example.zuccqa.service.FeedbackService;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * @param feedbackMap 问卷信息
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData addFeedback(@RequestBody Feedback feedbackMap) {
        String feedbackId = feedbackService.addFeedback(feedbackMap);
        logger.warn("create feedback id: {}", feedbackId);
        return new ResponseData(ExceptionMsg.SUCCESS, feedbackId);
    }

    /**
     * @param id 问卷ID
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Response deleteFeedback(@RequestParam("id") String id) {
        String feedbackId = feedbackService.deleteFeedback(id);
        logger.warn("delete feedback id: {}", feedbackId);

        return new Response(ExceptionMsg.SUCCESS);
    }


    /**
     * @param feedbackMap 问卷信息
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseData updateFeedback(@RequestBody Feedback feedbackMap) {
        String feedbackId = feedbackService.updateFeedback(feedbackMap);
        logger.warn("update feedback id: {}", feedbackId);

        return new ResponseData(ExceptionMsg.SUCCESS, feedbackMap);
    }

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

        return new ResponseData(ExceptionMsg.SUCCESS, feedback);

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

        return new ResponseData(ExceptionMsg.SUCCESS, feedback);
    }

    /**
     * @return
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseData getAll() {
        List<Feedback> feedbackList = feedbackService.getAll();
        logger.warn("query all feedbacks");

        return new ResponseData(ExceptionMsg.SUCCESS, feedbackList);
    }
}
