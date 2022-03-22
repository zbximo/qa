package com.example.zuccqa.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Optional;

/**
 * @author: ximo
 * @date: 2022/3/20 16:34
 * @description:
 */
@Data
//@Document(collection = "Question")
public class Question {
    private String questionTitle;
    private int questionType;
    private List<String> options;
}
