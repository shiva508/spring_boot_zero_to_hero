package com.pool.controller.task;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pool.entity.TaskEntity;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

	@PostMapping("/create")
	public void createTask(@Valid @RequestBody TaskEntity taskEntity,BindingResult result) {
		
	}
	
	@GetMapping("/getbytaskid/{taskId}")
	public void getTaskByTaskId(@PathVariable("taskId") Long taskId) {
		
	}
	
	@GetMapping("/getbyuserid/{taskId}")
	public void getTaskByUSerId(@PathVariable("userId")Long userId) {
		
	}
	
	@DeleteMapping("/delete/{taskId}")
	public void deleteTaskById(@PathVariable("taskId") Long taskId) {
		
	}
	
	@PutMapping("/update")
	public void updateTask(@Valid @RequestBody TaskEntity taskEntity,BindingResult result) {
		
	}
}
