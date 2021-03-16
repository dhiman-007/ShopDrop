package com.DropShop.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DropShop.Models.Cart;
import com.DropShop.Models.User;

@Service
public class CartService {

	@Autowired
	private UserService userService;

	// Utility Method to Update Cart on the Basis Of Operation
	public static String updateCart(List<Cart> cart, String op, String productId) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProductId().equals(productId)) {

				if (op.equalsIgnoreCase("plus")) {
					int quantity = cart.get(i).getQuantity();
					cart.get(i).setQuantity(quantity + 1);
					double productPrice = cart.get(i).getProductPrice();
					cart.get(i).setProductPrice(productPrice * (quantity + 1));
					return "Successful cart operation +";
				} else if (op.equalsIgnoreCase("minus")) {
					int quantity = cart.get(i).getQuantity();
					if (quantity - 1 < 1) {
						cart.remove(i);
						return "Product removed from Your Cart!";
					}
					double productPrice = cart.get(i).getProductPrice();
					cart.get(i).setProductPrice(productPrice - (productPrice / quantity));
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

	public String addToCart(Cart cart, String mobNo) {
		List<User> users = userService.usersList;
		List<User> user = users.stream().filter(p -> p.getMobileNumber().equals(mobNo)).collect(Collectors.toList());
		if (user == null) {
			return "Unable to Load User, Check After Some time/";
		}
		user.get(0).getCart().add(cart);
		return "Product is Successfully Added to your Cart";

	}

	public List<Cart> getCart(String mobNo) {
		List<User> users = userService.usersList;
		List<User> user = users.stream().filter(p -> p.getMobileNumber().equals(mobNo)).collect(Collectors.toList());
		return user.get(0).getCart();

	}

	public String performOnCart(String mobNo, String op, String productId) {
		List<User> users = userService.usersList;
		List<User> user = users.stream().filter(p -> p.getMobileNumber().equals(mobNo)).collect(Collectors.toList());
		List<Cart> cart = user.get(0).getCart();
		String result = CartService.updateCart(cart, op, productId);
		return result;

	}

}
