package com.example.zuccqa.form;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.List;

/**
 * @author:Benjamin
 * @Date:2022/4/17 14:14
 **/
@Data
@Setter
@Getter
public class QuestionDto implements Serializable {
    private String questionTitle;

    private int questionType;

    private String isRequired;

    private List<String> options;
}
