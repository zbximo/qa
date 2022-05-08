package com.example.zuccqa;

import com.example.zuccqa.service.FeedbackService;
import org.junit.jupiter.api.Test;
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
