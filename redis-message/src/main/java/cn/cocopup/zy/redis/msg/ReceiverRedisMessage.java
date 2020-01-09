package cn.cocopup.zy.redis.msg;

import org.springframework.stereotype.Component;


/**
 * 接收redis的消息
 * @author zy
 * @create 2020-01-09 14:28
 */
@Component
public interface ReceiverRedisMessage {

    /**
     * 处理接收到的消息
     * @param message
     */
    void handleMsg(String message);
}
