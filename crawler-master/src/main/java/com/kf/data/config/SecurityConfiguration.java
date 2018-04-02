package com.kf.data.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**  
 * @Title:  SecurityConfiguration.java   
 * @Package com.kf.data.config   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: liangyt    
 * @date:   2018年4月2日 下午5:38:48   
 * @version V1.0 
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("root123").roles("USER");
//		auth.inMemoryAuthentication().withUser("dba").password("root123").roles("USER","DBA");
//		  auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  
	  http.authorizeRequests()
	  	.antMatchers("/", "/index").permitAll()
	  	.antMatchers("/admin/**").access("hasRole('ADMIN')")
//	  	.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
		.antMatchers("/chat/**").access("hasRole('USER') or hasRole('ADMIN')")
	  	.and().formLogin().loginPage("/login")
	  	.usernameParameter("ssoId").passwordParameter("password")
	  	.and().csrf()
	  	.and().exceptionHandling().accessDeniedPage("/Access_Denied");
	}
}