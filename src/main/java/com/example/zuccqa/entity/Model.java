package com.example.zuccqa.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * @author: ximo
 * @date: 2022/3/20 16:30
 * @description:
 */
@Data
@Document(collection = "Model")
public class Model {
    /**
     * 模版ID
     */
    @Id
    private String modelID;
    /**
     * 模版名
     */
    @Field("modelName")
    private String modelName;
    /**
     * 问题列表
     */
    @Field("questionList")
    private List<Question> questionList;
}
