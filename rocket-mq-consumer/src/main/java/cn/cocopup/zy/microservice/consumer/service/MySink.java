package cn.cocopup.zy.microservice.consumer.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * @author zy
 * @create 2019-12-10 14:13
 */
@Component
public interface MySink {

    /**
     *消息通道
     * @return
     */
    @Input("jimi-fail-input")
    SubscribableChannel jimiFailInput();
}
