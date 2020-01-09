package cn.cocopup.zy.cmwebsocket.cm;

import com.alibaba.fastjson.JSON;

/**
 * @author zy
 * @create 2019-10-17 14:35
 */
public class Message {
    public byte[] serialize() {
        return JSON.toJSONBytes(this);
    }
}
