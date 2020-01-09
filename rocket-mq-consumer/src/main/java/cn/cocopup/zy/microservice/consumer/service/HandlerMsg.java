package cn.cocopup.zy.microservice.consumer.service;

import cn.cocopup.zy.dto.Person;

/**
 * @author zy
 * @create 2019-12-10 16:05
 */
public interface HandlerMsg {

    void handlerMqMsg(Person person);
}
