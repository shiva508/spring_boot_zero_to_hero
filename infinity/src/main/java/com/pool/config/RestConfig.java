package com.pool.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.pool.config.intercepter.InfinityIntercepter;
@Configuration
public class RestConfig extends WebMvcConfigurerAdapter{
	@Autowired
	InfinityIntercepter infinityIntercepter;
	@Bean
	public RestTemplate getestTemplate() {
		return new RestTemplate();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(infinityIntercepter);
	}

}
