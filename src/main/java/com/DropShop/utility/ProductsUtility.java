package com.DropShop.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DropShop.Models.Product;

@Service
public class ProductsUtility {

	public static HashMap<String, List<Product>> AllProducts = new HashMap<String, List<Product>>();

	static {
		AllProducts.put("Mobiles",
				new ArrayList<Product>(
						Arrays.asList(new Product("ABC123", 12000.0, "MI Note 5 pro", "Overall Best Specs", 5),
								new Product("CAD123", 18000.0, "Poco F1", "Overall Best Specs", 4),
								new Product("AKH123", 15000.0, "Samsung guru 11", "Overall Best Specs", 5)

						)));

		AllProducts.put("Clothes",
				new ArrayList<Product>(
						Arrays.asList(new Product("ABU123", 12000.0, "MI Note 5 pro", "Overall Best Specs", 5),
								new Product("CAD123", 18000.0, "Poco F1", "Overall Best Specs", 4),
								new Product("AKH123", 15000.0, "Samsung guru 11", "Overall Best Specs", 5)

						)));
	}

}
