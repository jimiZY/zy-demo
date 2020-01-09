package cn.cocopup.zy.cmwebsocket.cm;


import lombok.extern.slf4j.Slf4j;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

/**
 * @author zy
 * @create 2019-10-17 14:36
 */
@Slf4j
public class CmWebSocketClient extends WebSocketClient {

    private String ak = null;
    private String sk = null;
    private Boolean needReconneced = true;



    public CmWebSocketClient(URI serverUri, String ak, String sk) {
        super(serverUri);
        this.ak = ak;
        this.sk = sk;
    }

    @Override
    public void onOpen(ServerHandshake handshake) {
        push(new HandShake(ak, sk));
    }

    @Override
    public void onMessage(String message) {
        log.info("CmWebSocketClient message: {}", message);
        this.push(new Ack(1));

    }



    public void push(Message msg) {
        byte[] data = msg.serialize();
        log.info("CmWebSocketClient push: {}", new String(data));
        if (!this.isOpen()) {
            log.error("预警websocket is not open");
            return;
        }

        while (!this.getReadyState().equals(ReadyState.OPEN)) {
            log.debug("连接中···请稍后");
        }

        this.send(msg.serialize());
    }




    @Override
    public void onClose(int code, String reason, boolean remote) {
        log.info("长矛websocket onClose: code:{}，reason {}", code, reason);
       // reConnect();
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
        //reConnect();
    }

    private void reConnect(){
        if(needReconneced){
            log.info("断开之后重连");
            this.reconnect();
        }
    }
}


