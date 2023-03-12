package com.pool.rest.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.pool.rest.form.image.ImagesForm;
import com.pool.rest.model.images.ImagesModel;

import ma.glasnost.orika.MapperFacade;

@Component
public class ImageUtils {

	public ImagesModel processImageFormToModel(ImagesForm imagesFormIP, MapperFacade formDomineMapperfaced) {
		return formDomineMapperfaced.map(imagesFormIP, ImagesModel.class);
	}

	public ImagesForm processImageModelToForm(ImagesModel imagesModelOP, MapperFacade formDomineMapperfaced) {
		return formDomineMapperfaced.map(imagesModelOP, ImagesForm.class);
	}

	public void processImageModelToImageFormList(List<ImagesModel> imagesModelOP, List<ImagesForm> imagesFormOP,
			MapperFacade formDomineMapperfaced) {
		imagesFormOP.addAll(imagesModelOP
				.stream()
				.map(imageModel->formDomineMapperfaced
				.map(imageModel, ImagesForm.class))
				.collect(Collectors.toList()));
		
	}

}
