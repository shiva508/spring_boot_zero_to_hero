package com.pool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pool.model.Product;
import com.pool.repository.ProductRepository;

@Service
@Transactional
public class ProductServiveImpl implements ProductServive {
	
	@Autowired
	private ProductRepository productRepository;

	@Override

	public void addProduct() {
	System.out.println("PRODUCT ADDED:NO ORG");
		
	}

	@Override

	public void addOrganization() {
	System.out.println("ORGANIZATION ADDED:NO ORG");
		
	}

	@Override

	public void addProduct(Product product) {
		System.out.println("PRODUCT ADDED PARAMETER:OBJ ORG");
	}

	@Override

	public void getProduct(String productName, Integer orgId) {
		System.out.println("SEARCH PRODUCT:STRING,INTEGER ORG");
		
	}

	@Override

	public void addProduct(String name, Integer id) {
	System.out.println("ADD WITH TWO OR MORE PARAM:STRING,INTEGER ORG");
		
	}

	@Override

	public void addProduct(String name) {
		
		System.out.println("ADD WITH ONE PARAM:ONG ORG");	
	}

	@Override
	public void setProduct(String productName, Integer orgId) {
		System.out.println("UPADTING ");
		
	}

	@Override
	public List<Product> productList(){
		return productRepository.findAll();
	}

}
