package com.example.zuccqa.entity;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: ximo
 * @date: 2022/5/9 20:52
 * @description:
 */
@Data
@Document(indexName = "fb", replicas = 0, shards = 5)
public class FbES implements Serializable {
    /**
     * 问卷ID
     */
    private Long id;
    /**
     * 问卷课程ID
     */
    @Field(type = FieldType.Keyword,analyzer = "ik_max_word")
    private String feedbackCourseId;
    /**
     * 问卷标题
     */
    @Field(type = FieldType.Text)
    private String feedbackTitle;
    /**
     * 问卷状态
     */
    @Field(type = FieldType.Integer)
    private Integer feedbackStatus;
    /**
     * 问题列表
     */
//    @Field(type = FieldType.Nested)
    private List<QuestionES> questionList;
    /**
     * 创建时间
     */
    @Field(index = false, type = FieldType.Date)
    private Date creatTime;
    /**
     * 开始时间
     */
    @Field(index = false, type = FieldType.Date)
    private Date startTime;
    /**
     * 结束时间
     */
    @Field(index = false, type = FieldType.Date)
    private Date endTime;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private List<String> t;
}
