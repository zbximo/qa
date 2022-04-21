package com.example.zuccqa.impl;

import com.example.zuccqa.entity.AnswerSheet;
import com.example.zuccqa.entity.Feedback;
import com.example.zuccqa.entity.User;
import com.example.zuccqa.exception.BusinessException;
import com.example.zuccqa.repository.AnswerSheetRepository;
import com.example.zuccqa.repository.FeedbackRepository;
import com.example.zuccqa.repository.UserRepository;
import com.example.zuccqa.service.AnswerSheetService;
import com.example.zuccqa.service.FeedbackService;
import com.example.zuccqa.utils.Constant;
import org.bson.types.ObjectId;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

/**
 * @author: ximo
 * @date: 2022/4/17 14:15
 * @description:
 */
@Service
public class AnswerSheetServiceImpl implements AnswerSheetService {
    @Autowired
    private AnswerSheetRepository answerSheetRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private FeedbackService feedbackService;

    /**
     * @param answerSheetMap 问卷填写表
     * @return
     * @desc 添加一个问卷填写表
     */
    @Override
    public String addAnswerSheet(AnswerSheet answerSheetMap) {
        AnswerSheet answerSheet = new AnswerSheet();
        BeanUtils.copyProperties(answerSheetMap, answerSheet);
        if (answerSheet.getStudentId() == null || answerSheet.getStudentId().equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "缺少用户ID");
        }
        if (answerSheet.getFeedbackId() == null || answerSheet.getFeedbackId().equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "缺少问卷ID");
        }
        Date date = new Date(System.currentTimeMillis());
        if (date.after(feedbackRepository.findByFeedbackId(answerSheet.getFeedbackId()).getEndTime())) {
            throw new BusinessException(Constant.PARAM_ERROR, "问卷已关闭");
        }
        checkAnswer(answerSheet);
        // 查看是否已经提交过答卷
        AnswerSheet answerSheet1 = answerSheetRepository.UserIdAndFeedbackId(answerSheet.getStudentId(), answerSheet.getFeedbackId());
        // 更新cache
        feedbackService.FinishedCache(answerSheet.getFeedbackId(),
                feedbackService.findById(answerSheet.getFeedbackId()).getFeedbackCourseId(), answerSheet.getStudentId());
        if (answerSheet1 != null) {
            answerSheet.setAnswerSheetId(answerSheet1.getAnswerSheetId());
            return updateAnswerSheet(answerSheet);
        }

        ObjectId id = new ObjectId();
        answerSheet.setAnswerSheetId(id.toString());

        answerSheet.setSubmitDate(date);
        answerSheetRepository.save(answerSheet);

        return answerSheet.getAnswerSheetId();

    }

    /**
     * @param answerSheet 需要检查回答的答卷
     */
    public void checkAnswer(AnswerSheet answerSheet) {
        if (answerSheet.getAnswers() != null) {
            answerSheet.getAnswers().stream().forEach(
                    answers -> {
                        if (answers.getIsRequired() == 1 && answers.getOptions().size() == 0) {
                            throw new BusinessException(300000, "必答题没有回答");
                        }
                    }
            );
        }
    }

    /**
     * @param id 问卷填写表ID
     * @return
     */
    @Override
    public String deleteAnswerSheet(String id) {
        if (id.equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "缺少答卷ID");
        }
        if (answerSheetRepository.findByAnswerSheetId(id) == null) {
            throw new BusinessException(Constant.PARAM_ERROR, "未找到该答卷,答卷ID: " + id);
        }
        answerSheetRepository.deleteByAnswerSheetId(id);
        return id;
    }

    /**
     * @param answerSheetMap 问卷填写表信息
     * @return
     */
    @Override
    public String updateAnswerSheet(AnswerSheet answerSheetMap) {
        AnswerSheet answerSheet = new AnswerSheet();
        BeanUtils.copyProperties(answerSheetMap, answerSheet);
        if (answerSheet.getAnswerSheetId() == null || answerSheet.getAnswerSheetId().equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "缺少答卷ID");
        }
        if (answerSheetRepository.findByAnswerSheetId(answerSheet.getAnswerSheetId()) == null) {
            throw new BusinessException(Constant.PARAM_ERROR, "未找到该答卷,答卷ID: " + answerSheet.getAnswerSheetId());
        }
        checkAnswer(answerSheet);
        answerSheetRepository.save(answerSheet);
        return answerSheet.getAnswerSheetId();
    }

    /**
     * @param id 问卷填写表ID
     * @return
     */
    public AnswerSheet findById(String id) {
        if (id.equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "缺少答卷ID");
        }
        AnswerSheet answerSheet = answerSheetRepository.findByAnswerSheetId(id);
        if (answerSheet == null) {
            throw new BusinessException(Constant.PARAM_ERROR, "未找到该答卷,答卷ID: " + id);
        }
        return answerSheet;

    }

    /**
     * @param userId 用户ID
     * @return
     */
    public List<AnswerSheet> findByUserId(String userId) {
        if (userId.equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "缺少用户ID");
        }
        if (userRepository.findById(userId) == null) {
            throw new BusinessException(Constant.PARAM_ERROR, "未找到该用户,ID: " + userId);
        }
        List<AnswerSheet> answerSheetList = answerSheetRepository.UserId(userId);
        if (answerSheetList.size() == 0) {
            throw new BusinessException(Constant.PARAM_ERROR, "未找到该用户的答卷, 用户ID: " + userId);
        }
        return answerSheetList;
    }

    /**
     * @param feedbackId 问卷ID
     * @return
     */
    public List<AnswerSheet> findByFeedbackId(String feedbackId) {
        if (feedbackId.equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "缺少问卷ID");
        }
        if (feedbackRepository.findByFeedbackId(feedbackId) == null) {
            throw new BusinessException(Constant.PARAM_ERROR, "未找到该问卷, 问卷ID: " + feedbackId);
        }
        List<AnswerSheet> answerSheetList = answerSheetRepository.FeedbackId(feedbackId);
        if (answerSheetList.size() == 0) {
            throw new BusinessException(Constant.PARAM_ERROR, "未找到该问卷的答卷, 问卷ID: " + feedbackId);
        }
        return answerSheetList;
    }

    /**
     * @param userId     用户ID
     * @param feedbackId 问卷ID
     * @return
     */
    public AnswerSheet findByUserIdAndFeedbackId(String userId, String feedbackId) {
        if (userId.equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "缺少用户ID");
        }
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new BusinessException(Constant.PARAM_ERROR, "未找到该用户,用户ID: " + userId);
        }
        if (feedbackId.equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "缺少问卷ID");
        }
        Feedback feedback = feedbackRepository.findByFeedbackId(feedbackId);
        if (feedback == null) {
            throw new BusinessException(Constant.PARAM_ERROR, "未找到该问卷,问卷ID: " + feedbackId);
        }
        AnswerSheet answerSheet = answerSheetRepository.UserIdAndFeedbackId(userId, feedbackId);
        if (answerSheet == null) {
            throw new BusinessException(Constant.PARAM_ERROR, "未找到该答卷,用户ID: " + userId + " 问卷ID: " + feedbackId);
        }
        return answerSheet;
    }

    /**
     * @return
     */
    public List<AnswerSheet> getAll() {
        return answerSheetRepository.findAll();
    }
}
