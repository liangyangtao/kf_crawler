package com.kf.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

/**
 * @Title: FileUploadConfiguration.java
 * @Package com.kf.data.config
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: liangyt
 * @date: 2018年4月8日 下午3:42:09
 * @version V1.0
 */
@Configuration
public class FileUploadConfiguration {

	@Bean(name = "multipartResolver")
	StandardServletMultipartResolver standardServletMultipartResolver() {
		StandardServletMultipartResolver standardServletMultipartResolver = new StandardServletMultipartResolver();
		return standardServletMultipartResolver;
	}
}
