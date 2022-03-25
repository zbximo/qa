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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData addCourse(@RequestBody Course courseMap) throws Exception {
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

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Response deleteCourse(@PathVariable("id") String id) {
        courseRepository.deleteByCourseId(id);
        return new Response(ExceptionMsg.SUCCESS);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseData updateCourse(@RequestBody Course courseMap) {
        courseRepository.save(courseMap);
        return new ResponseData(ExceptionMsg.SUCCESS, courseMap);
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public ResponseData findById(@PathVariable("id") String id) {
        Course course = courseRepository.findByCourseId(id);
        if (course != null) {
            return new ResponseData(ExceptionMsg.SUCCESS, course);
        }
        return new ResponseData(ExceptionMsg.FAILED, course);
    }

    @RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET)
    public ResponseData findByName(@PathVariable("name") String name) {
        List<Course> courseList = courseRepository.findByCourseName(name);
        if (courseList.size() > 0) {
            return new ResponseData(ExceptionMsg.SUCCESS, courseList);
        }
        return new ResponseData(ExceptionMsg.FAILED, courseList);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseData getAll() {
        List<Course> courseList = courseRepository.findAll();
        return new ResponseData(ExceptionMsg.SUCCESS, courseList);
    }


}
