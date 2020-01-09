package cn.cocopup.zy.microservice.consumer.service.impl;

import cn.cocopup.zy.dto.Person;
import cn.cocopup.zy.microservice.consumer.service.HandlerMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zy
 * @create 2019-12-10 14:15
 */
@Service
@Slf4j
public class ReceiveMsgService {

    @Autowired
    private HandlerMsg handlerMsg;

    @StreamListener(value = "jimi-fail-input")
    public void receiveTestMsg(@Payload Person person,@Header(name = "rocketmq_MESSAGE_ID")String msgId){
        log.info("接收到消息:{}",person);
        System.out.println(msgId);

        try {
            handlerMsg.handlerMqMsg(person);
        } catch (DuplicateKeyException e) {
            //e.printStackTrace();
            log.error("重复消费，唯一索引异常");
        }
    }


    /**
     * 指定消费通道消费失败时的处理
     * jimi-test-topic： 为topic
     * jimi-test-topic-consumer-group: 为消费的组
     */
   /* @ServiceActivator(inputChannel = "jimi-test-topic.jimi-test-topic-consumer-group.errors")
    public void error(ErrorMessage errorMessage){
        Throwable payload = errorMessage.getPayload();
        log.error("消费发生异常，",payload);
       *//* String message = payload.getCause().getMessage();
        Person person = JSON.parseObject(message, Person.class);
        System.out.println(person);*//*
        //获取消息体
        Message<?> originalMessage = errorMessage.getOriginalMessage();
        if(originalMessage != null){
            log.error("消息体：{}",originalMessage);
        }else{
            log.error("消息体为空");
        }
    }*/

}
