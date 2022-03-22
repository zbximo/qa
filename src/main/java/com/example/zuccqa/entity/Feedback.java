package com.example.zuccqa.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

/**
 * @author: ximo
 * @date: 2022/3/20 16:30
 * @description:
 */
@Data
@Document(collection = "Feedback")
public class Feedback {
    @Id
    private String feedbackId;
    @Field("feedbackCourse")
    private Course feedbackCourse;
    @Field("feedbackTitle")
    private String feedbackTitle;
    @Field("creatTime")
    private Date creatTime;
    @Field("startTime")
    private Date startTime;
    @Field("endTime")
    private Date endTime;
    @Field("questionList")
    private List<Question> questionList;
}
