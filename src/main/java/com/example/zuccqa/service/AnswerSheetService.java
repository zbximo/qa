package com.example.zuccqa.service;

import com.example.zuccqa.entity.AnswerSheet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnswerSheetService {
    String addAnswerSheet(AnswerSheet answerSheetMap);

    String deleteAnswerSheet(String id);

    String updateAnswerSheet(AnswerSheet answerSheetMap);

    AnswerSheet findById(String id);

    List<AnswerSheet> findByUserId(String userId);

    List<AnswerSheet> findByFeedbackId(String feedbackId);

    AnswerSheet findByUserIdAndFeedbackId(String userId, String feedbackId);

    List<AnswerSheet> getAll();

}
