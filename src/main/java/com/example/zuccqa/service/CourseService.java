package com.example.zuccqa.service;

import com.example.zuccqa.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    String addCourse(Course courseMap);

    String deleteCourse(String id);

    String updateCourse(Course courseMap);

    Course findById(String id);

    List<Course> findByName(String name);

    List<Course> getAll();

    String closeCourse(String id);

    String openCourse(String id);
}
