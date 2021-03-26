package com.DropShop.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.DropShop.Models.Product;
import com.DropShop.services.ProductsService;

@RestController
public class ProductController {

	@Autowired
	private ProductsService ProductsService;

	@GetMapping("/products")
	public HashMap<String, List<Product>> getAllProducts() {
		return ProductsService.getAllProducts();
	}

	@GetMapping("/products/{Category}/{productId}")
	public Product getSingleProductFromProductId(@PathVariable String Category, @PathVariable String productId) {
		return ProductsService.getSingleProductFromProductId(Category, productId);
	}
}
