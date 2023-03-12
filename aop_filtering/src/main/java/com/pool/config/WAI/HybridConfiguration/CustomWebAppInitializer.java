package com.pool.config.WAI.HybridConfiguration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class CustomWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		XmlWebApplicationContext applicationContext = new XmlWebApplicationContext();
		applicationContext.setConfigLocation("config.xml");
		ServletRegistration.Dynamic  dispatcher= servletContext.addServlet("dispatcher",new DispatcherServlet(applicationContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

}
