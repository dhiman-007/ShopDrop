package com.DropShop.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DropShop.Models.Product;
import com.DropShop.services.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductsService ProductsService;

	@GetMapping
	public ResponseEntity<HashMap<String, List<Product>>> getAllProducts() {
		return ProductsService.getAllProducts();
	}

	@GetMapping("/filter")
	public ResponseEntity<?> getProductsViaCategory(@RequestParam(value = "category") String Category) {
		String ProductCategory = Category;
		return ProductsService.getProductsViaCategory(ProductCategory);
	}

	@GetMapping("{Category}/{productId}")
	public ResponseEntity<Product> getSingleProductFromProductId(@PathVariable String Category,
			@PathVariable String productId) {
		return ProductsService.getSingleProductFromProductId(Category, productId);
	}
}
