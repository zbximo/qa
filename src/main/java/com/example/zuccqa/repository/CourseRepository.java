package com.example.zuccqa.repository;

import com.example.zuccqa.entity.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: ximo
 * @date: 2022/3/20 19:12
 * @description:
 */
@Repository
public interface CourseRepository extends MongoRepository<Course, Integer> {
    Course findByCourseId(String courseId);
    List<Course> findByCourseName(String courseName);
    void deleteByCourseId(String courseId);
}
