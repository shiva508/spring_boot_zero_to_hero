package com.pool.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
public class Organization implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer organizationId;
	@NotBlank
	@NotEmpty
	private String organixzationName;

	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "organization")
	private Set<Product> products = new HashSet<>();

	public Organization() {
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganixzationName() {
		return organixzationName;
	}

	public void setOrganixzationName(String organixzationName) {
		this.organixzationName = organixzationName;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void addChildEntity(Product product) {
		product.setOrganization(this);
		products.add(product);
	}
	
	@Override
	public String toString() {
		return "Organization [organizationId=" + organizationId + ", organixzationName=" + organixzationName + "]";
	}
}
