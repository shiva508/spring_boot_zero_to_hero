package com.pool.controller.user;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pool.entity.UserEntity;
import com.pool.model.CommonResponseModel;
import com.pool.model.exception.ValidationResponse;
import com.pool.service.user.UserService;
import com.pool.util.EpoolUtils;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	private UserService userService;
	private EpoolUtils epoolUtils;

	@Autowired
	public UserController(UserService userService, EpoolUtils epoolUtils) {
		this.userService = userService;
		this.epoolUtils = epoolUtils;
	}

	@PostMapping("/create")
	public ResponseEntity<?> saveUser(@Valid UserEntity userEntity, BindingResult result) {
		Optional<List<ValidationResponse>> optional = epoolUtils.validationResponseExtractor(result);
		if (optional.isPresent()) {
			return new ResponseEntity<>(optional.get(), HttpStatus.BAD_REQUEST);
		}
		UserEntity savedUserEntity = userService.saveUser(userEntity);

		return new ResponseEntity<>(savedUserEntity, HttpStatus.CREATED);
	}

	@GetMapping("findbyuserid/{userId}")
	public ResponseEntity<?> userByUserEntityId(@PathVariable("userId") Long userId) {
		UserEntity userEntity = userService.userByUserEntityId(userId);
		return new ResponseEntity<>(userEntity, HttpStatus.FOUND);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@Valid UserEntity userEntity, BindingResult result) {
		Optional<List<ValidationResponse>> optional = epoolUtils.validationResponseExtractor(result);
		if (optional.isPresent()) {
			return new ResponseEntity<>(optional.get(), HttpStatus.BAD_REQUEST);
		}
		UserEntity updatedUserEntity = userService.updateUser(userEntity);

		return new ResponseEntity<>(updatedUserEntity, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") Long userId) {
		CommonResponseModel commonResponseModel = userService.deleteUser(userId);
		return new ResponseEntity<>(commonResponseModel, HttpStatus.OK);

	}

}
