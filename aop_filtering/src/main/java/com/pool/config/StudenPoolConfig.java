package com.pool.config;

import java.util.List;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.pool.servlet.GoodBye;
import com.pool.servlet.Welcome;

@Configuration
public class StudenPoolConfig {
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(10485760); // 10MB
		multipartResolver.setMaxUploadSizePerFile(1048576); // 1MB
		return multipartResolver;
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean<>();
		servletRegistrationBean.setServlet(new Welcome());
		servletRegistrationBean.setName("welcome");
		servletRegistrationBean.addUrlMappings("/welcome");
		servletRegistrationBean.setServlet(new GoodBye());
		servletRegistrationBean.setName("goodBye");
		servletRegistrationBean.addUrlMappings("/goodBye");
		return servletRegistrationBean;
	}
}
