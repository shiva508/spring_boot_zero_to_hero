package com.pool.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthentication implements AuthenticationProvider{

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName=authentication.getName();
		String passWord=authentication.getCredentials().toString();
		return new UsernamePasswordAuthenticationToken(userName, passWord);
	}

	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
