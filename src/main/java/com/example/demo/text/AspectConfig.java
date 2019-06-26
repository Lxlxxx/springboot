package com.example.demo.text;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Lxl on 2019/4/6.
 */
@Aspect
@Component
public class AspectConfig {



    /*//定义需要切入的类 匹配参数以及方法
    public void BeforeText(){

    }*/

    @Pointcut("execution(public * com.example.demo.service.Aspect.*Service.*(..))")
        public void AroundText(){

    }

    /*@Before("AroundText()")
    public void  before(){
        System.out.println();
        System.out.println("###before切入>>>>>>>>>>>>>>>>>>>>");

    }*/

    @Around("AroundText()")
    public void around(){
        System.out.println();
        System.out.println("###around切入>>>>>>>>>>>>>>>>>>>>");

    }



   /* @After("BeforeText()")
    public  void after(){
        System.out.println();
        System.out.println("###After切入>>>>>>>>>>>>>>>>>>>>>");
    }*/





}
