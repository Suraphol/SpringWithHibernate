package com.train.spring.service;

import java.util.List;

import com.train.spring.entity.Product;

public interface AppService {

	public List<Product> getProducts();
	public void addProduct(Product product);
	public Product getProductsById(int id);
	public void deleteProductById(int id);
}
