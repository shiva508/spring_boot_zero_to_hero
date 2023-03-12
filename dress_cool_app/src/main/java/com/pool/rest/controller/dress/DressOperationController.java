package com.pool.rest.controller.dress;

import java.net.URI;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pool.exception.model.DressNotFoundException;
import com.pool.rest.form.DressDetailsForm;
import com.pool.rest.service.dressaddress.DressAddressService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/dress")
public class DressOperationController {
	@Autowired
	private DressAddressService dressAddressService;

	@PostMapping("/createnewdress")
	public ResponseEntity<DressDetailsForm> saveDressDetails(@Validated @RequestBody DressDetailsForm dressDetailsFormIP,
			HttpServletRequest request) {
		DressDetailsForm dressDetailsFormOP = dressAddressService.saveDressDetails(dressDetailsFormIP);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("dress/{dressAddressCode}")
				.buildAndExpand(dressDetailsFormOP.getDressAddressCode()).toUri();
		return ResponseEntity.created(location).body(dressDetailsFormOP);
	}

	@GetMapping("/allDresses")
	public ResponseEntity<List<DressDetailsForm>> getDressDetailsList(HttpServletRequest request) {
		return new ResponseEntity<List<DressDetailsForm>>(dressAddressService.getDressDetailsList(), HttpStatus.OK);
	}

	@PutMapping("/updateDressDetails")
	public ResponseEntity<DressDetailsForm> updateDressDetails(
			@Validated @RequestBody DressDetailsForm dressDetailsFormIP) {
		DressDetailsForm dressDetailsFormOP = dressAddressService.updateDressDetails(dressDetailsFormIP);
		return new ResponseEntity<DressDetailsForm>(dressDetailsFormOP, HttpStatus.OK);
	}

	@GetMapping("getDressDetailsById/{dressAddressCode}")
	public ResponseEntity<DressDetailsForm> getDressDetailsFormByDressAddressCode(
			@PathVariable("dressAddressCode") String dressAddressCode, HttpServletRequest request) {
		DressDetailsForm dressDetailsFormOP = dressAddressService
				.getDressDetailsFormByDressAddressCode(dressAddressCode);
		if(dressDetailsFormOP==null) {
			throw new DressNotFoundException("Dress is Not Found With Dress ID:"+dressAddressCode);
		}
		return new ResponseEntity<DressDetailsForm>(dressDetailsFormOP, HttpStatus.OK);
	}
}
