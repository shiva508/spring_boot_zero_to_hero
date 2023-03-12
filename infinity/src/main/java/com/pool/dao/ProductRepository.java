package com.infinity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infinity.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
