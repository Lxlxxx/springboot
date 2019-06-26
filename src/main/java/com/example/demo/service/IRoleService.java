package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;

import java.util.List;

/**
 * Created by Lxl on 2019/3/20.
 */
public interface IRoleService {

    Role saveUser(Role role);  ///创建Role用户


    User updateUser(User user);  //修改用户

    List<User> selectUser();   //查询用户


}
