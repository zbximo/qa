package com.example.zuccqa.impl;

import com.example.zuccqa.entity.Feedback;
import com.example.zuccqa.exception.BusinessException;
import com.example.zuccqa.repository.FeedbackRepository;

import com.example.zuccqa.service.CourseService;
import com.example.zuccqa.service.FeedbackService;
import com.example.zuccqa.utils.Constant;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author: ximo
 * @date: 2022/4/17 14:10
 * @description:
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private CourseService courseService;

    /**
     * @param feedbackMap 问卷信息
     * @return
     */
    @Override
    public String addFeedback(Feedback feedbackMap) {
        Feedback feedback = new Feedback();
        BeanUtils.copyProperties(feedbackMap, feedback);
        if (feedback.getFeedbackTitle() == null || feedback.getFeedbackTitle().equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "模板名称为空");
        }
        ObjectId id = new ObjectId();
        feedback.setFeedbackId(id.toString());

        feedbackRepository.save(feedback);
        return feedback.getFeedbackId();
    }

    /**
     * @param id 问卷ID
     * @return
     */
    @Override
    public String deleteFeedback(String id) {
        if (id.equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "问卷ID不能为空");
        }
        if (feedbackRepository.findByFeedbackId(id) == null) {
            throw new BusinessException(Constant.PARAM_ERROR, "找不到该问卷, 问卷ID: " + id);
        }
        feedbackRepository.deleteByFeedbackId(id);
        return id;
    }


    /**
     * @param feedbackMap 问卷信息
     * @return
     */
    @Override
    public String updateFeedback(Feedback feedbackMap) {
        Feedback feedback = new Feedback();
        BeanUtils.copyProperties(feedbackMap, feedback);
        if (feedback.getFeedbackId() == null || feedback.getFeedbackId().equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "问卷ID不能为空");
        }
        if (feedbackRepository.findByFeedbackId(feedback.getFeedbackId()) == null) {
            throw new BusinessException(Constant.PARAM_ERROR, "找不到该问卷, 问卷ID: " + feedback.getFeedbackId());
        }
        feedbackRepository.save(feedbackMap);
        return feedback.getFeedbackId();
    }

    /**
     * @param feedBackId 问卷ID
     * @return
     */
    @Override
    public Feedback findById(String feedBackId) {
        if (feedBackId.equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "问卷ID不能为空");
        }
        Feedback feedback = feedbackRepository.findByFeedbackId(feedBackId);
        if (feedback == null) {
            throw new BusinessException(Constant.PARAM_ERROR, "未找到该问卷, 问卷ID: " + feedBackId);
        }
        return feedback;
    }

    /**
     * @param courseId 课程ID
     * @return
     */
    @Override
    public List<Feedback> findByCourseId(String courseId) {
        courseService.findById(courseId);
        List<Feedback> feedbackList = feedbackRepository.find(courseId);
        if (feedbackList.size() == 0) {
            throw new BusinessException(Constant.PARAM_ERROR, "未找到该课程的问卷, 课程ID: " + courseId);
        }
        return feedbackList;
    }

    /**
     * @return
     */
    @Override
    public List<Feedback> getAll() {
        return feedbackRepository.findAll();
    }
}
