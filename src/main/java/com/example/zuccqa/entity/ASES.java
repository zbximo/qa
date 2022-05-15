package com.example.zuccqa.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: ximo
 * @date: 2022/5/9 20:53
 * @description:
 */
@Data
@Document(indexName = "sheet", replicas = 0, shards = 5)
public class ASES implements Serializable {
    /**
     * 问卷表单ID
     */
    private Long id;
    /**
     * 学生ID
     */
    @Field(type = FieldType.Keyword)
    private String studentId;
    /**
     * 问卷ID
     */
    @Field(type = FieldType.Keyword)
    private String feedbackId;
    /**
     * 回答列表
     */
    @Field(type = FieldType.Text)
    private List<List<String>> answerList;
    /**
     * 提交时间
     */
    @Field(index = false,type = FieldType.Date_Range)
    private Date submitDate;
}
