package com.example.demo.service.Aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Lxl on 2019/4/6.
 */
public class jdkProxy implements InvocationHandler {

    private  SubService subService;

    public jdkProxy(SubService subService) {
        this.subService = subService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            System.out.println("before");
            method.invoke(subService,args);

        }catch (Exception e){
            System.out.println("ex: "+e.getMessage());
            throw  e;
        }finally {
            System.out.println("Atfer");
        }
        return null;
    }
}
