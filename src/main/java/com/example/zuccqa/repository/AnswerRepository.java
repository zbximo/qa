package com.example.zuccqa.repository;

import com.example.zuccqa.entity.Answer;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * @author: ximo
 * @date: 2022/3/24 16:09
 * @description:
 */
public interface AnswerRepository extends MongoRepository<Answer,Integer> {
    Answer findByAnswerId(String answerId);
    @Query(value = "{'User._id'='?0,'Feedback._id='?1'}")
    Answer UserIdAndFeedbackId(String userId, String feedbackId);
}
