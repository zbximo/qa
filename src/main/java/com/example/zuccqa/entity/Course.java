package com.example.zuccqa.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Date;
import java.util.Map;

/**
 * @author: ximo
 * @date: 2022/3/20 16:31
 * @description:
 */
@Data
@Document(collection = "Course")
public class Course {
    /**
     * 课程ID
     */
    @Id
    private String courseId;

    /**
     * 课程名
     */
    @Field("className")
    private String courseName;

    /**
     * 学生列表
     */
    @Field("stuList")
    private List<User> stuList;

    /**
     * 教师
     */
    @Field("teacher")
    private User teacher;

    /**
     * 课程时间
     */
    @Field("courseDate")
    private Map<Integer, List<Integer>> courseDate;
}
