package com.kf.data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/***
 * 
 * @Title: CrawlerApp.java
 * @Package com.kf.data
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: liangyt
 * @date: 2018年3月13日 上午11:54:31
 * @version V1.0
 */
@ComponentScan({ "com.kf.data" })
@MapperScan({ "com.kf.data.mybatis.mapper" })
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class CrawlerApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CrawlerApp.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CrawlerApp.class);
	}

}
