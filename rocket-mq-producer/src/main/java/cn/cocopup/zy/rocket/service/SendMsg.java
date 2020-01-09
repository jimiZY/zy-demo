package cn.cocopup.zy.rocket.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

/**
 * @author zy
 * @create 2019-11-12 19:01
 */
@Service
@Slf4j
public class SendMsg {

    @Autowired
    private Source source;


    /**
     * 发送带tag的消息
     * @param msg
     * @param tag
     * @param <T>
     */
    public<T> void sendObject(T msg,String tag){

        Message<T> message = MessageBuilder.withPayload(msg)
                .setHeader(MessageConst.PROPERTY_TAGS, tag)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE)
                .build();

        log.info("开始发送消息");

        source.jimiFailTest().send(message);
    }
}
