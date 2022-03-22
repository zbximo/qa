package com.example.zuccqa.controller;

import com.example.zuccqa.entity.Student;
import com.example.zuccqa.repository.ModelRepository;
import com.example.zuccqa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: ximo
 * @date: 2022/3/22 10:13
 * @description:
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private StudentRepository studentRepository;
    @PostMapping("/login")
    public Student login(@RequestBody Map<String, String> queryExample){
        String id = queryExample.get("id");
        String passwd = queryExample.get("password");
//        Student s = studentRepository.findByStudentId(id);
//        if s.getStudentId().equals(""){
//
//        }
        return new Student();
    }
}
