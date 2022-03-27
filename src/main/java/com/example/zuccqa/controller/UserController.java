package com.example.zuccqa.controller;


/**
 * @author: ximo
 * @date: 2022/3/20 12:11
 * @description:
 */

import com.example.zuccqa.entity.Model;
import com.example.zuccqa.entity.User;
import com.example.zuccqa.repository.UserRepository;
import com.example.zuccqa.result.ExceptionMsg;
import com.example.zuccqa.result.Response;
import com.example.zuccqa.result.ResponseData;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    private UserRepository UserRepository;

    /**
     * @param userMap 用户信息
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData addUser(@RequestBody User userMap) {
        if (userMap == null) {
            return new ResponseData(ExceptionMsg.FAILED, "");
        } else if (userMap.getId().equals("") || userMap.getId() == null) {
            return new ResponseData(ExceptionMsg.FAILED, "用户账号为空");
        } else if (userMap.getPassword().equals("") || userMap.getPassword() == null) {
            return new ResponseData(ExceptionMsg.FAILED, "密码为空");
        }
        User user = new User();
        BeanUtils.copyProperties(userMap, user);
        UserRepository.save(userMap);
        return new ResponseData(ExceptionMsg.SUCCESS, userMap);
    }

    /**
     * @param userMap 用户信息
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseData updateUser(@RequestBody User userMap) {
        UserRepository.save(userMap);
        return new ResponseData(ExceptionMsg.SUCCESS, userMap);
    }

    /**
     * @param id 用户ID
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Response deleteStudent(@RequestParam("id") String id) {
        UserRepository.deleteById(id);
        return new Response(ExceptionMsg.SUCCESS);
    }

    /**
     * @param id 用户ID
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public ResponseData findById(@RequestParam("id") String id) {
        User user = UserRepository.findById(id);
        if (user==null){
            return new ResponseData(ExceptionMsg.FAILED, user);
        }
        return new ResponseData(ExceptionMsg.SUCCESS, user);
    }

    /**
     * @param name 用户姓名
     * @return
     */
    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public ResponseData findByName(@RequestParam("name") String name) {
        List<User> userList = UserRepository.findByName(name);
        if (userList.size() > 0) {
            return new ResponseData(ExceptionMsg.SUCCESS, userList);
        }
        return new ResponseData(ExceptionMsg.FAILED, userList);
    }

    /**
     * @return
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseData getAll() {
        List<User> list = UserRepository.findAll();
        return new ResponseData(ExceptionMsg.SUCCESS, list);
    }


    /**
     * @param id       用户ID
     * @param password 用户密码
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(@RequestParam("id") String id, @RequestParam("password") String password) {
        if (id.equals("") || password.equals("")) {
            return new ResponseData(ExceptionMsg.FAILED, "用户名密码不能为空");
        }
        User user = UserRepository.findById(id);
        if (user.getId() == null) {
            return new ResponseData(ExceptionMsg.FAILED, "用户不存在");
        } else if (!user.getPassword().equals(password)) {
            return new ResponseData(ExceptionMsg.SUCCESS, "密码错误");
        } else {
            return new ResponseData(ExceptionMsg.SUCCESS, user);
        }
    }

    /**
     * @param id     用户ID
     * @param oldPwd 用户原密码
     * @param newPwd 用户新密码
     * @return
     */
    @RequestMapping(value = "/modifyPwd", method = RequestMethod.POST)
    public Response modifyPwd(@RequestParam("id") String id, @RequestParam("oldPwd") String oldPwd,
                              @RequestParam("newPwd") String newPwd) {
        User user = UserRepository.findById(id);

        if (user.getId() == null) {
            return new ResponseData(ExceptionMsg.FAILED, "用户不存在");
        } else if (oldPwd.equals(user.getPassword())) {
            return new ResponseData(ExceptionMsg.FAILED, "旧密码错误");
        } else {
            user.setPassword(newPwd);
            UserRepository.save(user);
            return new ResponseData(ExceptionMsg.SUCCESS, user);
        }
    }
}

