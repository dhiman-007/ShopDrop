package com.DropShop.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.DropShop.Models.Product;

@Service
public class ProductsUtility {

	public static HashMap<String, List<Product>> AllProducts = new HashMap<String, List<Product>>();

	static {
		AllProducts.put("Mobiles",
				new ArrayList<Product>(Arrays.asList(
						new Product(GeneralUtility.getRandomID(), 12000.0, "MI Note 5 pro", "Overall Best Specs",
								GeneralUtility.getProductRating()),
						new Product(GeneralUtility.getRandomID(), 18000.0, "Poco F1", "Overall Best Specs",
								GeneralUtility.getProductRating()),
						new Product(GeneralUtility.getRandomID(), 15000.0, "Samsung guru 11", "Overall Best Specs",
								GeneralUtility.getProductRating())

				)));

		AllProducts.put("Clothes",
				new ArrayList<Product>(Arrays.asList(
						new Product(GeneralUtility.getRandomID(), 1200.0, "POLO", "Best in Summer",
								GeneralUtility.getProductRating()),
						new Product(GeneralUtility.getRandomID(), 1800.0, "Calvin Klein", "Smooth!",
								GeneralUtility.getProductRating()),
						new Product(GeneralUtility.getRandomID(), 1500.0, "Adidas", "Pure Cotton",
								GeneralUtility.getProductRating())

				)));
	}

}
