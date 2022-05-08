package com.example.zuccqa.entity;

import lombok.Data;
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
    /**
     * 问卷ID
     */
    @Id
    private String feedbackId;
    /**
     * 问卷课程ID
     */
    @Field("feedbackCourseId")
    private String feedbackCourseId;
    /**
     * 问卷标题
     */
    @Field("feedbackTitle")
    private String feedbackTitle;
    /**
     * 问卷状态
     */
    @Field("feedbackStatus")
    private Integer feedbackStatus;

    /**
     * 创建时间
     */
    @Field("creatTime")
    private Date creatTime;
    /**
     * 开始时间
     */
    @Field("startTime")
    private Date startTime;
    /**
     * 结束时间
     */
    @Field("endTime")
    private Date endTime;
    /**
     * 问题列表
     */
    @Field("questionList")
    private List<Question> questionList;
}
