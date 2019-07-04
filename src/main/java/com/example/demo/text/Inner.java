package com.example.demo.text;

import java.util.concurrent.*;

/**
 * Created by Lxl on 2019/4/1.
 */

//内部类
public class Inner {

    private  static String key ="我是内部类的key属性";

    private    static String value ="我是内部类的value属性";

    private static  String parm ="我是固定长度的线程池";



          static class  Inner1{

        public void getString(){

            System.out.println("我是静态内部类！！！！"+"\n"+"我要访问类Inner的key属性："+key+
            "\n"+"我要访问类Inner的value属性："+value);

        }


    }

     class  Inner2{

        public void getString(){

            System.out.println("我是静态内部类！！！！"+"\n"+"我要访问类Inner的key属性："+key+
                    "\n"+"我要访问类Inner的value属性："+value);

        }


    }

    public static void main(String[] args) {
              Inner inner =new Inner();
              Inner.Inner2  inner2  =inner.new Inner2();
              Inner.Inner1 inner1 = new Inner.Inner1();
              inner1.getString();


        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(1 +key);

            }
        });executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(2 +value);

            }
        });executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(3 +parm);

            }
        });


       ScheduledExecutorService scheduledExecutorService =Executors.newScheduledThreadPool(3);

            scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    System.out.println("我是定长线程！！！！！" );
                }
            },1,3, TimeUnit.SECONDS);
        }









}
