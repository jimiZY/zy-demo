package cn.cocopup.zy.chatserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author zy
 * @create 2019-11-18 9:15
 */
@Component
public class ZzzTest{


    @Value("${redis.ip}")
    private String ip;

    @Value("${redis.port}")
    private Integer port;

    @Value("${redis.pwd:disabled}")
    private String pwd;

    public static  String redisIp;
    public static  Integer redisPort;
    public static  String redisPwd;




    @PostConstruct
    public void init(){
        getValue(ip,port,pwd);
        System.out.println("PostConstruct--ip "+ ZzzTest.redisIp);
        System.out.println("PostConstruct===port "+ ZzzTest.redisPort);
        System.out.println("PostConstruct==pwd "+ ZzzTest.redisPwd);
    }

    public static void getValue(String ip,Integer port,String pwd){
        ZzzTest.redisIp = ip;
        ZzzTest.redisPort = port;

        ZzzTest.redisPwd = "disabled".equals(pwd) ? null : pwd;
    }
}
