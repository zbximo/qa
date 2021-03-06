package com.example.zuccqa.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
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
     * 学号列表
     */
    @Field("studentIdList")
    private List<String> studentIdList;

    /**
     * 教师
     */
    @Field("teacherId")
    private String teacherId;

    /**
     * 课程时间 {周几:[第几节课]}
     */
    @Field("courseDate")
    private Map<Integer, List<Integer>> courseDate;
    /**
     * 是否关闭{0:开放, 1:关闭}
     */
    @Field("is_close")
    private Integer isClose;
}
