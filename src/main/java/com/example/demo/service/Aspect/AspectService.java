package com.example.demo.service.Aspect;

import org.springframework.stereotype.Service;

/**
 * Created by Lxl on 2019/4/6.
 */
@Service
public class AspectService implements IAspectService {

    @Override
    public void thismethod() {
        System.out.println("正在执行的是前置方法~~~~~~~~~~~~");
    }



    public void beforemethod(){
        System.out.println("正在执行的是前置方法~~~~~~~~~~~~");
    }
}
