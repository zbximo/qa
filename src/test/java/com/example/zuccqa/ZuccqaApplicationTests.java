package com.example.zuccqa;

import com.example.zuccqa.entity.Course;
import com.example.zuccqa.exception.BusinessException;
import com.example.zuccqa.repository.CourseRepository;
import com.example.zuccqa.service.FeedbackService;
import com.example.zuccqa.utils.Constant;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZuccqaApplicationTests {
    @Autowired
    private FeedbackService feedbackService;
    @Test
    void contextLoads() {
        feedbackService.addFinishCache("11","1111");
    }

}
