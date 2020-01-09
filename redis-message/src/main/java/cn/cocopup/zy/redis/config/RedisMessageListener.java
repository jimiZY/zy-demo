package cn.cocopup.zy.redis.config;

import cn.cocopup.zy.redis.enums.RedisConvertType;
import cn.cocopup.zy.redis.msg.GroupMessage;
import cn.cocopup.zy.redis.msg.PrivateMessage;
import cn.cocopup.zy.redis.msg.ReceiverRedisMessage;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/**
 * @author zy
 * @create 2020-01-09 12:11
 */
@Configuration
public class RedisMessageListener {

    @Bean
    @Scope("prototype")
    public MessageListenerAdapter messageListenerAdapter(ReceiverRedisMessage receiver) {

        //Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = this.jacksonSerializer();
        //messageListenerAdapter.setSerializer(jackson2JsonRedisSerializer);

        return new MessageListenerAdapter(receiver, "handleMsg");

    }


    /**
     * redis消息监听器
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(messageListenerAdapter(new PrivateMessage(countDownLatch())),new PatternTopic("private_topic"));
        container.addMessageListener(messageListenerAdapter(new GroupMessage(countDownLatch())),new PatternTopic("group_topic"));
        return container;
    }


    @Bean
    public CountDownLatch countDownLatch() {
        return new CountDownLatch(1);
    }

    @Bean
    public RedisTemplate template(RedisConnectionFactory factory, RedisProperties redisProperties) {
        // 创建一个模板类
        RedisTemplate<String, Object> template = new RedisTemplate();
        // 将刚才的redis连接工厂设置到模板类中
        template.setConnectionFactory(factory);

        if (redisProperties.getKeyConvert() == RedisConvertType.STRING) {
            StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
            // 设置key的序列化器
            template.setKeySerializer(stringRedisSerializer);
            // hash的key也采用String的序列化方式
            template.setHashKeySerializer(stringRedisSerializer);
        }

        if (redisProperties.getValueConvert() == RedisConvertType.JACK_SON) {
            // 设置value的序列化器
            //使用Jackson 2，将对象序列化为JSON
            Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
            //GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
            //json转对象类，不设置默认的会将json转成hashmap
            ObjectMapper om = new ObjectMapper();
            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
            jackson2JsonRedisSerializer.setObjectMapper(om);

            template.setValueSerializer(jackson2JsonRedisSerializer);
            template.setHashValueSerializer(jackson2JsonRedisSerializer);

        } else if (redisProperties.getValueConvert() == RedisConvertType.STRING) {
            StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
            template.setValueSerializer(stringRedisSerializer);
            template.setHashValueSerializer(stringRedisSerializer);
        }
        template.afterPropertiesSet();
        return template;
    }


    private Jackson2JsonRedisSerializer jacksonSerializer() {

        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Objects.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(om);

        return serializer;
    }

}
