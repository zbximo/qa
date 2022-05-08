package com.example.zuccqa.impl;

import com.example.zuccqa.entity.Course;
import com.example.zuccqa.exception.BusinessException;
import com.example.zuccqa.repository.CourseRepository;
import com.example.zuccqa.service.CourseService;
import com.example.zuccqa.utils.Constants;
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
    @Override
    public String addCourse(Course courseMap) {
        Course c = new Course();
        BeanUtils.copyProperties(courseMap, c);
        if (c.getCourseName() == null || c.getCourseName().equals("")) {
            throw new BusinessException(Constants.PARAM_ERROR, "缺少课程名");
        }
        ObjectId id = new ObjectId();
        System.out.println(id.toHexString());

        c.setCourseId(id.toString());
        c.setIsClose(Constants.COURSE_OPEN);
        courseRepository.save(c);
        return c.getCourseId();
    }

    /**
     * @param id 课程ID
     * @return
     */
    @Override
    public String deleteCourse(String id) {
        if (id.equals("")) {
            throw new BusinessException(Constants.PARAM_ERROR, "缺少课程号，不能删除");
        }
        courseRepository.deleteByCourseId(id);
        return id;
    }

    /**
     * @param courseMap 课程信息
     * @return
     */
    @Override
    public String updateCourse(Course courseMap) {
        Course course = new Course();
        BeanUtils.copyProperties(courseMap, course);
        if (course.getCourseId() == null || course.getCourseId().equals("")) {
            throw new BusinessException(Constants.PARAM_ERROR, "课程号为空,不能更新");
        }
        courseRepository.save(course);
        return course.getCourseId();
    }

    /**
     * @param id 课程ID
     * @return
     */
    @Override
    public Course findById(String id) {
        Course course = courseRepository.findByCourseId(id);
        if (course == null) {
            throw new BusinessException(Constants.PARAM_ERROR, "找不到该课程: 课程id: " + id);
        }
        return course;
    }

    /**
     * @param name 课程名称
     * @return
     */
    @Override
    public List<Course> findByName(String name) {
        if (name.equals("")) {
            throw new BusinessException(Constants.PARAM_ERROR, "课程名为空");
        }
        List<Course> courseList = courseRepository.findByCourseName(name);
        if (courseList.size() == 0) {
            throw new BusinessException(Constants.PARAM_ERROR, "找不到该课程: 课程名: " + name);
        }
        return courseList;
    }

    /**
     * @return
     */
    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public String closeCourse(String id) {
        if (id.equals("")) {
            throw new BusinessException(Constants.PARAM_ERROR, "缺少课程号，不能删除");
        }
        Course course = courseRepository.findByCourseId(id);
        if (course == null) {
            throw new BusinessException(Constants.PARAM_ERROR, "未找到该课程，课程Id: " + id + ", 不能关闭");
        }
        course.setIsClose(Constants.COURSE_CLOSED);
        courseRepository.save(course);
        return id;
    }

    @Override
    public String openCourse(String id) {
        if (id.equals("")) {
            throw new BusinessException(Constants.PARAM_ERROR, "缺少课程号，不能删除");
        }
        Course course = courseRepository.findByCourseId(id);
        if (course == null) {
            throw new BusinessException(Constants.PARAM_ERROR, "未找到该课程，课程Id: " + id + ", 不能关闭");
        }
        course.setIsClose(Constants.COURSE_OPEN);
        courseRepository.save(course);
        return id;
    }
}
