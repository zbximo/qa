package com.example.zuccqa;

import com.example.zuccqa.controller.DynamicTask;
import com.example.zuccqa.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: ximo
 * @date: 2022/4/19 19:23
 * @description:
 */
@SpringBootTest
public class RedisUtilsTest {
    @Autowired
    private RedisUtil redisUtils;

    @Test
    public void test() throws ParseException {
        String time1 = "2016 05 19";

        String time2 = "2016 05 18";

        DateFormat dateFormat = new SimpleDateFormat("yyyy MM dd");

        Date beString = dateFormat.parse(time1);

        Date enString = dateFormat.parse(time2);

        long sub = Math.abs(beString.getTime() - enString.getTime());
        System.out.println(sub);

    }
    @Test
    public void test1() {
        DynamicTask dynamicTask = new DynamicTask();


    }
//    @Test
//    public void get() {
//        String result = redisUtils.get("test");
//        System.out.print("缓存数据为:"+result+"\n");
//    }
//
//    @Test
//    public void set() {
//        redisUtils.set("test","123abc");
//    }

//    @Test
//    public void update() {
//        redisUtils.update("test","test1111");
//    }
//
//    @Test
//    public void delete() {
//        redisUtils.delete("test");
//    }
}
