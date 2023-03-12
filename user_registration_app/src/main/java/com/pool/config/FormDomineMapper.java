package com.pool.config;


import com.pool.formmodel.RegistrationForm;
import com.pool.formmodel.RoleForm;
import com.pool.model.Registration;
import com.pool.model.Role;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;

public class FormDomineMapper {
	private MapperFactory formToDomineMApperFactory = null;

	public FormDomineMapper(MapperFactory mapperFactory) {
		this.formToDomineMApperFactory = mapperFactory;
		ConverterFactory converterFactory = formToDomineMApperFactory.getConverterFactory();
		mapRegistration();
		mapRole();
	}

	public void mapRole() {
		formToDomineMApperFactory.classMap(Role.class, RoleForm.class)
				.field("authoriteId", "authoriteId")
				.field("authority", "authority")
				.field("userName", "userName");	
	}

	public void mapRegistration() {
		formToDomineMApperFactory.classMap(Registration.class, RegistrationForm.class)
				.field("userId", "userId")
				.field("firstName", "firstName")
				.field("lastName", "lastName")
				.field("fatherName", "fatherName")
				.field("motherName", "motherName")
				.field("adharNumber", "adharNumber")
				.field("phoneNumber", "phoneNumber")
				.field("email", "email")
				.field("password", "password")
				.field("gender", "gender")
				.fieldBToA("roles", "roles");
	}
}
