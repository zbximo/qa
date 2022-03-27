package com.example.zuccqa.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: ximo
 * @date: 2022/3/20 16:31
 * @description:
 */
@Data
@Document(collection = "Answer")
// 问卷填写信息
public class Answer {
    /**
     * 答案ID
     */
    @Id
    private String answerId;
    /**
     * 用户
     */
    @Field("student")
    private User user;
    /**
     * 问卷
     */
    @Field("feedback")
    private Feedback feedback;
    /**
     * 答案列表
     */
    @Field("answers")
    private List<List<String>> answer;
    /**
     * 时间
     */
    @Field("date")
    private Date date;
}
