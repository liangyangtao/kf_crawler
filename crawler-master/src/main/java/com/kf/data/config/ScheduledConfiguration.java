package com.kf.data.config;

import java.util.concurrent.ScheduledThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: ScheduledConfiguration.java
 * @Package com.kf.data.config
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: liangyt
 * @date: 2018年4月2日 下午2:38:50
 * @version V1.0
 */
@Configuration
public class ScheduledConfiguration {

	@Bean
	public ScheduledThreadPoolExecutor scheduledExecutorService() {
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(128);
		return executor;
	}
}
