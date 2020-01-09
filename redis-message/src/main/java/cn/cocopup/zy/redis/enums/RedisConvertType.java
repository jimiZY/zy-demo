package cn.cocopup.zy.redis.enums;

import lombok.Getter;

@Getter
public enum RedisConvertType {
    /**
     * 序列化类型
     */
    JAVA("java"), JACK_SON("jackson"), STRING("string");

    private String desc;

    RedisConvertType(String desc) {
        this.desc = desc;
    }
}
