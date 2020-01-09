package cn.cocopup.zy.chatserver.controller;

import cn.cocopup.zy.chatserver.config.MyEndpointConfigure;
import cn.cocopup.zy.chatserver.constant.ChatServerConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zy
 * @create 2019-10-11 9:29
 */
@RestController
@Slf4j
@RequestMapping("/cn/cocopup/zy/chat/websocket")
@ServerEndpoint(value = "/cn/cocopup/zy/chat/websocket/{user}",configurator = MyEndpointConfigure.class)
public class WebSocketServerEndpoint {

    /**
     * 在线用户的map集合
     */
    private static Map<String,Session> userMap = new ConcurrentHashMap<>();

    /**
     * 在线成员
     */
    private static AtomicInteger onlineNum;


    /**
     * 链接
     * @param session 会话信息
     * @param user 用户id
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("user") String user){
        if(StringUtils.isNotBlank(user)){
            if(userMap.containsKey(user)){
                userMap.remove(user);
                this.subOnlineNum();
            }
            userMap.put(user,session);
            this.addOnlineNum();
            log.info("有一个新的链接加入: {},当前人数 {}",user,this.getOnlineNum());
        }
    }


    /**
     * 用户关闭链接
     * @param session
     */
    @OnClose
    public void onClose(Session session){
        String user = getUser(session);
        if(StringUtils.isNotEmpty(user)){
            if(userMap.containsKey(user)){
                userMap.remove(user);
                this.subOnlineNum();
            }
            log.info("有一个连接断开:{} ，当前在线{} 人",user, this.getOnlineNum());
        }
    }


    /**
     * 连接错误
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        String user = getUser(session);
        log.error("用户 {} 出现错误",user);
        error.printStackTrace();
    }


    /**
     * 收到客户端的消息，可以回调
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message,Session session){
        message = message.trim();
        if(StringUtils.isNotBlank(message) && message != ChatServerConstant.UNDEFINED){
            log.info("接收到客服端的消息：",message);
        }
    }


    /**
     * 服务器主动发送消息,不加注解，自己选择实现
     *
     * @param msg
     * @throws IOException
     */
    public synchronized void onSend(Session session, String msg){
        try {
            session.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            //e.printStackTrace();
            log.error("服务发送消息异常！");
        }
    }


    /**
     * 获取用户id
     * @param session
     * @return
     */
    private String getUser(Session session) {
        AtomicReference<String> user = new AtomicReference<>("");
        if(userMap.containsValue(session)){
            userMap.forEach((k,v) ->{
                if(v == session){
                    user.set(k);
                }
            });
        }
        return user.get();
    }

    /**
     * 减少一个在线人数
     */
    private void subOnlineNum() {
        onlineNum.getAndDecrement();
    }

    /**
     * 添加一个在线人数
     */
    private void addOnlineNum(){
        onlineNum.getAndIncrement();
    }

    /**
     * 获取在线人数
     * @return 在线人数
     */
    private Integer getOnlineNum(){return onlineNum.get();}
}
