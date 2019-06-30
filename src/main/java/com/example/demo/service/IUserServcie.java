package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by Lxl on 2019/3/20.
 */
public interface IUserServcie {

    void saveUser();  ///创建User用户

    void deleteUser(int id );  // 根据id来删除用户

    User updateUser(User user);  //修改用户

    List<User>  selectUser();   //查询用户

    Page<User> getUserPage(Integer page ,Integer size,final User user);

    void updateUserById(int Id,String username ,String password);

    Map<String ,Object> count(String username);
}
