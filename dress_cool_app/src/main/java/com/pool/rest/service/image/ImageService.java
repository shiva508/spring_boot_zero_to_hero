package com.pool.rest.service.image;

import java.util.List;

import com.pool.rest.form.image.ImagesForm;


public interface ImageService {
	public ImagesForm saveImage(ImagesForm imagesFormIP);
	public List<ImagesForm> userImages(Integer userId);
	public void deleteUserImages(Integer imageId);
}
