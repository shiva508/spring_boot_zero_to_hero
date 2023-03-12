package com.pool.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(servletNames = {"welcome","goodBye"})
public class WelcomeFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 
	    System.out.println("MyFilter doFilter() is invoked.");
	    Enumeration<String> params = request.getParameterNames();
	    while (params.hasMoreElements()) {
	      String param=params.nextElement();
	      System.out.println("Parameter:"+param+"\tValue:"+request.getParameter(param));
	    }

	}

}
