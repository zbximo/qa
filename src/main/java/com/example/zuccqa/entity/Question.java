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
    /**
     * 问题标题
     */
    private String questionTitle;
    /**
     * 问题类型
     */
    private int questionType;
    /**
     * 选项
     */
    private List<String> options;

}
