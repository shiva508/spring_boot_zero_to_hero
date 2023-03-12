package com.pool.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import com.pool.form.ValidationResponse;
import com.pool.model.Organization;

@Service
public class StuddentPoolUtill {

	public ResponseEntity<?> validationResponseExtractorResult(BindingResult result) {
		if (result.hasErrors()) {
			List<FieldError> errorList = result.getFieldErrors();
			List<ValidationResponse> validationResponse = new ArrayList<>();
			validationResponse = errorList.stream()
					.map(error -> new ValidationResponse(error.getField(), error.getDefaultMessage()))
					.collect(Collectors.toList());
			return new ResponseEntity<List<ValidationResponse>>(validationResponse, HttpStatus.BAD_REQUEST);
		}
		return null;
	}

	public void processChildEntity(Organization organization) {
		if (null != organization.getProducts() && organization.getProducts().size() > 0) {
			organization.getProducts().stream().forEach(product->organization.addChildEntity(product));
		}
	}

}
