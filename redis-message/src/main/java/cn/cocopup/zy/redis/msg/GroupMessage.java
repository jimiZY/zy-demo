package cn.cocopup.zy.redis.msg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * @author zy
 * @create 2020-01-09 16:29
 */
@Slf4j
public class GroupMessage implements ReceiverRedisMessage {

    private CountDownLatch countDownLatch;

    @Autowired
    public GroupMessage(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;

    }


    @Override
    public void handleMsg(String message) {

        log.info("接收到Group 消息，{}", message);
        countDownLatch.countDown();
    }
}
