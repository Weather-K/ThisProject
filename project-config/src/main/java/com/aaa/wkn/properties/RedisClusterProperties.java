package com.aaa.wkn.properties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
/**
 * @author Weather
 * @Company AAA德云社
 * @date 2020/7/16 8:40
 */
@Component
@PropertySource("classpath:properties/redis_cluster.properties")
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisClusterProperties {
    private String nodes;
    private Integer maxAttempts;
    private Integer commandTimeout;
}
