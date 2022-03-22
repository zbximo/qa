package com.example.zuccqa.controller;

import com.example.zuccqa.entity.Course;
import com.example.zuccqa.entity.Teacher;
import com.example.zuccqa.repository.StudentRepository;
import com.example.zuccqa.entity.Student;

/**
 * @author: ximo
 * @date: 2022/3/20 12:11
 * @description:
 */


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("/add")
    public List<Student> addStudent(@RequestBody Map<String, String> queryExample) {
        List<Student> list = new LinkedList<>();

        for (Integer count = 0; count < 3; count++) {
            ObjectId id = new ObjectId();
            Student student = new Student();
            student.setStudentName("count" + count);
            student.setStudentId(id.toString());
            studentRepository.save(student);
            list.add(student);
        }
        return list;
    }
    @GetMapping("/update")
    public Student updateStudent(@RequestBody Map<String, String> queryExample) {
        Student student = studentRepository.findByStudentId(String.valueOf(31901028));
        student.setStudentAge(200);
        studentRepository.save(student);
        return student;
    }
    @GetMapping("/remove")
    public Student removeStudent(@RequestBody Map<String, String> queryExample) {
        Student student = studentRepository.findByStudentId(String.valueOf(31901028));
        studentRepository.delete(student);
        return student;
    }
    @GetMapping("/getByStudentId")
    public Student getByStudentId() {
        Student student = studentRepository.findByStudentId(String.valueOf(31901028));

        return student;
    }

    @GetMapping("/getAll")
    public List<Student> getAll() {
        List<Student> list = studentRepository.findAll();
        return list;
    }


}

