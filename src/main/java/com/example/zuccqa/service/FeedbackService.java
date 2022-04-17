package com.example.zuccqa.service;

import com.example.zuccqa.entity.Feedback;
import com.example.zuccqa.result.ResponseData;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface FeedbackService {
    String addFeedback(Feedback feedbackMap);

    String deleteFeedback(String id);

    String updateFeedback(Feedback feedbackMap);

    Feedback findById(String feedBackId);

    List<Feedback> findByCourseId(String courseId);

    List<Feedback> getAll();
}
