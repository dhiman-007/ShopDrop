package com.DropShop.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DropShop.Exceptions.NotFoundExcepton;
import com.DropShop.Models.Orders;
import com.DropShop.Models.Product;
import com.DropShop.Models.User;
import com.DropShop.utility.GeneralUtility;
import com.DropShop.utility.ProductsUtility;
import com.DropShop.utility.UserUtility;

@Service
public class OrderService {

	@Autowired
	private UserUtility userUtility;

	@Autowired
	private ProductsUtility productsUtility;

	@Autowired
	private GeneralUtility generalUtility;

	public List<User> placingOrder(String mobNo, String Category, String productId) throws NotFoundExcepton {

		HashMap<String, List<Product>> AllProducts = productsUtility.AllProducts;

		try {

			if (!AllProducts.containsKey(Category)) {

				throw new NotFoundExcepton("No Category Of product is Found");
			}

			List<Product> productsInVariety = AllProducts.get(Category);

			List<Product> ProductILookingFor = productsInVariety.stream().map(p -> p)
					.filter(p -> p.getPublicProductId().equals(productId)).collect(Collectors.toList());

			Product product = ProductILookingFor.get(0);

			List<User> users = userUtility.getUsersList();

			List<User> user = users.stream().filter(p -> p.getMobileNumber().equals(mobNo))
					.collect(Collectors.toList());

			List<Orders> orders = user.get(0).getOrders();

			orders.add(new Orders(product.getPublicProductId(), product.getPublicNameOfProduct(),
					product.getPublicProductPrice(), GeneralUtility.getProductRating(), new Date().toString(),
					GeneralUtility.Paidvia()));

			return user;

		} catch (NotFoundExcepton e) {
			System.out.println(e);
		}

		return null;

	}
}
