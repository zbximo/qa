package com.example.zuccqa.controller;

import com.example.zuccqa.entity.AnswerSheet;
import com.example.zuccqa.result.ExceptionMsg;
import com.example.zuccqa.result.Response;
import com.example.zuccqa.result.ResponseData;
import com.example.zuccqa.service.AnswerSheetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(AnswerSheetController.class);
    @Autowired
    private AnswerSheetService answerSheetService;


    /**
     * @param answerSheetMap 问卷填写表
     * @return
     * @desc 添加一个问卷填写表
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData submitAnswerSheet(@RequestBody AnswerSheet answerSheetMap) {

        String answerSheetId = answerSheetService.addAnswerSheet(answerSheetMap);
        logger.warn("create answerSheet answerSheetId: {}", answerSheetId);

        return new ResponseData(ExceptionMsg.CREATE_SUCCESS, answerSheetId);

    }

    /**
     * @param id 问卷填写表ID
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Response deleteAnswerSheet(@RequestParam("id") String id) {

        String answerSheetId = answerSheetService.deleteAnswerSheet(id);
        logger.warn("delete answerSheets answerSheetId: {}", answerSheetId);

        return new Response(ExceptionMsg.DELETE_SUCCESS);
    }

    /**
     * @param answerSheetMap 问卷填写表信息
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseData updateAnswerSheet(@RequestBody AnswerSheet answerSheetMap) {
        String answerSheetId = answerSheetService.updateAnswerSheet(answerSheetMap);
        logger.warn("update answerSheets answerSheetId: {}", answerSheetId);

        return new ResponseData(ExceptionMsg.UPDATE_SUCCESS, answerSheetMap);
    }

    /**
     * 通过答卷ID查看答卷
     *
     * @param id 问卷填写表ID
     * @return
     */
    @RequestMapping(value = "/viewAnswerSheetById", method = RequestMethod.GET)
    public ResponseData viewAnswerSheetById(@RequestParam("id") String id) {

        AnswerSheet answerSheet = answerSheetService.findById(id);
        logger.warn("query answerSheets answerSheetId: {}", id);

        return new ResponseData(ExceptionMsg.QUERY_SUCCESS, answerSheet);

    }

    /**
     * 通过用户ID查看该用户的所有答卷
     *
     * @param userId 用户ID
     * @return
     */
    @RequestMapping(value = "/viewAnswerSheetByUserId", method = RequestMethod.GET)
    public ResponseData findByUserId(@RequestParam("userId") String userId) {

        List<AnswerSheet> answerSheetList = answerSheetService.findByUserId(userId);
        logger.warn("query answerSheets userId: {}", userId);

        return new ResponseData(ExceptionMsg.QUERY_SUCCESS, answerSheetList);
    }

    /**
     * 通过问卷ID查看该问卷的所有答卷
     *
     * @param feedbackId 问卷ID
     * @return
     */
    @RequestMapping(value = "/viewAnswerSheetsByFeedbackId", method = RequestMethod.GET)
    public ResponseData findByFeedbackId(@RequestParam("feedbackId") String feedbackId) {

        List<AnswerSheet> answerSheetList = answerSheetService.findByFeedbackId(feedbackId);
        logger.warn("query answerSheets feedbackId: {}", feedbackId);
        return new ResponseData(ExceptionMsg.QUERY_SUCCESS, answerSheetList);
    }

    /**
     * 通过用户ID和问卷ID查看某个人的某个问卷的答卷
     *
     * @param userId     用户ID
     * @param feedbackId 问卷ID
     * @return
     */
    @RequestMapping(value = "/viewAnswerSheetByUserAndFeedback", method = RequestMethod.GET)
    public ResponseData getOneAnswerSheet(@RequestParam("userId") String userId,
                                          @RequestParam("feedbackId") String feedbackId) {

        AnswerSheet answerSheet = answerSheetService.findByUserIdAndFeedbackId(userId, feedbackId);
        logger.warn("query answerSheet userId: {},feedbackId: {}", userId, feedbackId);
        return new ResponseData(ExceptionMsg.QUERY_SUCCESS, answerSheet);
    }

    /**
     * 获取所有答卷
     *
     * @return
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseData getAll() {
        List<AnswerSheet> answerSheetList = answerSheetService.getAll();
        logger.warn("query answerSheets");
        return new ResponseData(ExceptionMsg.QUERY_SUCCESS, answerSheetList);
    }

}
