package com.example.zuccqa.repository;

import com.example.zuccqa.entity.AnswerSheet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * @author: ximo
 * @date: 2022/3/24 16:09
 * @description:
 */
public interface AnswerSheetRepository extends MongoRepository<AnswerSheet,Integer> {
    AnswerSheet findByAnswerSheetId(String answerId);
    @Query(value = "{'$and':[{'studentId':'?0'},{'feedbackId':'?1'}]}")
    AnswerSheet UserIdAndFeedbackId(String userId, String feedbackId);
    @Query(value = "{'studentId':'?0'}")
    List<AnswerSheet> UserId(String userId);
    @Query(value = "{'feedbackId':'?0'}")
    List<AnswerSheet> FeedbackId(String feedbackId);
    void deleteByAnswerSheetId(String answerSheetId);

}
