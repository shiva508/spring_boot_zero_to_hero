package com.infinity.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.infinity.form.UserForm;
import com.infinity.model.UserRegistration;
import com.infinity.service.UserRegistrationService;
import com.infinity.service.UserService;

@Controller
public class UserRegistrationController {
	@Autowired
	UserRegistrationService userRegistrationService;
	@Autowired
	UserService userService;

	@GetMapping("/signin")
	public String registration(Model model) {
		UserRegistration userRegistration = new UserRegistration();
		model.addAttribute("userRegistration", userRegistration);
		return "UserRegistration";
	}

	@PostMapping("/register")
	public String userRegistration(@ModelAttribute("userRegistration") UserRegistration userRegistration, Model model,
			HttpServletRequest request) {
		UserRegistration registration = userRegistrationService.saveUserRegistration(userRegistration);
		UserForm userFormsaved = RegistrationToModel(registration);
		UserForm userForm = userService.saveUser(userFormsaved);
		request.setAttribute("user", userForm);
		model.addAttribute("userForm", userForm);
		return "Editform";
	}

	public UserForm RegistrationToModel(UserRegistration registration) {
		UserForm user = new UserForm();
		user.setUserName(registration.getFirstName() + " " + registration.getLastName());
		user.setUserRegistrationId(registration.getUserRegistrationId());
		return user;
	}
}
