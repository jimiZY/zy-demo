/*
package cn.cocopup.zy.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

*/
/**
 * @author zy
 * @create 2020-01-09 12:05
 *//*

@Configuration
public class RedisHostsConfig {

    @Value(value = "${spring.redis.cluster.nodes}")
    private String hosts;

    @Bean
    public JedisCluster jedisCluster() {

        try {
            Set<HostAndPort> nodes = new HashSet<>();
            String[] hostArray = hosts.split(",");

            for (String host : hostArray) {
                String[] ipAndPort = host.split(":");
                nodes.add(new HostAndPort(ipAndPort[0], Integer.parseInt(ipAndPort[1])));
            }

            JedisCluster jedisCluster = new JedisCluster(nodes);

            return jedisCluster;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }

    }
}
*/
