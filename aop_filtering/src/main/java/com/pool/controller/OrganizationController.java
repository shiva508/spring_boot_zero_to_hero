package com.pool.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pool.model.Organization;
import com.pool.repository.OrganizationRepository.OrganizationProjection;
import com.pool.service.OrganizationService;
import com.pool.util.StuddentPoolUtill;

@RestController
public class OrganizationController {
	
	private static Logger log = LoggerFactory.getLogger(OrganizationController.class);
	
	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private StuddentPoolUtill studdentPoolUtill;

	@GetMapping("/organizations")
	public List<Organization> getAllOraganizations() {
		List<Organization> restlt = null;
			restlt = organizationService.getAllOrganizations();
		return restlt;
	}
	
	@GetMapping("/sun/{var}")
	List<OrganizationProjection> getet(@PathVariable("var") String var){
		return organizationService.findByOrganixzationName(var);
	}
	
	
	@GetMapping("/sundiff/{var}")
	public List<OrganizationProjection> findByOrganixzationName(String organixzationName) {
		return organizationService.findByOrganixzationName(organixzationName, OrganizationProjection.class);
	}
	
	@PostMapping("/saveorganization")
	public ResponseEntity<?> saveOrganization(@Valid @RequestBody Organization organization,BindingResult result){
		ResponseEntity<?> errorResponse=studdentPoolUtill.validationResponseExtractorResult(result);
		if(errorResponse !=null) return  errorResponse;
		Organization savedOrganization=organizationService.saveOrganization(organization);
		log.debug("aajsjsjakj");
		if(savedOrganization==null) {
			return new ResponseEntity<>("No Data Found", HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>(savedOrganization, HttpStatus.FOUND);
		}
	}
	
}
