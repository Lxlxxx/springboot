package com.example.demo.controller;

import com.example.demo.service.Aspect.AspectService;
import com.example.demo.service.Aspect.AspectService2;
import com.example.demo.service.Aspect.IAspectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Lxl on 2019/4/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest                     //Aspect测试类
public class AspectConfigText {

    @Autowired
   AspectService aspectService;

    @Autowired
    AspectService2 aspectService2;

    @Autowired
    IAspectService iAspectService;

    public String str ="before前置切入";
    public Long aLong =1L;

    @Test
    public void  carry(){
        aspectService.beforemethod();
        aspectService2.beforemethod2(aLong);   //参数是long类型的方法
        aspectService2.method(str);            //参数是String类型的方法
        iAspectService.thismethod();
    }


}
