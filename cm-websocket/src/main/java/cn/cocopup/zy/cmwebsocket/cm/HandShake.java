package cn.cocopup.zy.cmwebsocket.cm;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringJoiner;

/**
 * 握手
 * @author zy
 * @create 2019-10-17 14:34
 */
public class HandShake extends Message{

    private String ak = null;

    @JSONField(serialize = false)
    private String sk = null;

    private long t = 0;

    private String sign = null;

    public HandShake(String ak, String sk) {
        this.ak = ak;
        this.sk = sk;
        this.t = System.currentTimeMillis() / 1000;
        this.sign = signature();
    }

    private String signature() {
        StringJoiner sj = new StringJoiner("");
        ArrayList<String> data = new ArrayList<>();
        data.add(ak);
        data.add(sk);
        data.add(String.valueOf(t));
        Collections.sort(data);
        for (String s : data) {
            sj.add(s);
        }
        return DigestUtils.sha1Hex(sj.toString());
    }

    public String getSign() {
        return sign;
    }
    public String getAk() {
        return ak;
    }
    public String getSk() {
        return sk;
    }
    public long getT() {
        return t;
    }
}
