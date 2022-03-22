package com.example.zuccqa.controller;


/**
 * @author: ximo
 * @date: 2022/3/20 12:11
 * @description:
 */

import com.example.zuccqa.entity.User;
import com.example.zuccqa.repository.UserRepository;
import com.example.zuccqa.result.ExceptionMsg;
import com.example.zuccqa.result.Response;
import com.example.zuccqa.result.ResponseData;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
class UserController {
    protected Response result(ExceptionMsg msg) {
        return new Response(msg);
    }

    protected Response result() {
        return new Response();
    }

    @Autowired
    private UserRepository UserRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData addUser(@RequestBody Map<String, String> queryExample) {
        List<User> list = new LinkedList<>();

        for (Integer count = 0; count < 3; count++) {
            ObjectId id = new ObjectId();
            User user = new User();
            user.setName("count" + count);
            user.setId(id.toString());
            UserRepository.save(user);
            list.add(user);
        }
        return new ResponseData(ExceptionMsg.SUCCESS, list);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseData updateUser(@RequestBody Map<String, String> queryExample) {
        User user = UserRepository.findById(String.valueOf(31901028));
        user.setAge(200);
        UserRepository.save(user);
        return new ResponseData(ExceptionMsg.SUCCESS, user);
    }

    @RequestMapping(value = "/delete{id}", method = RequestMethod.DELETE)
    public Response deleteStudent(@PathVariable("id") String id) {
        UserRepository.deleteById(id);
        return result(ExceptionMsg.SUCCESS);
    }

    @RequestMapping(value = "/find{id}", method = RequestMethod.GET)
    public ResponseData getById(@PathVariable("id") String id) {
        User user = UserRepository.findById(id);

        return new ResponseData(ExceptionMsg.SUCCESS, user);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseData getAll() {
        List<User> list = UserRepository.findAll();
        return new ResponseData(ExceptionMsg.SUCCESS, list);
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Response login(@RequestBody Map<String, String> queryExample){
        String id = queryExample.get("id");
        String passwd = queryExample.get("password");
        if (id.equals("") || passwd.equals("")){
            return new ResponseData(ExceptionMsg.FAILED,"用户名密码不能为空");
        }
        User s = UserRepository.findById(id);
        if (!s.getId().equals(id)){
            return new ResponseData(ExceptionMsg.FAILED,"用户不存在");
        }
        else if (!s.getPassword().equals(passwd)){
            return new ResponseData(ExceptionMsg.SUCCESS,"密码错误");
        }
        else{
            return new ResponseData(ExceptionMsg.SUCCESS,"登陆成功");
        }

    }
}

