package com.pool.rest.controller.welcome;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	@GetMapping("/welcomeMessage")
	public String welcomeMessage() {
		return "We welcome you to shop with US";
	}
}
