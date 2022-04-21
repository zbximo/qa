package com.example.zuccqa.repository;

import com.example.zuccqa.entity.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FeedbackRepository extends MongoRepository<Feedback, Integer> {
    Feedback findByFeedbackId(String feedbackId);

    @Query(value = "{'feedbackCourseId':?0}")
    List<Feedback> find(String feedbackCourseId);

    void deleteByFeedbackId(String feedbackId);

//    List<Feedback>
}
