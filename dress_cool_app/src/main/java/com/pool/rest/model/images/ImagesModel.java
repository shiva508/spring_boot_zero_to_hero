package com.pool.rest.model.images;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "USER_PROFILE_PICTURES")
public class ImagesModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IMAGE_ID")
	private Integer imageId;
	@Column(name = "IMAGE_NAME")
	private String imageName;
	@Lob
	@Column(name = "BASE_64_IMAGE")
	private String base64Image;
	@Column(name = "IMAGE_UPLOADED_DATE")
	private Date imageUploadedDate;
	@Column(name = "USER_ID")
	private Integer userId;

	public ImagesModel() {

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
		return "ImagesModel [imageId=" + imageId + ", imageName=" + imageName + ", base64Image=" + base64Image
				+ ", imageUploadedDate=" + imageUploadedDate + "]";
	}

}
