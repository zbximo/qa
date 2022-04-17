package com.example.zuccqa.controller;

import com.example.zuccqa.entity.AnswerSheet;
import com.example.zuccqa.repository.AnswerSheetRepository;
import com.example.zuccqa.result.ExceptionMsg;
import com.example.zuccqa.result.Response;
import com.example.zuccqa.result.ResponseData;
import jdk.nashorn.internal.runtime.options.LoggingOption;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class AnswerSheetController {
    @Autowired
    private AnswerSheetRepository answerSheetRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * @param answerSheetMap 问卷填写表
     * @return
     * @desc 添加一个问卷填写表
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData addAnswerSheet(@RequestBody AnswerSheet answerSheetMap) {
        if (answerSheetMap.getStudentId().equals("")){
            return new ResponseData("100000","缺少用户ID");
        }
        if (answerSheetMap.getFeedbackId().equals("")){
            return new ResponseData("100000","缺少问卷ID");
        }
        AnswerSheet answerSheet = answerSheetRepository.UserIdAndFeedbackId(answerSheetMap.getStudentId(),
                answerSheetMap.getFeedbackId());
        if (answerSheet == null) {
            answerSheet = new AnswerSheet();
            ObjectId id = new ObjectId();
            answerSheetMap.setAnswerSheetId(id.toString());
            BeanUtils.copyProperties(answerSheetMap, answerSheet);
            answerSheetRepository.save(answerSheet);
            return new ResponseData(ExceptionMsg.SUCCESS, answerSheet);
        } else {
            answerSheetRepository.save(answerSheetMap);
            return new ResponseData(ExceptionMsg.SUCCESS, answerSheetMap);
        }

    }

    /**
     * @param id 问卷填写表ID
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Response deleteAnswerSheet(@RequestParam("id") String id) {
        if (id.equals("")){
            return new ResponseData("100000","缺少答卷ID");
        }
        answerSheetRepository.deleteByAnswerSheetId(id);
        return new Response(ExceptionMsg.SUCCESS);
    }

    /**
     * @param answerSheetMap 问卷填写表信息
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseData updateAnswerSheet(@RequestBody AnswerSheet answerSheetMap) {
        if (answerSheetMap.getAnswerSheetId().equals("")){
            return new ResponseData("100000","缺少答卷ID");
        }
        answerSheetRepository.save(answerSheetMap);
        return new ResponseData(ExceptionMsg.SUCCESS, answerSheetMap);
    }

    /**
     * @param id 问卷填写表ID
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public ResponseData findById(@RequestParam("id") String id) {
        if (id.equals("")){
            return new ResponseData("100000","缺少答卷ID");
        }
        AnswerSheet answerSheet = answerSheetRepository.findByAnswerSheetId(id);
        if (answerSheet != null) {
            return new ResponseData(ExceptionMsg.SUCCESS, answerSheet);
        }
        return new ResponseData(ExceptionMsg.QueryEmpty);
    }

    /**
     * @param userId 用户ID
     * @return
     */
    @RequestMapping(value = "/findByUserId", method = RequestMethod.GET)
    public ResponseData findByUserId(@RequestParam("userId") String userId) {
        if (userId.equals("")){
            return new ResponseData("100000","缺少用户ID");
        }
        List<AnswerSheet> answerSheetList = answerSheetRepository.UserId(userId);
        if (answerSheetList.size() > 0) {
            return new ResponseData(ExceptionMsg.SUCCESS, answerSheetList);
        }
        return new ResponseData(ExceptionMsg.QueryEmpty);
    }

    /**
     * @param feedbackId 问卷ID
     * @return
     */
    @RequestMapping(value = "/findByFeedbackId", method = RequestMethod.GET)
    public ResponseData findByFeedbackId(@RequestParam("feedbackId") String feedbackId) {
        if (feedbackId.equals("")){
            return new ResponseData("100000","缺少问卷ID");
        }
        List<AnswerSheet> answerSheetList = answerSheetRepository.FeedbackId(feedbackId);
        if (answerSheetList.size() > 0) {
            return new ResponseData(ExceptionMsg.SUCCESS, answerSheetList);
        }
        return new ResponseData(ExceptionMsg.QueryEmpty);
    }

    /**
     * @param userId     用户ID
     * @param feedbackId 问卷ID
     * @return
     */
    @RequestMapping(value = "/findByUserAndFeedback", method = RequestMethod.GET)
    public ResponseData findByUserIdAndFeedbackId(@RequestParam("userId") String userId,
                                                  @RequestParam("feedbackId") String feedbackId) {
        if (userId.equals("")){
            return new ResponseData("100000","缺少用户ID");
        }
        if (feedbackId.equals("")){
            return new ResponseData("100000","缺少问卷ID");
        }
        AnswerSheet answerSheet = answerSheetRepository.UserIdAndFeedbackId(userId, feedbackId);
        if (answerSheet != null) {
            return new ResponseData(ExceptionMsg.SUCCESS, answerSheet);
        }
        return new ResponseData(ExceptionMsg.QueryEmpty);
    }

    /**
     * @return
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseData getAll() {
        List<AnswerSheet> answerSheetList = answerSheetRepository.findAll();
        return new ResponseData(ExceptionMsg.SUCCESS, answerSheetList);
    }

}
