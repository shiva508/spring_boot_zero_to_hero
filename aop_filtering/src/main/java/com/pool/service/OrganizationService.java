package com.pool.service;

import java.util.List;

import com.pool.model.Organization;
import com.pool.repository.OrganizationRepository.OrganizationProjection;

public interface OrganizationService {
	public List<Organization> getAllOrganizations();

	public Organization saveOrganization(Organization organization);

	List<OrganizationProjection> findByOrganixzationName(String organixzationName);
	<T> List<T> findByOrganixzationName(String organixzationName,Class<T>clazz);
}
