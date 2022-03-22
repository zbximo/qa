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
    @Id
    private String modelID;
    @Field("modelName")
    private String modelName;
    @Field("questionList")
    private List<Question> questionList;
}
