package com.pool.controller.aop;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pool.model.aop.AopUser;
import com.pool.service.aop.AopUserService;

@RestController
@RequestMapping("/aopapi")
public class AopUserController {
	
	private Logger logger = LoggerFactory.getLogger(AopUserController.class);

	@Autowired
	private AopUserService aopUserService;

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody AopUser aopUser) {
		logger.info("input {}", aopUser);
		AopUser aopUserSavedObj = aopUserService.save(aopUser);
		return new ResponseEntity<>(aopUserSavedObj, HttpStatus.CREATED);
	}

	@GetMapping("/getbyuserid/{userId}")
	public ResponseEntity<?> getAopUserByUserId(@PathVariable("userId") Integer userId) {
		AopUser aopUser = aopUserService.getAopUserByUserId(userId);
		return new ResponseEntity<>(aopUser, HttpStatus.OK);
	}

	@GetMapping("/allaopdata")
	public ResponseEntity<?> getAllAopUsers() {
		aopUserService.called();
		List<AopUser> aopUsers = aopUserService.getAllAopUsers();
		return new ResponseEntity<>(aopUsers, HttpStatus.OK);
	}

	@PostMapping("/setusername")
	public void setUserName(@RequestParam("userName") String userName) {
		aopUserService.setUserName(userName);
	}

	@GetMapping("/getusername")
	public String getUserName() {
		return aopUserService.getUserName();
	}

	@PostMapping("/setpassword")
	public void setPassword(@RequestParam("password") String password) {
		aopUserService.setPassword(password);
	}

	@GetMapping("/getpassword")
	public String getPassword() {
		return aopUserService.getPassword();
	}
}
