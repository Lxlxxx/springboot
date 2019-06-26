package com.example.demo.rabbitmq;

import com.example.demo.entity.Target;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Lxl on 2019/3/18.
 */
@Component
public class RabbitSender {

    @Autowired
    private AmqpTemplate   rabbitmqtemplate;

    private  SimpleDateFormat simpleDateFormat;

    /***
     * 发送者
     */
    public  void  send1() throws IOException {
        /* simpleDateFormat =new SimpleDateFormat("YYYYmmdd");
        String context= "hello" + simpleDateFormat.format(new Date()) ;
        System.out.println("sender     :"+ context);*/
        Target target =new Target("赵四",25);
        byte[] bytes =getByteFromObject(target);
        System.out.println("sender1    :"+target.toString());
        this.rabbitmqtemplate.convertAndSend("spring-boot-exchage","hello",bytes);
       // getLatch().countDown();
    }

    public  void  send2(){
        simpleDateFormat =new SimpleDateFormat("YYYYMMdd");
        String context="hello1  "+simpleDateFormat.format(new Date());
        System.out.println("sender2    :"+context);
        rabbitmqtemplate.convertAndSend("spring-boot-exchage","hello1",context);
        // getLatch().countDown();
    }

    //将对象转为字节码
    public byte[] getByteFromObject(Serializable obj) throws IOException {
        if (obj==null){
            return  null;

        }
        ByteArrayOutputStream  outputStream =new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream =new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(obj);
        return outputStream.toByteArray();



    }

    public CountDownLatch getLatch(){
        return  getLatch();
    }
}
