package com.pool.controller;

import java.net.URI;



import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.pool.conditional.DriverBean;
import com.pool.conditional.UserDAO;
import com.pool.configurationProperties.StudentPoolProperties;
import com.pool.model.User;
import com.pool.service.UserService;
import com.pool.util.model.UserNotFoundException;

@RestController
@RequestMapping(value = "/")
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private DriverBean driverBean;
	@Autowired
	private StudentPoolProperties studentPoolProperties;

	@PostMapping("user")
	public ResponseEntity<Object> saveUser(@RequestBody User user) {

		User savedUser = userService.saveUser(user);
		URI path = ServletUriComponentsBuilder.fromCurrentRequest().path("userId").buildAndExpand(savedUser.getUserId())
				.toUri();
		System.out.println(path.toString());
		ResponseEntity.created(path).build();
		System.out.println(userDAO.getAllUserNames());
		driverBean.driverName();
		System.out.println(studentPoolProperties.toString());

		return new ResponseEntity<Object>(savedUser, HttpStatus.CREATED);
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> users() {
		List<User> users = userService.users();
		return new ResponseEntity<List<User>>(users.stream().filter(this::isUserAdmin).collect(Collectors.toList()).stream().filter(this::isGarentyPereiodExpired).collect(Collectors.toList()),
				HttpStatus.OK);
	}
	public boolean isGarentyPereiodExpired(User user) {
		user.getCreatedDate();
		return true;
	}
	public boolean isUserAdmin(User user) {
		return user.getFirstName().equals("ADMIN");
	}
 
	
	@GetMapping("user/{userId}")
	public User finduser(@PathVariable("userId") Integer userId) {
		return userService.findUser(userId)
				.orElseThrow(() -> new UserNotFoundException("USER NOT FOUND WITH ID:" + userId));
	}

	@PutMapping("user")
	public User updateUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@DeleteMapping("user/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") Integer userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<String>("User is deleted with id+" + userId, HttpStatus.OK);
	}

	@GetMapping("user/props")
	public String getParam() {
		return studentPoolProperties.toString();
	}
}
