package com.example.zuccqa.form;

import com.example.zuccqa.entity.Question;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author:Benjamin
 * @Date:2022/4/17 14:10
 **/
@Data
@Getter
@Setter
public class FeedbackDto implements Serializable {
    private String feedbackId;

    private String feedbackCourseId;

    private String feedbackTitle;

    private Date creatTime;

    private Date startTime;

    private Date endTime;

    private List<Question> questionList;
}
