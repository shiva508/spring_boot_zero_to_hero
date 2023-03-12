package com.pool.rest.controller.image;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pool.rest.form.image.ImagesForm;
import com.pool.rest.service.image.ImageService;

@RestController
@RequestMapping("/image")
public class ImageProcessorController {
	@Autowired
	private ImageService imageService;
	@PostMapping("/save")
	public ResponseEntity<ImagesForm> saveImage(@Valid @RequestBody ImagesForm imagesForm, HttpServletRequest request) {
		ImagesForm imagesFormOP=imageService.saveImage(imagesForm);
		return new ResponseEntity<ImagesForm>(imagesFormOP, HttpStatus.CREATED);
	}
	@GetMapping("/userimages/{userId}")
	public ResponseEntity<List<ImagesForm>> userImages(@PathVariable("userId") Integer userId){
		List<ImagesForm> imagesFormOP=imageService.userImages(userId);
		return new ResponseEntity<List<ImagesForm>>(imagesFormOP,HttpStatus.FOUND);
	}
}
