package com.pool.rest.form.image;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ImagesForm {
	private Integer imageId;
	@NotNull
	private String imageName;
	@NotNull
	@NotEmpty
	private String base64Image;
	private Date imageUploadedDate;
	private Integer userId;
	
	public ImagesForm() {
		
	}

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	public Date getImageUploadedDate() {
		return imageUploadedDate;
	}

	public void setImageUploadedDate(Date imageUploadedDate) {
		this.imageUploadedDate = imageUploadedDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ImagesForm [imageId=" + imageId + ", imageName=" + imageName + ", base64Image=" + base64Image
				+ ", imageUploadedDate=" + imageUploadedDate + ", userId=" + userId + "]";
	}
	
}
