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

	public Product getSingleProductFromProductId(String Category, String productId) {

		HashMap<String, List<Product>> AllProducts = productsUtility.AllProducts;
		if (AllProducts.containsKey(Category)) {
			List<Product> productsInVariety = AllProducts.get(Category);
			for (Product product : productsInVariety) {
				if (product.getPublicProductId().equals(productId)) {
					return product;
				}
			}
		} else {
			throw new Error("No product Found");
		}
		return null;
	}

}
