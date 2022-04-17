package com.example.zuccqa.form;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @author:Benjamin
 * @Date:2022/4/17 14:09
 **/
@Data
@Getter
@Setter
public class UserDto implements Serializable {
    private String id;

    private String name;

    private Integer age;

    private String password;

    private Integer position;
}
