package com.example.zuccqa.entity;

/**
 * @author: ximo
 * @date: 2022/3/20 12:09
 * @description:
 */

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "Student")
public class User {
    /**
     * 用户ID
     */
    @Id
    private String id;
    /**
     * 用户姓名
     */
    @Field("name")
    private String name;
    /**
     * 用户年龄
     */
    @Field("age")
    private Integer age;
    /**
     * 用户密码
     */
    @Field("password")
    private String password;
    /**
     * 用户身份(0:学生,1:教师,2:管理员)
     */
    @Field("position")
    private Integer position;
}

