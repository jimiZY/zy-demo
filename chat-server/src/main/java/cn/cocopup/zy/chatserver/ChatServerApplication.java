package cn.cocopup.zy.chatserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author zy
 */
@SpringBootApplication(scanBasePackages = {"cn.cocopup.zy"})
@MapperScan("cn.cocopup.zy.chatserver")
public class ChatServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatServerApplication.class, args);
    }

}
