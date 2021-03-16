package com.DropShop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DropShop.Models.Cart;
import com.DropShop.utility.ShopDropUtility;

@Service
public class CartService {

	@Autowired
	private static UserService userService;

	@Autowired
	private static ShopDropUtility shopDropUtility;

	public String addToCart(Cart cart, String mobNo) {
		List<Cart> cartToAdd = shopDropUtility.getCart(mobNo);
		cartToAdd.add(cart);
		return "Product is Successfully Added to your Cart";

	}

	public List<Cart> getCart(String mobNo) {
		List<Cart> cart = shopDropUtility.getCart(mobNo);
		return cart;

	}

	public String performOnCart(String mobNo, String op, String productId) {
		List<Cart> cart = shopDropUtility.getCart(mobNo);
		String result = shopDropUtility.updateCart(cart, op, productId);
		return result;
	}

	public String getCartPrice(String mobNo) {
		List<Cart> cart = shopDropUtility.getCart(mobNo);
		double totalCartPrice = 0;
		for (int i = 0; i < cart.size(); i++) {
			totalCartPrice = cart.get(i).getProductPrice() * cart.get(i).getQuantity();
		}
		return "Your total cart price is Rs: " + totalCartPrice + "/-";
	}

}
