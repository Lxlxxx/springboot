package com.example.demo.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by Lxl on 2019/3/18.
 */

/***
 *
 * 队列配置
 */

@Configuration
public class RabbitmqConfig {

    private  final String  Queue_name ="hello";

    private  final String  Queue_name1 ="hello1";




    @Bean
    public Queue Queue1(){

        return  new Queue(Queue_name);
    }

    @Bean
    public Queue Queue2(){

        return  new Queue(Queue_name1);
    }

    //定义一个topic交换器
    @Bean
  public   TopicExchange exchange(){
        return  new TopicExchange("spring-boot-exchage");

    }
    //将消息队里与exchange 绑定
    @Bean
   public  Binding binding(Queue Queue1,TopicExchange topicExchange){
        return BindingBuilder.bind(Queue1).to(topicExchange).with(Queue_name);
}

    //将消息队里与exchange 绑定
    @Bean
    public  Binding binding1(Queue Queue2,TopicExchange topicExchange){
        return BindingBuilder.bind(Queue2).to(topicExchange).with(Queue_name1);
    }

    //创建消息监听的容器
    @Bean
  public  SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter){

        SimpleMessageListenerContainer container =new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
      //  container.setQueueNames(Queue_name);
        container.setQueueNames(Queue_name1);
        container.setMessageListener(listenerAdapter);
        return container;
    }
     //消息监听适配器
    @Bean
   public MessageListenerAdapter messageListenerAdapter(Rabbitreceiver rabbitreceiver){
        MessageListenerAdapter    messageListenerAdapter=  new MessageListenerAdapter(rabbitreceiver,"Proess1");

        return  messageListenerAdapter;
    }


}
