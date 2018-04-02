//package com.kf.data.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
///**
// * @Title: RedisConfig.java
// * @Package com.kf.data.config
// * @Description: TODO(用一句话描述该文件做什么)
// * @author: liangyt
// * @date: 2018年4月2日 下午12:01:04
// * @version V1.0
// */
////@Configuration
////@EnableCaching
//public class RedisConfig extends CachingConfigurerSupport {
//
//	@Value("${spring.redis.host}")
//	private String host;
//
//	@Value("${spring.redis.port}")
//	private int port;
//
//	@Value("${spring.redis.timeout}")
//	private int timeout;
// 
//	@Value("${spring.redis.pool.max-idle}")
//	private int maxIdle;
//
//	@Value("${spring.redis.pool.max-wait}")
//	private long maxWaitMillis;
//
//	@Bean
//	public JedisPool redisPoolFactory() {
//		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//		jedisPoolConfig.setMaxIdle(maxIdle);
//		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
//		JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);
//		return jedisPool;
//	}
//
//}
