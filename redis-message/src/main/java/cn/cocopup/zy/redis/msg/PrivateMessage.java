package cn.cocopup.zy.redis.msg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author zy
 * @create 2020-01-09 16:28
 */
@Slf4j
public class PrivateMessage implements ReceiverRedisMessage {

    private CountDownLatch countDownLatch;

    @Autowired
    public PrivateMessage(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }


    @Override
    public void handleMsg(String message) {
        log.info("收到private 消息 {}",message);
        countDownLatch.countDown();
    }
}
