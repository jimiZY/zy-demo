package cn.cocopup.zy.rocket.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * @author zy
 * @create 2019-11-12 18:54
 */
@Component
public interface Source {

    /**
     * 生产者通道1
     * @return
     */
    @Output("jimi-fail-output")
    MessageChannel jimiFailTest();
}
