package com.example.zuccqa.repository;

import com.example.zuccqa.entity.AnswerSheet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * @author: ximo
 * @date: 2022/3/24 16:09
 * @description:
 */
public interface AnswerRepository extends MongoRepository<AnswerSheet,Integer> {
    AnswerSheet findByAnswerSheetId(String answerId);
    @Query(value = "{'$and':[{'studentId':'?0'},{'feedbackId':'?1'}]}")
    AnswerSheet UserIdAndFeedbackId(String userId, String feedbackId);
    @Query(value = "{'studentId':'?0'}")
    AnswerSheet UserId(String userId);
    @Query(value = "{'feedbackId':'?0'}")
    AnswerSheet FeedbackId(String feedbackId);
    void deleteByAnswerSheetId(String answerSheetId);
}
