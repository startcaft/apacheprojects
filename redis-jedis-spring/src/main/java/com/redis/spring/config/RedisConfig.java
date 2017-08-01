package com.redis.spring.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.pool.max-active}")
    private int maxActive;
    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;
    @Value("${spring.redis.pool.min-idle}")
    private int minIdile;
    @Value("${spring.redis.pool.max-wait}")
    private int maxWait;

    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        {
            JedisPoolConfig poolConfig = new JedisPoolConfig();
            poolConfig.setMaxTotal(maxActive);
            poolConfig.setMaxIdle(maxIdle);
            poolConfig.setMinIdle(minIdile);
            poolConfig.setMaxWaitMillis(maxWait);
            return poolConfig;
        }
    }

    @Bean
    public JedisPool jedisPool(@Autowired JedisPoolConfig jedisPoolConfig){
        {
            JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port,timeout);
            return jedisPool;
        }
    }
}
