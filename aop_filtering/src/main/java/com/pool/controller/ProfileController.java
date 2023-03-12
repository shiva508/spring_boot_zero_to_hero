package com.pool.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pool.profile.ProfileService;

@RestController
public class ProfileController {

	@Autowired
	@Qualifier("devlProfileService")
	private ProfileService profileService;
	
	@GetMapping("/profileinfo")
	public void profileInfo() {
		profileService.executeTask();
	}
}
