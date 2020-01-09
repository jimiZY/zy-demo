package cn.cocopup.zy.cmwebsocket.config;

import cn.cocopup.zy.cmwebsocket.cm.CmWebSocketClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

/**
 * @author zy
 * @create 2019-11-14 14:14
 */
//@Configuration
public class BeanConfiguration {

    @Bean
    public CmWebSocketClient getCmWebSocketClient(ConfigProperties configProperties){

        String address = configProperties.getAddress();
        String ak = configProperties.getAk();
        String sk = configProperties.getSk();

        return new CmWebSocketClient(URI.create(address), ak, sk);
    }
}
