package com.pool.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserWebController {
	@GetMapping("/")
	public String Login(HttpServletRequest request) {
	Object principal=	SecurityContextHolder.getContext().getAuthentication().getAuthorities();
	if (principal instanceof UserDetails) {
		  String username = ((UserDetails)principal).getUsername();
		  System.out.println(principal);
		} else {
		  String username = principal.toString();
		  System.out.println(username);
		}
		request.setAttribute("userid", "user");
	return "Welcome";	
	}
	
}
