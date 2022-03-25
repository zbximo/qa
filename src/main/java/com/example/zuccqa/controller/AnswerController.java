package com.example.zuccqa.controller;

import com.example.zuccqa.entity.Answer;
import com.example.zuccqa.repository.AnswerRepository;
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
 * @date: 2022/3/25 15:09
 * @description:
 */
@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private AnswerRepository answerRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData addAnswer(@RequestBody Answer answerMap) throws Exception {
        ObjectId id = new ObjectId();
        answerMap.setAnswerId(id.toString());
        Answer answer = new Answer();
        BeanUtils.copyProperties(answerMap, answer);
        answerRepository.save(answer);
        return new ResponseData(ExceptionMsg.SUCCESS, answer);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Response deleteAnswer(@PathVariable("id") String id) {
        answerRepository.deleteByAnswerId(id);
        return new Response(ExceptionMsg.SUCCESS);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseData updateAnswer(@RequestBody Answer answerMap) {
        answerRepository.save(answerMap);
        return new ResponseData(ExceptionMsg.SUCCESS, answerMap);
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public ResponseData findById(@PathVariable("id") String id) {
        Answer answer = answerRepository.findByAnswerId(id);
        if (answer != null) {
            return new ResponseData(ExceptionMsg.SUCCESS, answer);
        }
        return new ResponseData(ExceptionMsg.FAILED, answer);
    }

    @RequestMapping(value = "/find/{userId}", method = RequestMethod.GET)
    public ResponseData findByUserAndFeedback(@PathVariable("userId") String userId) {
        Answer answer = answerRepository.UserId(userId);
        if (answer != null) {
            return new ResponseData(ExceptionMsg.SUCCESS, answer);
        }
        return new ResponseData(ExceptionMsg.FAILED, answer);
    }

    @RequestMapping(value = "/find/{feedbackId}", method = RequestMethod.GET)
    public ResponseData findByFeedback(@PathVariable("feedbackId") String feedbackId) {
        Answer answer = answerRepository.UserId(feedbackId);
        if (answer != null) {
            return new ResponseData(ExceptionMsg.SUCCESS, answer);
        }
        return new ResponseData(ExceptionMsg.FAILED, answer);
    }

    @RequestMapping(value = "/find/{userId}/{feedbackId}", method = RequestMethod.GET)
    public ResponseData findByUserAndFeedback(@PathVariable("userId") String userId,
                                              @PathVariable("feedbackId") String feedbackId) {
        Answer answer = answerRepository.UserIdAndFeedbackId(userId, feedbackId);
        if (answer != null) {
            return new ResponseData(ExceptionMsg.SUCCESS, answer);
        }
        return new ResponseData(ExceptionMsg.FAILED, answer);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseData getAll() {
        List<Answer> answerList = answerRepository.findAll();
        return new ResponseData(ExceptionMsg.SUCCESS, answerList);
    }

}
