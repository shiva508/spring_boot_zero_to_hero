package com.pool.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	@GetMapping("/welcome")
	public String welcomePage( Model model) {
		model.addAttribute("date", new Date());
		return "welcome";
	}
}
