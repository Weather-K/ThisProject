package com.aaa.wkn.config;
import org.springframework.beans.factory.annotation.Autowired;
import com.aaa.wkn.properties.RedisClusterProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;
/**
 * @author Weather
 * @Company AAA德云社
 * @date 2020/7/16 8:39
 */
@Configuration
public class RedisClusterConfig {
    @Autowired
    private RedisClusterProperties redisClusterProperties;

    @Bean
    public JedisCluster getJedisCluster() {
        String nodes = redisClusterProperties.getNodes();
        String[] split = nodes.split(",");
        Set<HostAndPort> hostAndPortSet = new HashSet<HostAndPort>();
        for(String hostPort : split) {
            String[] split1 = hostPort.split(":");// 0:ip 1:port
            HostAndPort hostAndPort = new HostAndPort(split1[0], Integer.parseInt(split1[1]));
            hostAndPortSet.add(hostAndPort);
        }
        return new JedisCluster(hostAndPortSet, redisClusterProperties.getCommandTimeout(), redisClusterProperties.getMaxAttempts());
    }
}
