package com.example.zuccqa.repository;

import com.example.zuccqa.entity.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author: ximo
 * @date: 2022/3/20 19:12
 * @description:
 */
public interface CourseRepository extends MongoRepository<Course, Integer> {
    Course findByCourseId(String Id);
    Course findByCourseName(String name);
}
