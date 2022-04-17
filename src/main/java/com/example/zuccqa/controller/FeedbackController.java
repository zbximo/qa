package com.example.zuccqa.controller;

import com.example.zuccqa.entity.Feedback;
import com.example.zuccqa.repository.FeedbackRepository;
import com.example.zuccqa.result.ExceptionMsg;
import com.example.zuccqa.result.Response;
import com.example.zuccqa.result.ResponseData;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
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
    @Autowired
    private FeedbackRepository feedbackRepository;

    /**
     * @param feedbackMap 问卷信息
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData addFeedback(@RequestBody Feedback feedbackMap) {
        if (feedbackMap == null) {
            return new ResponseData(ExceptionMsg.FAILED, "");
        }
        ObjectId id = new ObjectId();
        feedbackMap.setFeedbackId(id.toString());
        Feedback feedback = new Feedback();
        BeanUtils.copyProperties(feedbackMap, feedback);
        feedbackRepository.save(feedback);
        return new ResponseData(ExceptionMsg.SUCCESS, feedback);
    }

    /**
     * @param id 问卷ID
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Response deleteFeedback(@RequestParam("id") String id) {
        feedbackRepository.deleteByFeedbackId(id);
        return new Response(ExceptionMsg.SUCCESS);
    }


    /**
     * @param feedbackMap 问卷信息
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseData updateFeedback(@RequestBody Feedback feedbackMap) {
        feedbackRepository.save(feedbackMap);
        return new ResponseData(ExceptionMsg.SUCCESS, feedbackMap);
    }

    /**
     * @param id 问卷ID
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public ResponseData findById(@RequestParam("id") String id) {
        Feedback feedback = feedbackRepository.findByFeedbackId(id);
        if (feedback != null) {
            return new ResponseData(ExceptionMsg.SUCCESS, feedback);
        }
        return new ResponseData(ExceptionMsg.QueryEmpty, "");
    }

    /**
     * @param courseId 课程ID
     * @return
     */
    @RequestMapping(value = "/findByCourseId", method = RequestMethod.GET)
    public ResponseData findByCourseId(@RequestParam("courseId") String courseId) {
        System.out.println(courseId);
        List<Feedback> feedback = feedbackRepository.find(courseId);
        if (feedback.size() > 0) {
            return new ResponseData(ExceptionMsg.SUCCESS, feedback);
        }
        return new ResponseData(ExceptionMsg.QueryEmpty, "");
    }

    /**
     * @return
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseData getAll() {
        List<Feedback> feedbackList = feedbackRepository.findAll();
        return new ResponseData(ExceptionMsg.SUCCESS, feedbackList);
    }
}
