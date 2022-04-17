package com.example.zuccqa.impl;

import com.example.zuccqa.entity.Course;
import com.example.zuccqa.exception.BusinessException;
import com.example.zuccqa.repository.CourseRepository;
import com.example.zuccqa.service.CourseService;
import com.example.zuccqa.utils.Constant;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author: ximo
 * @date: 2022/4/17 14:16
 * @description:
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    /**
     * @param courseMap 课程信息
     * @return
     */
    public String addCourse(Course courseMap) {
        Course c = new Course();
        BeanUtils.copyProperties(courseMap, c);
        if (c.getCourseName() == null || c.getCourseName().equals("")) {
            throw new BusinessException(Constant.ParamError, "缺少课程名");
        }
        ObjectId id = new ObjectId();
        c.setCourseId(id.toString());

        courseRepository.save(c);
        return id.toString();
    }

    /**
     * @param id 课程ID
     * @return
     */
    public String deleteCourse(String id) {
        if (id.equals("")) {
            throw new BusinessException(Constant.ParamError, "缺少课程号，不能删除");
        }
        courseRepository.deleteByCourseId(id);
        return id;
    }

    /**
     * @param courseMap 课程信息
     * @return
     */
    public String updateCourse(Course courseMap) {
        Course course = new Course();
        BeanUtils.copyProperties(courseMap, course);
        if (course.getCourseId() == null || course.getCourseId().equals("")) {
            throw new BusinessException(Constant.ParamError, "课程号为空,不能更新");
        }
        courseRepository.save(courseMap);
        return courseMap.getCourseId();
    }

    /**
     * @param id 课程ID
     * @return
     */
    public Course findById(String id) {
        Course course = courseRepository.findByCourseId(id);
        if (course == null) {
            throw new BusinessException(Constant.ParamError, "找不到该课程: 课程id: " + id);
        }
        return course;
    }

    /**
     * @param name 课程名称
     * @return
     */
    public List<Course> findByName(String name) {
        if (name.equals("")) {
            throw new BusinessException(Constant.ParamError, "课程名为空");
        }
        List<Course> courseList = courseRepository.findByCourseName(name);
        if (courseList.size() == 0) {
            throw new BusinessException(Constant.ParamError, "找不到该课程: 课程名: " + name);
        }
        return courseList;
    }

    /**
     * @return
     */
    public List<Course> getAll() {
        return courseRepository.findAll();
    }
}
