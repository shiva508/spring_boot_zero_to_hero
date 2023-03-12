package com.pool.rest.service.image;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.pool.rest.form.image.ImagesForm;
import com.pool.rest.model.images.ImagesModel;
import com.pool.rest.repository.image.ImageRepository;
import com.pool.rest.util.ImageUtils;

import ma.glasnost.orika.MapperFacade;

@Service
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	@Qualifier("formDomineMapperfaced")
	private MapperFacade formDomineMapperfaced;
	
	@Autowired
	private ImageUtils imageUtils;

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public ImagesForm saveImage(ImagesForm imagesFormIP) {
		ImagesModel imagesModelIP= imageUtils.processImageFormToModel(imagesFormIP,formDomineMapperfaced);
		ImagesModel imagesModelOP= imageRepository.save(imagesModelIP);
		ImagesForm imagesFormOP=imageUtils.processImageModelToForm(imagesModelOP,formDomineMapperfaced);
		return imagesFormOP;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
	public List<ImagesForm> userImages(Integer userId) {
		List<ImagesForm> imagesFormOP=new ArrayList<>();
		List<ImagesModel> imagesModelOP= imageRepository.findByUserId(userId);
		imageUtils.processImageModelToImageFormList(imagesModelOP,imagesFormOP,formDomineMapperfaced);
		return imagesFormOP;
	}

	@Override
	@Transactional
	public void deleteUserImages(Integer imageId) {
		imageRepository.deleteById(imageId);
	}

}
