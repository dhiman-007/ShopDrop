package com.DropShop.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DropShop.Models.Product;
import com.DropShop.utility.ProductsUtility;

@Service
public class ProductsService {

	@Autowired
	private ProductsUtility productsUtility;

	public HashMap<String, List<Product>> getAllProducts() {
		return productsUtility.AllProducts;
	}

}
