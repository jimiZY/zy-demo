package cn.cocopup.zy.rocket;

import cn.cocopup.zy.rocket.service.Source;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author zy
 */
@SpringBootApplication(scanBasePackages = {"cn.cocopup.zy"})
@MapperScan("cn.cocopup.zy.rocket.mapper")
@EnableBinding(Source.class)
public class RocketDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketDemoApplication.class, args);
    }

}
