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

    /**
     * @desc 添加一个问卷填写表
     *
     * @param answerMap 问卷填写表
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData addAnswer(@RequestBody Answer answerMap) {
        ObjectId id = new ObjectId();
        answerMap.setAnswerId(id.toString());
        Answer answer = new Answer();
        BeanUtils.copyProperties(answerMap, answer);
        answerRepository.save(answer);
        return new ResponseData(ExceptionMsg.SUCCESS, answer);
    }

    /**
     * @param id 问卷填写表ID
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Response deleteAnswer(@RequestParam("id") String id) {
        answerRepository.deleteByAnswerId(id);
        return new Response(ExceptionMsg.SUCCESS);
    }

    /**
     * @param answerMap 问卷填写表信息
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseData updateAnswer(@RequestBody Answer answerMap) {
        answerRepository.save(answerMap);
        return new ResponseData(ExceptionMsg.SUCCESS, answerMap);
    }

    /**
     * @param id 问卷填写表ID
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public ResponseData findById(@RequestParam("id") String id) {
        Answer answer = answerRepository.findByAnswerId(id);
        if (answer != null) {
            return new ResponseData(ExceptionMsg.SUCCESS, answer);
        }
        return new ResponseData(ExceptionMsg.FAILED, answer);
    }

    /**
     * @param userId 用户ID
     * @return
     */
    @RequestMapping(value = "/findByUserId", method = RequestMethod.GET)
    public ResponseData findByUserId(@RequestParam("userId") String userId) {
        Answer answer = answerRepository.UserId(userId);
        if (answer != null) {
            return new ResponseData(ExceptionMsg.SUCCESS, answer);
        }
        return new ResponseData(ExceptionMsg.FAILED, answer);
    }

    /**
     * @param feedbackId 问卷ID
     * @return
     */
    @RequestMapping(value = "/findByFeedbackId", method = RequestMethod.GET)
    public ResponseData findByFeedbackId(@RequestParam("feedbackId") String feedbackId) {
        Answer answer = answerRepository.UserId(feedbackId);
        if (answer != null) {
            return new ResponseData(ExceptionMsg.SUCCESS, answer);
        }
        return new ResponseData(ExceptionMsg.FAILED, answer);
    }

    /**
     * @param userId     用户ID
     * @param feedbackId 问卷ID
     * @return
     */
    @RequestMapping(value = "/findByUserAndFeedback", method = RequestMethod.GET)
    public ResponseData findByUserIdAndFeedbackId(@RequestParam("userId") String userId,
                                              @RequestParam("feedbackId") String feedbackId) {
        Answer answer = answerRepository.UserIdAndFeedbackId(userId, feedbackId);
        if (answer != null) {
            return new ResponseData(ExceptionMsg.SUCCESS, answer);
        }
        return new ResponseData(ExceptionMsg.FAILED, answer);
    }

    /**
     * @return
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseData getAll() {
        List<Answer> answerList = answerRepository.findAll();
        return new ResponseData(ExceptionMsg.SUCCESS, answerList);
    }

}
