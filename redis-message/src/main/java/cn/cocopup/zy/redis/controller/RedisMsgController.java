package cn.cocopup.zy.redis.controller;

import cn.cocopup.zy.redis.vo.TestMsgVo;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zy
 * @create 2020-01-09 15:18
 */
@RestController
@RequestMapping("/redis")
public class RedisMsgController {

    @Autowired
    RedisTemplate redisTemplate;

    @PostMapping("/send")
    public void sendMsg(@RequestBody TestMsgVo testMsgVo) {
        System.out.println("controller收到请求。。。");

        Integer type = testMsgVo.getType();
        if (type == 1) {
            redisTemplate.convertAndSend("group_topic", JSON.toJSONString(testMsgVo));
        } else {
            redisTemplate.convertAndSend("private_topic", JSON.toJSONString(testMsgVo));

        }

    }
}
