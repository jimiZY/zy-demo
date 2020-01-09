package cn.cocopup.zy.chatserver;

import cn.cocopup.zy.chatserver.config.ZzzTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.StringJoiner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatServerApplicationTests {

    @Test
    public void contextLoads() {
        String redisIp = ZzzTest.redisIp;
        Integer redisPort = ZzzTest.redisPort;
        String redisPwd = ZzzTest.redisPwd;

        if(redisIp != null){
            System.out.println("redisIp不为null"+ redisIp);
        }
        if(redisPort != null){
            System.out.println("redisPort不为null"+redisPort);
        }
        if(redisPwd != null){
            System.out.println("redisPwd不为null"+redisPwd);
        }else{
            System.out.println("redisPwd为空");
        }
    }

}
