package cn.cocopup.zy.microservice.consumer.service.impl;

import cn.cocopup.zy.dto.Person;
import cn.cocopup.zy.microservice.consumer.service.HandlerMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
 * @author zy
 * @create 2019-12-10 16:06
 */
@Service
@Slf4j
public class HandlerMsgImpl implements HandlerMsg {


    @Override
    public void handlerMqMsg(Person person) {
        log.info("service,处理消息,{}", person);

        throw new IllegalArgumentException("参数异常");
//        throw new DuplicateKeyException("唯一索引冲突");
    }
}
