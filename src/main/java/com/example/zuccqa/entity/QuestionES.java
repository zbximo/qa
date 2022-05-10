package com.example.zuccqa.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

/**
 * @author: ximo
 * @date: 2022/5/9 21:12
 * @description:
 */
@Data
public class QuestionES {
    /**
     * 问题标题
     */
    @Field(type = FieldType.Text,analyzer = "hanLP")
    private String questionTitle;
    /**
     * 问题类型(0:单选题，1:多选题,2:主观题)
     */
    @Field(type = FieldType.Integer)
    private Integer questionType;
    /**
     * 是否必填(0:否，1:是)
     */
    @Field(type = FieldType.Integer)
    private Integer isRequired;
    /**
     * 选项
     */
    private List<String> options;
}
