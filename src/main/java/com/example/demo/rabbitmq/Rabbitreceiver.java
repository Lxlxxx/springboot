package com.example.demo.rabbitmq;

import com.example.demo.entity.Target;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by Lxl on 2019/3/18.
 */

/**
 * 接收者
 */

@Component
@RabbitListener(queues = "hello1")
public class Rabbitreceiver {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void  Proess(byte[] bytes) throws Exception {

        Target target =(Target)getObjectFromByte(bytes);
        System.out.println("message    :"+target.toString());
       // logger.info("处理器接收队列：spring-boot-exchage当中的消息： " + hello1);
        logger.info("处理器接收队列：spring-boot-exchage当中的消息： " + target.getTname()+target.getTage());
    }
    //把字节码转为对象
    public Object getObjectFromByte(byte[]  bytes) throws Exception{
        if (bytes==null ||bytes.length==0){
            return  null;
        }
        ByteArrayInputStream by =new ByteArrayInputStream(bytes);
        ObjectInputStream ob =new ObjectInputStream(by);

        return   ob.readObject();


    }

    @RabbitHandler
    public void  Proess1() throws Exception {


        System.out.println("消费着以消费 send2的信息");
        // logger.info("处理器接收队列：spring-boot-exchage当中的消息： " + hello1);
        logger.info("处理器接收队列：spring-boot-exchage当中的消息： "  );
    }
}
