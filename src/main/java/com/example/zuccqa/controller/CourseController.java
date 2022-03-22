package com.example.zuccqa.controller;

import com.example.zuccqa.entity.Course;
import com.example.zuccqa.entity.User;
import com.example.zuccqa.repository.CourseRepository;
import com.example.zuccqa.result.ExceptionMsg;
import com.example.zuccqa.result.Response;
import com.example.zuccqa.result.ResponseData;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Course addCourse(@RequestBody Map<String, String> queryExample) {

        ObjectId id = new ObjectId();
        Course course = new Course();
        course.setCourseName("course"+id.toString());
        course.setCourseId(id.toString());
        courseRepository.save(course);
        return course;
    }
    @RequestMapping(value = "/delete{id}", method = RequestMethod.DELETE)
    public Response deleteModel(@PathVariable("id") String id) {
        courseRepository.deleteByCourseId(id);
        return new Response(ExceptionMsg.SUCCESS);
    }
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Course updateCourse(@RequestBody Map<String, String> queryExample) {
        String name = queryExample.get("name");
        String age = queryExample.get("age");
        Course course = courseRepository.findByCourseName("course1");
        User teacher = new User();
        teacher.setAge(300);
        course.setTeacher(teacher);
        courseRepository.save(course);
        return course;
    }
    @RequestMapping(value = "/find{id}", method = RequestMethod.GET)
    public ResponseData findById(@PathVariable("id") String id) {
        Course course = courseRepository.findByCourseId(id);
        if (course != null) {
            return new ResponseData(ExceptionMsg.SUCCESS, course);
        }
        return new ResponseData(ExceptionMsg.FAILED, course);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseData getAll() {
        List<Course> courseList = courseRepository.findAll();
        return new ResponseData(ExceptionMsg.SUCCESS, courseList);
    }
}
