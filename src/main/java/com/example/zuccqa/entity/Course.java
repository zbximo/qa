package com.example.zuccqa.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * @author: ximo
 * @date: 2022/3/20 16:31
 * @description:
 */
@Data
@Document(collection = "Course")
public class Course {
    @Id
    private String courseId;
    @Field("className")
    private String courseName;
    @Field("stuList")
    private List<User> stuList;
    @Field("teacher")
    private User teacher;
    @Field("courseData")
    private List<java.util.Date> courseData;
}
