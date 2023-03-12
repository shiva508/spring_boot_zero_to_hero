package com.pool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pool.model.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

	//@Query("select O from Organization O where O.organixzationName=:organixzationName")
	//List<Organization> findByOrganixzationName(String organixzationName);

	public interface OrganizationProjection {
		public String getOrganixzationName();
	}
	
	public interface OrganizationIdProjection {
		public Integer getOrganizationId();
	}
	List<OrganizationProjection> findByOrganixzationName(String organixzationName);
	<T> List<T> findByOrganixzationName(String organixzationName,Class<T>clazz);
}
