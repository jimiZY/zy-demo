package cn.cocopup.zy.chatserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * websocket的配置
 * @author zy
 * @create 2019-10-11 9:23
 */
public class WebSocketConfigure {

    /**
     * 用途：扫描并注册所有携带@ServerEndpoint注解的实例。 @ServerEndpoint("/net.cnns.zy.websocket")
     * PS：如果使用外部容器 则无需提供ServerEndpointExporter。
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    /**
     * 支持注入其他类
     */
    @Bean
    public MyEndpointConfigure  newMyEndpointConfigure (){
        return new MyEndpointConfigure ();
    }
}
