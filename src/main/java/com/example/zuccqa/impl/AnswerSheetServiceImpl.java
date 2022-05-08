package com.example.zuccqa.impl;

import com.example.zuccqa.entity.*;
import com.example.zuccqa.exception.BusinessException;
import com.example.zuccqa.form.AnswerSheetDto;
import com.example.zuccqa.mq.ZuccEchoMessage;
import com.example.zuccqa.repository.AnswerSheetRepository;
import com.example.zuccqa.repository.CourseRepository;
import com.example.zuccqa.repository.FeedbackRepository;
import com.example.zuccqa.repository.UserRepository;
import com.example.zuccqa.service.AnswerSheetService;
import com.example.zuccqa.service.FeedbackService;
import com.example.zuccqa.utils.Constants;
import org.bson.types.ObjectId;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
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
    private CourseRepository courseRepository;
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private AmqpTemplate mqService;
    @Qualifier("direct")
    @Autowired
    private DirectExchange directExchange;


    private final ZuccEchoMessage logWarn = new ZuccEchoMessage(ZuccEchoMessage.LOG_WARN);
    private final ZuccEchoMessage logError = new ZuccEchoMessage(ZuccEchoMessage.LOG_ERROR);
    private final ZuccEchoMessage logInfo = new ZuccEchoMessage(ZuccEchoMessage.LOG_INFO);

    /**
     * 发送问卷后，每个人建立一份空白答卷。
     *
     * @param feedback 模板
     * @return
     */
    public void addBlankAnswerSheets(Feedback feedback) {
        String fbId = feedback.getFeedbackId();
        Course course = courseRepository.findByCourseId(feedback.getFeedbackCourseId());
        for (String Uid : course.getStudentIdList()) {
            AnswerSheet answerSheet = new AnswerSheet();
            ObjectId id = new ObjectId();
            answerSheet.setAnswerSheetId(id.toString());
            answerSheet.setFeedbackId(fbId);
            answerSheet.setStudentId(Uid);
            answerSheetRepository.save(answerSheet);
        }
        logInfo.appendContent("blankSheets create fbId: ",fbId);
        mqService.convertAndSend(directExchange.getName(), Constants.KEY_INFO, logInfo);
    }

    /**
     * 该功能可能没用了了。
     *
     * @param answerSheetDto 问卷填写表
     * @return
     * @desc 添加一个问卷填写表
     */
    @Override
    public String addAnswerSheet(AnswerSheetDto answerSheetDto) {

        checkAnswer(answerSheetDto);
        // 查看是否已经提交过答卷
        AnswerSheet answerSheet = answerSheetRepository.UserIdAndFeedbackId(answerSheetDto.getStudentId(),
                answerSheetDto.getFeedbackId());
        // 更新cache
        feedbackService.FinishedCache(answerSheetDto.getFeedbackId(),
                feedbackService.findById(answerSheetDto.getFeedbackId()).getFeedbackCourseId(), answerSheetDto.getStudentId());
        if (answerSheet != null) {
            answerSheetDto.setAnswerSheetId(answerSheet.getAnswerSheetId());
            return updateAnswerSheet(answerSheetDto);
        }
        answerSheet = new AnswerSheet();
        BeanUtils.copyProperties(answerSheetDto, answerSheet);
        ObjectId id = new ObjectId();
        answerSheet.setAnswerSheetId(id.toString());
        Date date = new Date(System.currentTimeMillis());
        answerSheet.setSubmitDate(date);
        answerSheetRepository.save(answerSheet);

        return answerSheet.getAnswerSheetId();

    }

    /**
     * @param answerSheetDto 需要检查回答的答卷
     */
    public void checkAnswer(AnswerSheetDto answerSheetDto) {
        if (answerSheetDto.getStudentId() == null || answerSheetDto.getStudentId().equals("")) {
            logError.appendContent("answer sheet don't have userId","");
//        logger.warn("create answerSheet answerSheetId: {}", answerSheetId);
            mqService.convertAndSend(directExchange.getName(), Constants.KEY_FATAL, logError);
            throw new BusinessException(Constants.PARAM_ERROR, "缺少用户ID");
        }
        if (answerSheetDto.getFeedbackId() == null || answerSheetDto.getFeedbackId().equals("")) {
            throw new BusinessException(Constants.PARAM_ERROR, "缺少问卷ID");
        }

        if (feedbackRepository.findByFeedbackId(answerSheetDto.getFeedbackId()).getFeedbackStatus() == 0) {
            throw new BusinessException(Constants.PARAM_ERROR, "问卷在关闭状态");
        }

    }

    /**
     * @param id 问卷填写表ID
     * @return
     */
    @Override
    public String deleteAnswerSheet(String id) {
        if (id.equals("")) {
            throw new BusinessException(Constants.PARAM_ERROR, "缺少答卷ID");
        }
        if (answerSheetRepository.findByAnswerSheetId(id) == null) {
            throw new BusinessException(Constants.PARAM_ERROR, "未找到该答卷,答卷ID: " + id);
        }
        answerSheetRepository.deleteByAnswerSheetId(id);
        return id;
    }

    /**
     * 用户提交答卷接口 (在此)
     *
     * @param answerSheetDto 答卷信息
     * @return
     */
    @Override
    public String updateAnswerSheet(AnswerSheetDto answerSheetDto) {
        checkAnswer(answerSheetDto);
        if (answerSheetDto.getAnswerSheetId() == null || answerSheetDto.getAnswerSheetId().equals("")) {
            throw new BusinessException(Constants.PARAM_ERROR, "缺少答卷ID");
        }
        if (answerSheetRepository.findByAnswerSheetId(answerSheetDto.getAnswerSheetId()) == null) {
            throw new BusinessException(Constants.PARAM_ERROR, "未找到该答卷,答卷ID: " + answerSheetDto.getAnswerSheetId());
        }
        // 检查回答情况
        if (answerSheetDto.getQuestionList() != null) {
            if (answerSheetDto.getQuestionList().size() > answerSheetDto.getAnswerList().size()) {
                throw new BusinessException(300000, "有题目未回答");
            }
            for (int i = 0; i < answerSheetDto.getQuestionList().size(); i++) {
                if (answerSheetDto.getQuestionList().get(i).getIsRequired() == 1 && answerSheetDto.getAnswerList().get(i).size() == 0) {
                    throw new BusinessException(300000, "必答题没有回答");
                }
            }
        }
        AnswerSheet answerSheet = new AnswerSheet();
        BeanUtils.copyProperties(answerSheetDto, answerSheet);
        answerSheetRepository.save(answerSheet);
        logWarn.appendContent("answerSheet  submit answerSheetId", answerSheetDto.getAnswerSheetId());
//        logger.warn("create answerSheet answerSheetId: {}", answerSheetId);
        mqService.convertAndSend(directExchange.getName(), Constants.KEY_WARN, logWarn);
        return answerSheet.getAnswerSheetId();
    }

    /**
     * AnswerSheet 转 AnswerSheetDto
     *
     * @param answerSheet
     * @return
     */
    public AnswerSheetDto getAnswerSheetDtoByFbId(AnswerSheet answerSheet) {
        AnswerSheetDto answerSheetDto = new AnswerSheetDto();
        BeanUtils.copyProperties(answerSheet, answerSheetDto);
        answerSheetDto.setQuestionList(feedbackRepository.findByFeedbackId(answerSheet.getFeedbackId()).getQuestionList());
        return answerSheetDto;
    }

    /**
     * @param id 问卷填写表ID
     * @return
     */
    public AnswerSheetDto findById(String id) {
        if (id.equals("")) {
            throw new BusinessException(Constants.PARAM_ERROR, "缺少答卷ID");
        }
        AnswerSheet answerSheet = answerSheetRepository.findByAnswerSheetId(id);
        if (answerSheet == null) {
            throw new BusinessException(Constants.PARAM_ERROR, "未找到该答卷,答卷ID: " + id);
        }
        return getAnswerSheetDtoByFbId(answerSheet);

    }

    /**
     * @param userId 用户ID
     * @return
     */
    public List<AnswerSheetDto> findByUserId(String userId) {
        if (userId.equals("")) {
            throw new BusinessException(Constants.PARAM_ERROR, "缺少用户ID");
        }
        if (userRepository.findById(userId) == null) {
            throw new BusinessException(Constants.PARAM_ERROR, "未找到该用户,ID: " + userId);
        }
        List<AnswerSheet> answerSheetList = answerSheetRepository.UserId(userId);

        if (answerSheetList.size() == 0) {
            throw new BusinessException(Constants.PARAM_ERROR, "未找到该用户的答卷, 用户ID: " + userId);
        }
        List<AnswerSheetDto> answerSheetDtoList = new ArrayList<>();
        for (AnswerSheet answerSheet : answerSheetList) {
            answerSheetDtoList.add(getAnswerSheetDtoByFbId(answerSheet));
        }
        return answerSheetDtoList;
    }

    /**
     * @param feedbackId 问卷ID
     * @return
     */
    public List<AnswerSheetDto> findByFeedbackId(String feedbackId) {
        if (feedbackId.equals("")) {
            throw new BusinessException(Constants.PARAM_ERROR, "缺少问卷ID");
        }
        if (feedbackRepository.findByFeedbackId(feedbackId) == null) {
            throw new BusinessException(Constants.PARAM_ERROR, "未找到该问卷, 问卷ID: " + feedbackId);
        }
        List<AnswerSheet> answerSheetList = answerSheetRepository.FeedbackId(feedbackId);
        if (answerSheetList.size() == 0) {
            throw new BusinessException(Constants.PARAM_ERROR, "未找到该问卷的答卷, 问卷ID: " + feedbackId);
        }
        List<AnswerSheetDto> answerSheetDtoList = new ArrayList<>();
        for (AnswerSheet answerSheet : answerSheetList) {
            answerSheetDtoList.add(getAnswerSheetDtoByFbId(answerSheet));
        }
        return answerSheetDtoList;
    }

    /**
     * @param userId     用户ID
     * @param feedbackId 问卷ID
     * @return
     */
    public AnswerSheetDto findByUserIdAndFeedbackId(String userId, String feedbackId) {
        if (userId.equals("")) {
            throw new BusinessException(Constants.PARAM_ERROR, "缺少用户ID");
        }
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new BusinessException(Constants.PARAM_ERROR, "未找到该用户,用户ID: " + userId);
        }
        if (feedbackId.equals("")) {
            throw new BusinessException(Constants.PARAM_ERROR, "缺少问卷ID");
        }
        Feedback feedback = feedbackRepository.findByFeedbackId(feedbackId);
        if (feedback == null) {
            throw new BusinessException(Constants.PARAM_ERROR, "未找到该问卷,问卷ID: " + feedbackId);
        }
        AnswerSheet answerSheet = answerSheetRepository.UserIdAndFeedbackId(userId, feedbackId);
        if (answerSheet == null) {
            throw new BusinessException(Constants.PARAM_ERROR, "未找到该答卷,用户ID: " + userId + " 问卷ID: " + feedbackId);
        }

        return getAnswerSheetDtoByFbId(answerSheet);
    }

    /**
     * @return
     */
    public List<AnswerSheetDto> getAll() {
        List<AnswerSheetDto> answerSheetDtoList = new ArrayList<>();
        for (AnswerSheet answerSheet : answerSheetRepository.findAll()) {
            answerSheetDtoList.add(getAnswerSheetDtoByFbId(answerSheet));
        }
        return answerSheetDtoList;
    }
}
