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
@Document(collection = "AnswerSheet")
// 问卷填写信息
public class AnswerSheet {
    /**
     * 问卷表单ID
     */
    @Id
    private String answerSheetId;
    /**
     * 学生ID
     */
    @Field("studentId")
    private String studentId;
    /**
     * 问卷ID
     */
    @Field("feedbackId")
    private String feedbackId;
    /**
     * 回答列表
     */
    @Field("answerList")
    private List<List<String>> answerList;
    /**
     * 提交时间
     */
    @Field("submitDate")
    private Date submitDate;
}
