package com.example.zuccqa.controller;


/**
 * @author: ximo
 * @date: 2022/3/20 12:11
 * @description:
 */

import com.example.zuccqa.entity.User;
import com.example.zuccqa.result.ExceptionMsg;
import com.example.zuccqa.result.Response;
import com.example.zuccqa.result.ResponseData;
import com.example.zuccqa.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/user")
class UserController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * @param userMap 用户信息
     * @return
     */

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData addUser(@RequestBody User userMap) {
        String id = userService.addUser(userMap);
        logger.warn("create student id: {} ", id);
        return new ResponseData(ExceptionMsg.SUCCESS, id);
    }

    /**
     * @param userMap 用户信息
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseData updateUser(@RequestBody User userMap) {
        String id = userService.updateUser(userMap);
        logger.warn("update student id: {} ", id);
        return new ResponseData(ExceptionMsg.SUCCESS, userMap);
    }

    /**
     * @param id 用户ID
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Response deleteUser(@RequestParam("id") String id) {
        String sid = userService.deleteUser(id);
        logger.warn("delete student id: {} ", sid);
        return new Response(ExceptionMsg.SUCCESS);
    }

    /**
     * 通过用户ID获取用户信息
     *
     * @param id 用户ID
     * @return
     */
    @RequestMapping(value = "/viewUserById", method = RequestMethod.GET)
    public ResponseData viewUserById(@RequestParam("id") String id) {
        User user = userService.findById(id);
        logger.warn("query student id: {}", id);
        return new ResponseData(ExceptionMsg.SUCCESS, user);
    }

    /**
     * 通过用户名称获取用户信息
     *
     * @param name 用户姓名
     * @return
     */
    @RequestMapping(value = "/viewUsersByName", method = RequestMethod.GET)
    public ResponseData viewUserByName(@RequestParam("name") String name) {
        List<User> userList = userService.findByName(name);
        logger.warn("query students name: {}", name);
        return new ResponseData(ExceptionMsg.SUCCESS, userList);
    }

    /**
     * @return
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseData getAll() {
        List<User> list = userService.getAll();
        logger.warn("query all students");
        return new ResponseData(ExceptionMsg.SUCCESS, list);
    }


    /**
     * 通过账号密码实现登陆
     *
     * @param id       用户ID
     * @param password 用户密码
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(@RequestParam("id") String id, @RequestParam("password") String password) {

        String userId = userService.login(id, password);
        logger.info("student id: {} login", userId);
        return new ResponseData(ExceptionMsg.SUCCESS, userId);
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

        String userId = userService.modifyPwd(id, oldPwd, newPwd);
        logger.warn("student id: {} modified password", userId);
        return new ResponseData(ExceptionMsg.SUCCESS, userId);
    }
}

