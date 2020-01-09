package cn.cocopup.zy.cmwebsocket.cm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;

/**
 * @author zy
 * @create 2019-10-17 14:50
 */
@Component
public class CmDataServer{




    public void start() {

        String address = "ws://192.168.199.230/ws";
        String ak = "0o4JU8Emx8IIApJ0";
        String sk = "jShHS5sSH6OkWGXV";
        try {
            CmWebSocketClient myClient = new CmWebSocketClient(URI.create(address), ak, sk);
            myClient.connect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}