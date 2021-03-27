package com.DropShop.utility;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DropShop.Models.Cart;
import com.DropShop.Models.User;

@Service
public class CartUtiity {

	@Autowired
	private UserUtility userUtility;

	public List<Cart> getCart(String mobNo) {
		List<User> users = userUtility.getUsersList();
		List<User> user = users.stream().filter(p -> p.getMobileNumber().equals(mobNo)).collect(Collectors.toList());

		System.out.println(user);

		if (user.isEmpty()) {
			return null;
		}

		List<Cart> cart = user.get(0).getCart();
		return cart;
	}

	public static String updateCart(List<Cart> cart, String op, String productId) {
		if (cart.size() == 0) {
			return "No, Item in the cart!";
		}
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProductId().equals(productId)) {
				if (op.equalsIgnoreCase("plus")) {
					int quantity = cart.get(i).getQuantity();
					cart.get(i).setQuantity(quantity + 1);
					return "Successful cart operation +";
				} else if (op.equalsIgnoreCase("minus")) {
					int quantity = cart.get(i).getQuantity();
					if (quantity - 1 < 1) {
						cart.remove(i);
						return "Product removed from Your Cart!";
					}
					cart.get(i).setQuantity(quantity - 1);
					return "Successful cart operation -";
				} else {
					cart.remove(i);
					return "Product removed from Your Cart!";
				}
			}
		}
		return "Operation Failed, Try Later";
	}

}
