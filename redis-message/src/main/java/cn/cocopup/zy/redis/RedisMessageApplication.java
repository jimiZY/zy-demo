package cn.cocopup.zy.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zy
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class RedisMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisMessageApplication.class, args);
    }

}
