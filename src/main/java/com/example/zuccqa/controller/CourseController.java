package com.example.zuccqa.controller;

import com.example.zuccqa.entity.Course;
import com.example.zuccqa.repository.CourseRepository;
import com.example.zuccqa.result.ExceptionMsg;
import com.example.zuccqa.result.Response;
import com.example.zuccqa.result.ResponseData;
import org.springframework.beans.BeanUtils;
import org.bson.types.ObjectId;
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
    @Autowired
    private CourseRepository courseRepository;

    /**
     * @param courseMap 课程信息
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData addCourse(@RequestBody Course courseMap) {
        if (courseMap == null) {
            return new ResponseData(ExceptionMsg.FAILED, "");
        }
        ObjectId id = new ObjectId();
        courseMap.setCourseId(id.toString());
        Course c = new Course();
        BeanUtils.copyProperties(courseMap, c);
        courseRepository.save(c);
        return new ResponseData(ExceptionMsg.SUCCESS, c);
    }

    /**
     * @param id 课程ID
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Response deleteCourse(@RequestParam("id") String id) {
        courseRepository.deleteByCourseId(id);
        return new Response(ExceptionMsg.SUCCESS);
    }

    /**
     * @param courseMap 课程信息
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseData updateCourse(@RequestBody Course courseMap) {
        courseRepository.save(courseMap);
        return new ResponseData(ExceptionMsg.SUCCESS, courseMap);
    }

    /**
     * @param id 课程ID
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public ResponseData findById(@RequestParam("id") String id) {
        Course course = courseRepository.findByCourseId(id);
        if (course != null) {
            return new ResponseData(ExceptionMsg.SUCCESS, course);
        }
        else
            return new ResponseData(ExceptionMsg.FAILED, course);
    }

    /**
     * @param name 课程名称
     * @return
     */
    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public ResponseData findByName(@RequestParam("name") String name) {
        List<Course> courseList = courseRepository.findByCourseName(name);
        if (courseList.size() > 0) {
            return new ResponseData(ExceptionMsg.SUCCESS, courseList);
        }
        return new ResponseData(ExceptionMsg.FAILED, courseList);
    }

    /**
     * @return
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseData getAll() {
        List<Course> courseList = courseRepository.findAll();
        return new ResponseData(ExceptionMsg.SUCCESS, courseList);
    }


}
