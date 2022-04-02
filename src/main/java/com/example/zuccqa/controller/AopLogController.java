package com.example.zuccqa.controller;

/**
 * @author:Benjamin
 * @Date:2022/4/2 13:55
 **/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopLogController {
    @GetMapping("/aoptest")
    public String aVoid(){
        return "hello aop test";
    }
}
