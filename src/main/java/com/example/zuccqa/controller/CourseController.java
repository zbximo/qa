package com.example.zuccqa.controller;

import com.example.zuccqa.entity.Course;
import com.example.zuccqa.entity.Student;
import com.example.zuccqa.entity.Teacher;
import com.example.zuccqa.repository.CourseRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author: ximo
 * @date: 2022/3/20 19:11
 * @description:
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;
    @GetMapping("/add")
    public Course addCourse(@RequestBody Map<String, String> queryExample) {

        ObjectId id = new ObjectId();
        Course course = new Course();
        course.setCourseName("course"+id.toString());
        course.setCourseId(id.toString());
        courseRepository.save(course);
        return course;
    }
    @GetMapping("/update")
    public Course updateCourse(@RequestBody Map<String, String> queryExample) {
        String name = queryExample.get("name");
        String age = queryExample.get("age");
        Course course = courseRepository.findByCourseName("course1");
        Teacher teacher = new Teacher();
        teacher.setTeacherAge(300);
        course.setTeacher(teacher);
        courseRepository.save(course);
        return course;
    }
}
