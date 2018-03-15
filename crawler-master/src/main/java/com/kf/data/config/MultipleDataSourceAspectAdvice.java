package com.kf.data.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MultipleDataSourceAspectAdvice {

	@Before("execution(* com.kf.data.service.crawler.**.*(..))")
	public void setCrawlerDataSourceKey(JoinPoint point) {
		DatabaseContextHolder.clearCustomerType();
		DatabaseContextHolder.setDateSourceType(DateSourceType.CRAWLER);
	}

	@Before("execution(* com.kf.data.service.online.**.*(..))")
	public void setOnlineDataSourceKey(JoinPoint point) {
		DatabaseContextHolder.clearCustomerType();
		DatabaseContextHolder.setDateSourceType(DateSourceType.ONLINE);
	}

}