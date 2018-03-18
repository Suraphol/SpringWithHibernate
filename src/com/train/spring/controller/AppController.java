package com.train.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.train.spring.DAO.ProductDAO;
import com.train.spring.entity.Product;
import com.train.spring.service.AppService;

@Controller("appController")
public class AppController {
/*	@Autowired
	private ProductDAO product;*/
	@Autowired
	private AppService appService;
	
	@RequestMapping("/")
	public ModelAndView homepage() {
		ModelAndView model = new ModelAndView("index");
		return model;
	}
	
	@RequestMapping("/contact")
	public ModelAndView admin() {
		ModelAndView model = new ModelAndView("contact");
		return model;
	}
	
	@RequestMapping("/products")
	public ModelAndView products() {
		ModelAndView model = new ModelAndView("products");
		//List<Product> productList = product.getProducts();
		List<Product> productList = appService.getProducts();
		model.addObject("products", productList);
		return model;
	}
	
	@RequestMapping("/addProductForm")
	public ModelAndView addProductForm() {
		ModelAndView model = new ModelAndView("addProductForm");
		model.addObject("product", new Product());
		return model;
	}
	
	@RequestMapping("/addProduct")
	public ModelAndView addProduct(@ModelAttribute("product")Product product) {
		ModelAndView model = new ModelAndView("redirect:/products");
		appService.addProduct(product);
		System.out.println(product);
		return model;
	}
	
	@RequestMapping("/updateProductForm")
	public ModelAndView updateProductForm(@RequestParam("id")int id) {
		ModelAndView model = new ModelAndView("addProductForm");
		Product product = appService.getProductsById(id);
		model.addObject("product", product);		
		return model;
	}
	
	@RequestMapping("/deleteProduct")
	public ModelAndView deleteProduct(@RequestParam("id")int id) {
		ModelAndView model = new ModelAndView("redirect:/products");
		appService.deleteProductById(id);
		return model;
	}
}
