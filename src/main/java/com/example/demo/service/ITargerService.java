package com.example.demo.service;

import com.example.demo.entity.Target;

/**
 * Created by as on 2019/3/13.
 */
public interface ITargerService {

    Target findByTid(int id);

    Target finByTname(String Tname);

    Target saveTarget(Target target);  //add

    void  deleteTarget(int id);

    void  save();   //addall


}
