package com.pool.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pool.domine.User;
import com.pool.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/createuser")
	public String createUserPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "createuser";
	}

	@PostMapping("/saveuser")
	public String saveUser(@ModelAttribute User user, Model model) {
		user.setUserId(new Random().nextInt(5000));
		user.setCreatedDate(new Date());
		//combineFNLN(user);
		userService.saveUser(user);
		return "redirect:/users";
	}

	@GetMapping("/users")
	public String getAllUsers(Model model) {
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		return "users";
	}

	@GetMapping("getstudentbyemail")
	public String getUserByEmailUsingRequestParam(@RequestParam("email")String email,Model model){
		User user=userService.getUserByEmail(email);
		model.addAttribute("user", user);
		return "userbyemail";
	}
	
	@GetMapping("/deleteuser/{userId}")
	public String getUserByUserIdUsingPathVariable(@PathVariable("userId") Integer userId,Model model) {
		List<User> users = userService.getUserByUserId(userId);
		model.addAttribute("users", users);
		return "redirect:/users";
	}
	
	
	public void combineFNLN(User user) {
		String fulname = user.getFirstName() + " " + user.getLastName();
		user.setFirstName(fulname);
	}
}
