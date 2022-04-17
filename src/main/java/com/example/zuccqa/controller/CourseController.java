package com.example.zuccqa.controller;

import com.example.zuccqa.entity.Course;

import com.example.zuccqa.result.ExceptionMsg;
import com.example.zuccqa.result.Response;
import com.example.zuccqa.result.ResponseData;
import com.example.zuccqa.service.CourseService;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: ximo
 * @date: 2022/3/20 19:11
 * @description:
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(CourseController.class);
    @Autowired
    private CourseService courseService;

    /**
     * @param courseMap 课程信息
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData addCourse(@RequestBody Course courseMap) {

        String id = courseService.addCourse(courseMap);
        logger.warn("create course id = {}", id);
        return new ResponseData(ExceptionMsg.SUCCESS, id);
    }

    /**
     * @param id 课程ID
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Response deleteCourse(@RequestParam("id") String id) {
        String courseId = courseService.deleteCourse(id);
        logger.warn("delete course id = {}", courseId);
        return new Response(ExceptionMsg.SUCCESS);
    }

    /**
     * @param courseMap 课程信息
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseData updateCourse(@RequestBody Course courseMap) {
        String id = courseService.updateCourse(courseMap);
        logger.warn("update course id = {}", id);

        return new ResponseData(ExceptionMsg.SUCCESS, id);
    }

    /**
     * @param id 课程ID
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public ResponseData findById(@RequestParam("id") String id) {
        Course course = courseService.findById(id);
        logger.warn("query course id = {}", id);
        return new ResponseData(ExceptionMsg.SUCCESS, course);
    }

    /**
     * @param name 课程名称
     * @return
     */
    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public ResponseData findByName(@RequestParam("name") String name) {
        List<Course> courseList = courseService.findByName(name);
        logger.warn("query courses name = {}", name);
        return new ResponseData(ExceptionMsg.SUCCESS, courseList);
    }

    /**
     * @return
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseData getAll() {
        List<Course> courseList = courseService.getAll();
        logger.warn("query all courses");
        return new ResponseData(ExceptionMsg.SUCCESS, courseList);
    }


}
