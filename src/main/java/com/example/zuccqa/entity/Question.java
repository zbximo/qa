package com.example.zuccqa.entity;

import lombok.Data;


import java.util.List;

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
     * 问题类型(0:单选题，1:多选题,2:主观题)
     */
    private int questionType;
    /**
     * 是否必填(0:否，1:是)
     */
    private Integer isRequired;
    /**
     * 选项(列表长度: {0:主观题,1:单选题,2:多选题})
     */
    private List<String> options;

}
