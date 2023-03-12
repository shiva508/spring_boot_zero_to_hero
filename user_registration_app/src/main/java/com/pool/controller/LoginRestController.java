package com.pool.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController {
	@Autowired
	private ResourceBundleMessageSource messageSource;
	@GetMapping("/i18")
	public String one(@RequestHeader("Accept-Language")String locale) {
		return messageSource.getMessage("hello.txt", null, new Locale(locale));
	}
}
