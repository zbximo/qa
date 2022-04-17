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
        logger.warn("create course id: {}", id);
        return new ResponseData(ExceptionMsg.SUCCESS, id);
    }

    /**
     * @param id 课程ID
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Response deleteCourse(@RequestParam("id") String id) {
        String courseId = courseService.deleteCourse(id);
        logger.warn("delete course id: {}", courseId);
        return new Response(ExceptionMsg.SUCCESS);
    }

    /**
     * @param courseMap 课程信息
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseData updateCourse(@RequestBody Course courseMap) {
        String id = courseService.updateCourse(courseMap);
        logger.warn("update course id: {}", id);

        return new ResponseData(ExceptionMsg.SUCCESS, id);
    }

    /**
     * 通过课程ID获取课程信息
     *
     * @param id 课程ID
     * @return
     */
    @RequestMapping(value = "/viewCourseById", method = RequestMethod.GET)
    public ResponseData findById(@RequestParam("id") String id) {
        Course course = courseService.findById(id);
        logger.warn("query course id: {}", id);
        return new ResponseData(ExceptionMsg.SUCCESS, course);
    }

    /**
     * 通过课程名获取到课程信息
     *
     * @param name 课程名称
     * @return
     */
    @RequestMapping(value = "/viewCourseByName", method = RequestMethod.GET)
    public ResponseData viewCourseByName(@RequestParam("name") String name) {
        List<Course> courseList = courseService.findByName(name);
        logger.warn("query courses name: {}", name);
        return new ResponseData(ExceptionMsg.SUCCESS, courseList);
    }

    /**
     * 关闭课程
     *
     * @param id 课程Id
     * @return
     */
    @RequestMapping(value = "/closeCourseById", method = RequestMethod.GET)
    public ResponseData closeCourseById(@RequestParam("id") String id) {
        String courseId = courseService.closeCourse(id);
        logger.warn("close courses id: {}", courseId);
        return new ResponseData(ExceptionMsg.SUCCESS, courseId);
    }

    /**
     * 开启课程
     *
     * @param id 课程Id
     * @return
     */
    @RequestMapping(value = "/openCourseById", method = RequestMethod.GET)
    public ResponseData openCourseById(@RequestParam("id") String id) {
        String courseId = courseService.openCourse(id);
        logger.warn("open courses id: {}", courseId);
        return new ResponseData(ExceptionMsg.SUCCESS, courseId);
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
