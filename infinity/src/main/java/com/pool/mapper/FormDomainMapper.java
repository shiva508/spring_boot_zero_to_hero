package com.pool.mapper;

import com.pool.form.AddressForm;
import com.pool.form.FeaturesForm;
import com.pool.form.ProductForm;
import com.pool.form.RankingForm;
import com.pool.form.UserForm;
import com.pool.model.Address;
import com.pool.model.Features;
import com.pool.model.Product;
import com.pool.model.Ranking;
import com.pool.model.Users;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.converter.builtin.DateToStringConverter;

public class FormDomainMapper {
	private MapperFactory formDomainMapperFactory = null;

	public FormDomainMapper(MapperFactory mapperFactory) {
		this.formDomainMapperFactory = mapperFactory;
		ConverterFactory converterFactory = formDomainMapperFactory.getConverterFactory();
		converterFactory.registerConverter(new DateToStringConverter("MM-dd-yyyy HH:mm:ss"));
		/*userFormToUser();
		addressFormToAddress();
		featureFormToFeature();
		rankingFormToRanking();
		productFormToProduct();*/
	}

	/*public void productFormToProduct() {
		formDomainMapperFactory.classMap(ProductForm.class, Product.class)
		.field("productMame", "productMame")
				.fieldBToA("featurs", "featursList")
				.fieldBToA("ranking", "rankingList")
				.field("productId", "productId")
				.byDefault().register();
	}
*/
	/*public void rankingFormToRanking() {
		formDomainMapperFactory.classMap(RankingForm.class, Ranking.class).field("rankingId", "rankingId")
				.field("ranking", "ranking").byDefault().register();
	}*/

	/*public void featureFormToFeature() {
		formDomainMapperFactory.classMap(FeaturesForm.class, Features.class)
		.field("featureId", "featureId")
		.field("feature", "feature").byDefault().register();

	}*/

	/*public void userFormToUser() {
		formDomainMapperFactory.classMap(UserForm.class, Users.class).field("userId", "userId")
				.field("userName", "username").fieldBToA("address", "addressForm").byDefault().register();
	}*/

	/*public void addressFormToAddress() {
		formDomainMapperFactory.classMap(AddressForm.class, Address.class).field("addressId", "addressId")
				.field("villageName", "villageName").field("mandal", "mandal").field("distrct", "distrct").byDefault()
				.register();
	}*/
}
