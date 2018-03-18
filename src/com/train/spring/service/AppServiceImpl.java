package com.train.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.spring.DAO.ProductDAO;
import com.train.spring.entity.Product;
@Service
public class AppServiceImpl implements AppService {
	@Autowired
	private ProductDAO productDAO;

	@Transactional
	@Override
	public List<Product> getProducts() {		
		return productDAO.getProducts();
	}

	@Transactional
	@Override
	public void addProduct(Product product) {
		productDAO.addProduct(product);
		
	}
	@Transactional
	@Override
	public Product getProductsById(int id) {
		return productDAO.getProductById(id);
	}

	@Transactional
	@Override
	public void deleteProductById(int id) {
		productDAO.deleteProduct(id);
		
	}
}
