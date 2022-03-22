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

import java.io.Serializable;
import java.util.Date;
@Data
@Document(collection = "Student")
public class Student implements Serializable {
    @Id
    private String studentId;
    @Field("name")
    private String studentName;
    @Field("age")
    private Integer studentAge;
    @Field("password")
    private Integer password;
}

