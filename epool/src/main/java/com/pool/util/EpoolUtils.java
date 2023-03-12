package com.pool.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.pool.model.exception.ValidationResponse;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EpoolUtils {

	public Optional<List<ValidationResponse>>  validationResponseExtractor(BindingResult result) {
		Optional<List<ValidationResponse>> optionalData=Optional.empty();
		List<ValidationResponse> validationResponse = new ArrayList<>();
		if(result.hasErrors()) {
			List<FieldError> errorList = result.getFieldErrors();
			validationResponse=errorList.stream().map(error->new ValidationResponse(error.getField(), error.getDefaultMessage())).collect(Collectors.toList());
		}
		
		return optionalData.ofNullable(validationResponse);
	}
	
}
