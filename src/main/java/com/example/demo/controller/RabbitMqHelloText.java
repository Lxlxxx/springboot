package com.example.demo.controller;

import com.example.demo.rabbitmq.RabbitSender;
import com.example.demo.rabbitmq.Rabbitreceiver;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * Created by Lxl on 2019/3/18.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloText {

    /*@Autowired
    private final RabbitTemplate rabbitTemplate;
    @Autowired
    private final ConfigurableApplicationContext context;*/
    @Autowired
    private  RabbitSender  rabbitSender;



   /* @Override
    public void run(String... strings) throws Exception {
        System.out.println("Sending message !!!!!");
        rabbitTemplate.convertAndSend("hello","Hello RabbitMQ");
        rabbitSender.getLatch().await(10000, TimeUnit.MILLISECONDS);
        context.close();

    }*/

    @org.junit.Test
    public void hello() throws IOException {

           // rabbitSender.send1();
          //  System.out.println("queue1消息发送成功！!!!!!!!!!!!!!!!!!!");
           rabbitSender.send2();
            System.out.println("queue2消息发送成功! !!!!!!!!!!!!!!!!!!");

    }



}
