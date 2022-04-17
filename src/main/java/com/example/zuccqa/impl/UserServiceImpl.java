package com.example.zuccqa.impl;

import com.example.zuccqa.entity.User;
import com.example.zuccqa.exception.BusinessException;
import com.example.zuccqa.repository.UserRepository;
import com.example.zuccqa.service.UserService;
import com.example.zuccqa.utils.Constant;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author: ximo
 * @date: 2022/4/17 14:16
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * @param userMap 用户信息
     * @return
     */
    @Override
    public String addUser(User userMap) {
        User user = new User();
        BeanUtils.copyProperties(userMap, user);
        System.out.println(user.getId());
        if (user.getId() == null || user.getId().equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "用户账号为空");
        } else if (userRepository.findById(userMap.getId())!=null){
            throw new BusinessException(Constant.PARAM_ERROR, "用户名已存在");
        }
        else if (user.getPassword() == null || user.getPassword().equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "密码为空");
        }
        userRepository.save(user);
        return user.getId();
    }

    /**
     * @param userMap 用户信息
     * @return
     */
    @Override
    public String updateUser(User userMap) {
        User user = new User();
        BeanUtils.copyProperties(userMap, user);
        if (user.getId() == null || user.getId().equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "用户Id为空");
        }
        if (userRepository.findById(user.getId()) == null) {
            throw new BusinessException(Constant.QUERY_EMPTY, "找不到该用户: 用户Id: " + user.getId() + ", 不能更新");
        }
        userRepository.save(userMap);
        return user.getId();
    }

    /**
     * @param id 用户ID
     * @return
     */
    @Override
    public String deleteUser(String id) {
        if (id.equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "用户ID为空");
        }
        if (userRepository.findById(id) == null) {
            throw new BusinessException(Constant.QUERY_EMPTY, "找不到该用户: 用户Id: " + id + ", 不能删除");
        }
        userRepository.deleteById(id);
        return id;
    }

    /**
     * @param id 用户ID
     * @return
     */
    @Override
    public User findById(String id) {
        if (id.equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "用户ID为空");
        }
        User user = userRepository.findById(id);
        if (user == null) {
            throw new BusinessException(Constant.QUERY_EMPTY, "找不到该用户: 用户Id: " + id);
        }
        return user;
    }

    /**
     * @param name 用户姓名
     * @return
     */
    @Override
    public List<User> findByName(String name) {
        if (name.equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "姓名为空");
        }
        List<User> userList = userRepository.findByName(name);
        if (userList.size() == 0) {
            throw new BusinessException(Constant.QUERY_EMPTY, "找不到该用户: 用户姓名: " + name);
        }
        return userList;
    }

    /**
     * @return
     */
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }


    /**
     * @param id       用户ID
     * @param password 用户密码
     * @return
     */
    @Override
    public String login(String id, String password) {
        if (id.equals("") || password.equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "用户名密码不能为空");
        }
        User user = userRepository.findById(id);
        if (user == null) {
            throw new BusinessException(Constant.QUERY_EMPTY, "用户不存在");
        } else if (!user.getPassword().equals(password)) {
            throw new BusinessException(Constant.QUERY_EMPTY, "密码错误");
        } else {
            return id;
        }
    }

    /**
     * @param id     用户ID
     * @param oldPwd 用户原密码
     * @param newPwd 用户新密码
     * @return
     */
    @Override
    public String modifyPwd(String id, String oldPwd,
                             String newPwd) {
        if (id.equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "用户ID不能为空");
        }
        User user = userRepository.findById(id);

        if (user == null) {
            throw new BusinessException(Constant.QUERY_EMPTY, "用户不存在");
        } else if (!oldPwd.equals(user.getPassword())) {
            throw new BusinessException(Constant.QUERY_EMPTY, "旧密码错误");
        } else {
            user.setPassword(newPwd);
            userRepository.save(user);
            return user.getId();
        }
    }
}
