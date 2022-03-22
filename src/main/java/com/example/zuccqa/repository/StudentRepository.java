package com.example.zuccqa.repository;

/**
 * @author: ximo
 * @date: 2022/3/20 12:10
 * @description:
 */


import com.example.zuccqa.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, Integer> {

    Student findByStudentId(String studentId);
    List<Student> findByStudentName(String studentName);

}

