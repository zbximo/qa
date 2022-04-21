package com.example.zuccqa.service;

import com.example.zuccqa.entity.Course;
import com.example.zuccqa.entity.User;
import com.example.zuccqa.result.ResponseData;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface UserService {
    String addUser(User userMap);

    String updateUser(User userMap);

    String deleteUser(String id);

    User findById(String id);

    List<User> findByName(String name);

    List<User> getAll();

    String login(String id, String password);

    String modifyPwd(String id, String oldPwd,
                     String newPwd);

    List<Course> findByStudentIdListContains(String studentId);

}
