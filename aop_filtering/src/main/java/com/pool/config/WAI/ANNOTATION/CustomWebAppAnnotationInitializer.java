package com.pool.config.WAI.ANNOTATION;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.DispatcherServlet;

public class CustomWebAppAnnotationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigServletWebApplicationContext applicationContext = new AnnotationConfigServletWebApplicationContext();
		//applicationContext.register(CustomWebAppAnnotationInitializer.class);
		applicationContext.setConfigLocation("com.pool.config");
		servletContext.addListener(new ContextLoaderListener(applicationContext));
		ServletRegistration.Dynamic dispatcher=servletContext.addServlet("dispatcher", new DispatcherServlet(applicationContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
	}

}
