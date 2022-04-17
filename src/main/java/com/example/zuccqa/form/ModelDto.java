package com.example.zuccqa.form;

import com.example.zuccqa.entity.Question;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

/**
 * @author:Benjamin
 * @Date:2022/4/17 14:13
 **/
@Data
@Getter
@Setter
public class ModelDto implements Serializable {
    private String modelID;

    private String modelName;

    private List<Question> questionList;
}
