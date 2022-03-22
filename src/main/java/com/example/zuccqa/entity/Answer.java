package com.example.zuccqa.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

/**
 * @author: ximo
 * @date: 2022/3/20 16:31
 * @description:
 */
@Data
@Document(collection = "Answer")
// 问卷填写信息
public class Answer {
    @Id
    private String answerId;
    @Field("student")
    private User user;
    @Field("feedback")
    private Feedback feedback;
    @Field("answers")
    private List<String> answer;
    @Field("date")
    private Date date;
}
