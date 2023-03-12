/**
 * 
 */
package com.pool.config.orika;
import com.pool.rest.form.DressDetailsForm;
import com.pool.rest.form.DressTypeForm;
import com.pool.rest.form.image.ImagesForm;
import com.pool.rest.model.DressDetailsModel;
import com.pool.rest.model.DressType;
import com.pool.rest.model.images.ImagesModel;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;

/**
 * @author shiva
 *
 */
public class FormDomineMapper {
	private MapperFactory formToDomineMApperFactory = null;

	public FormDomineMapper(MapperFactory mapperFactory) {
		this.formToDomineMApperFactory = mapperFactory;
		ConverterFactory converterFactory = formToDomineMApperFactory.getConverterFactory();
		mapDressDetails();
		mapDressType();
		mapImages();
	}

	public void mapImages() {
		formToDomineMApperFactory.classMap(ImagesModel.class, ImagesForm.class)
		.field("imageId", "imageId")
		.field("imageName", "imageName")
		.field("base64Image", "base64Image")
		.field("imageUploadedDate", "imageUploadedDate")
		.field("userId", "userId");
	}

	public void mapDressDetails() {
		formToDomineMApperFactory.classMap(DressDetailsModel.class, DressDetailsForm.class)
				.field("dressAddressCode", "dressAddressCode")
				.field("dressType", "dressType")
				.field("dressName", "dressName")
				.field("dressPrice", "dressPrice")
				.field("productCreatedOn", "productCreatedOn");
	}

	public void mapDressType() {
				formToDomineMApperFactory.classMap(DressType.class, DressTypeForm.class)
				.field("dressTypeId", "dressTypeId")
				.field("derssTypeName", "derssTypeName");
	}
	
}
