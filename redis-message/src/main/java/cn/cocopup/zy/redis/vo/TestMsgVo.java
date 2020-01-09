package cn.cocopup.zy.redis.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zy
 * @create 2020-01-09 15:20
 */
@Data
@Accessors(chain = true)
public class TestMsgVo {

    // 1是gropu 其他是pri
    private Integer type;

    private Integer num;

    private String content;
}
