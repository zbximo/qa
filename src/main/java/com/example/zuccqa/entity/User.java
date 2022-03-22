package com.example.zuccqa.entity;

/**
 * @author: ximo
 * @date: 2022/3/20 12:09
 * @description:
 */

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "Student")
public class User {
    @Id
    private String id;
    @Field("name")
    private String name;
    @Field("age")
    private Integer age;
    @Field("password")
    private String password;
    @Field("position")
    private Integer position;
}

