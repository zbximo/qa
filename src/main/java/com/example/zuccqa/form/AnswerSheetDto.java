package com.example.zuccqa.form;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author:Benjamin
 * @Date:2022/4/17 13:40
 **/
@Data
@Getter
@Setter
public class AnswerSheetDto implements Serializable {
    private String answerSheetId;

    private String studentId;

    private String feedbackId;

    private List<List<String>> answers;

    private Date submitDate;
}
