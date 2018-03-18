package com.train.spring.DAO;

import java.util.List;

import com.train.spring.entity.Product;

public interface ProductDAO {

	public List<Product> getProducts();
	public void addProduct(Product product);
	public Product getProductById(int id);
	public void deleteProduct(int id);
}
