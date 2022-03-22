package com.example.zuccqa.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author: ximo
 * @date: 2022/3/20 16:27
 * @description:
 */
@Data
@Document(collection = "Teacher")
public class Teacher {
    @Id
    private String teacherId;
    @Field("name")
    private String teacherName;
    @Field("age")
    private Integer teacherAge;
    @Field("password")
    private Integer password;
}
