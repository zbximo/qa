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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData addFeedback(@RequestBody Feedback feedbackMap) throws Exception {
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

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Response deleteFeedback(@PathVariable("id") String id) {
        feedbackRepository.deleteByFeedbackId(id);
        return new Response(ExceptionMsg.SUCCESS);
    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseData updateFeedback(@RequestBody Feedback feedbackMap) throws Exception {
        feedbackRepository.save(feedbackMap);
        return new ResponseData(ExceptionMsg.SUCCESS, feedbackMap);
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public ResponseData findById(@PathVariable("id") String id) {
        Feedback feedback = feedbackRepository.findByFeedbackId(id);
        if (feedback != null) {
            return new ResponseData(ExceptionMsg.SUCCESS, feedback);
        }
        return new ResponseData(ExceptionMsg.FAILED, feedback);
    }

    @RequestMapping(value = "/findByCourseId/{courseid}", method = RequestMethod.GET)
    public ResponseData findByCourseId(@PathVariable("courseid") String courseid) {
        System.out.println(courseid);
        List<Feedback> feedback = feedbackRepository.find(courseid);
        if (feedback != null) {
            return new ResponseData(ExceptionMsg.SUCCESS, feedback);
        }
        return new ResponseData(ExceptionMsg.FAILED, feedback);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseData getAll() {
        List<Feedback> feedbackList = feedbackRepository.findAll();
        return new ResponseData(ExceptionMsg.SUCCESS, feedbackList);
    }
}
