package com.pool.util.jwt.filter;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pool.constant.InfinityFutureSecurityConstant;
import com.pool.model.HttpResponse;

@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		HttpResponse httpResponse = new HttpResponse().setHttpStatusCode(HttpStatus.UNAUTHORIZED.value())
				.setHttpStatus(HttpStatus.UNAUTHORIZED).setMessage(InfinityFutureSecurityConstant.FORBIDDEN_MESSAGE)
				.setReason(HttpStatus.UNAUTHORIZED.getReasonPhrase()).setTimeStamp(new Date());
		
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		OutputStream outputStream=response.getOutputStream();
		ObjectMapper objectMapper=new ObjectMapper();
		objectMapper.writeValue(outputStream, httpResponse);
		outputStream.flush();
	}

}
