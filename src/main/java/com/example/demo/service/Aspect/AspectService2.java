package com.example.demo.service.Aspect;

import org.springframework.stereotype.Service;

/**
 * Created by Lxl on 2019/4/6.
 */
@Service
public class AspectService2 {

    public void beforemethod2(Long parm){
        System.out.println("有参数的方法正在被匹配"+parm);
    }

    public void method(String parm1){
        System.out.println("其他参数的方法#####" +parm1);

    }
}
