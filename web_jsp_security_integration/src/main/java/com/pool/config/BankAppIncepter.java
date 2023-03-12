package com.pool.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.pool.model.User;
import com.pool.service.UserService;

@Component
public class BankAppIncepter extends HandlerInterceptorAdapter {
	@Autowired
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User sessionUser = (User) session.getAttribute("user");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication !=null) {
			String username = authentication.getName();
			if (username != null && username!="" && !username.isEmpty() && sessionUser == null && username.contains("@") && !username.equalsIgnoreCase("anonymousUser") ) {
				System.out.println("User:"+username);
				User user = userService.findUserByUserName(username);
				if(user !=null) {
					session.setAttribute("user", user);	
				}
			}	
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
		User user=(User) request.getSession().getAttribute("user");
		if (modelAndView != null) {
			modelAndView.addObject("user", user);
		}
	}

}
