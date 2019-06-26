package com.example.demo.service.Aspect;




/**
 * Created by Lxl on 2019/4/6.
 */
public class Client {

    public static void main(String[] args) {
      /*  ISubService iSubService =new Proxy(new SubService ());
        iSubService.Request();
*/

        //静态代理模式
        ISubService iSubService = (ISubService) java.lang.reflect.Proxy.newProxyInstance(Client.class.getClassLoader(),new Class[]{ISubService.class},new
        jdkProxy(new SubService()));
        iSubService.hello();


    }
}
