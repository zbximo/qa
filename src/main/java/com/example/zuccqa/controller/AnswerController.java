package com.example.zuccqa.controller;

import com.example.zuccqa.entity.AnswerSheet;
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
     * @param answerSheetMap 问卷填写表
     * @return
     * @desc 添加一个问卷填写表
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData addAnswer(@RequestBody AnswerSheet answerSheetMap) {
//        System.out.println(answerMap.getUser().getId()+" "+
//                answerMap.getFeedback().getFeedbackId());
//        Answer answer = new Answer();
//        ObjectId id = new ObjectId();
//        answerMap.setAnswerId(id.toString());
//        BeanUtils.copyProperties(answerMap, answer);
//        answerRepository.save(answer);
//        return new ResponseData(ExceptionMsg.SUCCESS, answer);

        AnswerSheet answerSheet = answerRepository.UserIdAndFeedbackId(answerSheetMap.getStudentId(),
                answerSheetMap.getFeedbackId());
        if (answerSheet == null) {
            ObjectId id = new ObjectId();
            answerSheetMap.setAnswerSheetId(id.toString());
            BeanUtils.copyProperties(answerSheetMap, answerSheet);
            answerRepository.save(answerSheet);
            return new ResponseData(ExceptionMsg.SUCCESS, answerSheet);
        } else {
            answerRepository.save(answerSheetMap);
            return new ResponseData(ExceptionMsg.SUCCESS, answerSheetMap);
        }

    }

    /**
     * @param id 问卷填写表ID
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Response deleteAnswer(@RequestParam("id") String id) {
        answerRepository.deleteByAnswerSheetId(id);
        return new Response(ExceptionMsg.SUCCESS);
    }

    /**
     * @param answerSheetMap 问卷填写表信息
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseData updateAnswer(@RequestBody AnswerSheet answerSheetMap) {
        answerRepository.save(answerSheetMap);
        return new ResponseData(ExceptionMsg.SUCCESS, answerSheetMap);
    }

    /**
     * @param id 问卷填写表ID
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public ResponseData findById(@RequestParam("id") String id) {
        AnswerSheet answerSheet = answerRepository.findByAnswerId(id);
        if (answerSheet != null) {
            return new ResponseData(ExceptionMsg.SUCCESS, answerSheet);
        }
        return new ResponseData(ExceptionMsg.FAILED, answerSheet);
    }

    /**
     * @param userId 用户ID
     * @return
     */
    @RequestMapping(value = "/findByUserId", method = RequestMethod.GET)
    public ResponseData findByUserId(@RequestParam("userId") String userId) {
        AnswerSheet answerSheet = answerRepository.UserId(userId);
        if (answerSheet != null) {
            return new ResponseData(ExceptionMsg.SUCCESS, answerSheet);
        }
        return new ResponseData(ExceptionMsg.FAILED, answerSheet);
    }

    /**
     * @param feedbackId 问卷ID
     * @return
     */
    @RequestMapping(value = "/findByFeedbackId", method = RequestMethod.GET)
    public ResponseData findByFeedbackId(@RequestParam("feedbackId") String feedbackId) {
        AnswerSheet answerSheet = answerRepository.FeedbackId(feedbackId);
        if (answerSheet != null) {
            return new ResponseData(ExceptionMsg.SUCCESS, answerSheet);
        }
        return new ResponseData(ExceptionMsg.FAILED, answerSheet);
    }

    /**
     * @param userId     用户ID
     * @param feedbackId 问卷ID
     * @return
     */
    @RequestMapping(value = "/findByUserAndFeedback", method = RequestMethod.GET)
    public ResponseData findByUserIdAndFeedbackId(@RequestParam("userId") String userId,
                                                  @RequestParam("feedbackId") String feedbackId) {
        AnswerSheet answerSheet = answerRepository.UserIdAndFeedbackId(userId, feedbackId);
        if (answerSheet != null) {
            return new ResponseData(ExceptionMsg.SUCCESS, answerSheet);
        }
        return new ResponseData(ExceptionMsg.FAILED, answerSheet);
    }

    /**
     * @return
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseData getAll() {
        List<AnswerSheet> answerSheetList = answerRepository.findAll();
        return new ResponseData(ExceptionMsg.SUCCESS, answerSheetList);
    }

}
