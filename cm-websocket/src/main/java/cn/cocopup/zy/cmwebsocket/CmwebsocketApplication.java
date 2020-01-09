package cn.cocopup.zy.cmwebsocket;

import cn.cocopup.zy.cmwebsocket.cm.CmDataServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"cn.cocopup.zy.cmwebsocket"})
public class CmwebsocketApplication implements CommandLineRunner {

    @Autowired
    private CmDataServer cmDataServer;


    public static void main(String[] args) {
        SpringApplication.run(CmwebsocketApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        cmDataServer.start();
    }
}
