package com.example.demo.service.Aspect;

import org.springframework.stereotype.Service;

/**
 * Created by Lxl on 2019/4/6.
 */

public class SubService  implements ISubService{

    @Override
    public void Request() {
        System.out.println("is  proxy method ");
    }

    @Override
    public void hello() {
        System.out.println("hello");
    }
}
