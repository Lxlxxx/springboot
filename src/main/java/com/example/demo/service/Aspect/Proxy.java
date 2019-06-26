package com.example.demo.service.Aspect;




import java.lang.reflect.Method;

/**
 * Created by Lxl on 2019/4/6.
 */

/**
 * 静态代理模式demo
 */
public class Proxy implements  ISubService {

    private SubService subService;

    public Proxy(SubService subService) {
        this.subService = subService;
    }

    @Override
    public void Request() {
        try {
            System.out.println("before");
            subService.Request();
        }catch (Exception e){
            System.out.println("ex"+e.getMessage());
            throw  e;
        }finally {
            System.out.println("after");
        }
    }

    @Override
    public void hello() {
        subService.hello();
    }


}

