package com.example.zuccqa.service;

import com.example.zuccqa.entity.Feedback;
import com.example.zuccqa.form.AnswerSheetDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnswerSheetService {
    void addBlankAnswerSheets(Feedback feedback);

    String addAnswerSheet(AnswerSheetDto answerSheetMap);

    String deleteAnswerSheet(String id);

    String updateAnswerSheet(AnswerSheetDto answerSheetMap);

    AnswerSheetDto findById(String id);

    List<AnswerSheetDto> findByUserId(String userId);

    List<AnswerSheetDto> findByFeedbackId(String feedbackId);

    AnswerSheetDto findByUserIdAndFeedbackId(String userId, String feedbackId);

    List<AnswerSheetDto> getAll();

}
