package com.infinity.service;

import java.util.List;

import com.infinity.form.ProductForm;
import com.infinity.model.Product;

public interface ProductService {
public ProductForm saveProduct(ProductForm productForm);
public List<Product> products();
public ProductForm product(Integer productId);

}
