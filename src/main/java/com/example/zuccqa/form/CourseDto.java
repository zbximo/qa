package com.example.zuccqa.form;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author:Benjamin
 * @Date:2022/4/17 14:10
 **/
@Data
@Getter
@Setter
public class CourseDto implements Serializable {
    private String courseId;

    private String courseName;

    private List<String> studentIdList;

    private String teacherId;

    private Map<Integer, List<Integer>> courseDate;
}
