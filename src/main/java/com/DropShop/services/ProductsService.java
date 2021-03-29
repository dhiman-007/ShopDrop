package com.DropShop.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.DropShop.Models.Product;
import com.DropShop.utility.ProductsUtility;

@Service
public class ProductsService {

	@Autowired
	private ProductsUtility productsUtility;

	public ResponseEntity<HashMap<String, List<Product>>> getAllProducts() {

		HashMap<String, List<Product>> AllProducts = productsUtility.AllProducts;
		return new ResponseEntity(AllProducts, HttpStatus.OK);

	}

	public ResponseEntity<Product> getSingleProductFromProductId(String Category, String productId) {

		HashMap<String, List<Product>> AllProducts = productsUtility.AllProducts;

		if (AllProducts.containsKey(Category)) {
			List<Product> productsInVariety = AllProducts.get(Category);
			for (Product product : productsInVariety) {
				if (product.getPublicProductId().equals(productId)) {
					return new ResponseEntity<Product>(product, HttpStatus.OK);
				}
			}
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity("Server Error, Try Later!", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<?> getProductsViaCategory(String productCategory) {
		// TODO Auto-generated method stub
		HashMap<String, List<Product>> AllProducts = productsUtility.AllProducts;

		if (!AllProducts.containsKey(productCategory)) {

			String ResponseBody = "No Prouct found with the Given Category!";
			return new ResponseEntity<String>(ResponseBody, HttpStatus.NO_CONTENT);

		}

		List<Product> products = AllProducts.get(productCategory);

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

}
