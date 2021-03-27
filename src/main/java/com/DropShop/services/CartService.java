package com.DropShop.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.DropShop.Models.Cart;
import com.DropShop.Models.Orders;
import com.DropShop.utility.CartUtiity;
import com.DropShop.utility.GeneralUtility;
import com.DropShop.utility.OrderUtility;

@Service
public class CartService {

	@Autowired
	private UserService userService;

	@Autowired
	private CartUtiity cartUtiity;

	@Autowired
	private OrderUtility orderUtility;

	public ResponseEntity<String> addToCart(Cart cart, String mobNo) {
		List<Cart> cartToAdd = cartUtiity.getCart(mobNo);
		cartToAdd.add(cart);
		return new ResponseEntity<String>("Product Added to cart!", HttpStatus.CREATED);

	}

	public ResponseEntity<List<Cart>> getCart(String mobNo) {

		List<Cart> cart = cartUtiity.getCart(mobNo);
		org.springframework.http.HttpHeaders responseHeader = new org.springframework.http.HttpHeaders();
		responseHeader.set("content-type", "application/json");
		return ResponseEntity.ok().headers(responseHeader).body(cart);

	}

	public ResponseEntity<String> performOnCart(String mobNo, String op, String productId) {
		List<Cart> cart = cartUtiity.getCart(mobNo);
		String result = cartUtiity.updateCart(cart, op, productId);

		if (result.equals("No, Item in the cart!")) {
			return ResponseEntity.notFound().build();
		}

		else if (result.equals("Successful cart operation +") || result.equals("Successful cart operation -")
				|| result.equals("Product removed from Your Cart!")) {
			return ResponseEntity.ok().body(result);
		}

		return new ResponseEntity<String>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<String> getCartPrice(String mobNo) {
		List<Cart> cart = cartUtiity.getCart(mobNo);

		String responseBody;

		if (cart == null) {
			responseBody = "No cart Found with Given Credentials";
			return new ResponseEntity<String>(responseBody, HttpStatus.NOT_FOUND);
		}

		double totalCartPrice = 0;
		for (int i = 0; i < cart.size(); i++) {
			totalCartPrice = cart.get(i).getProductPrice() * cart.get(i).getQuantity();
		}

		responseBody = "Your total cart price is Rs: " + totalCartPrice + "/-";
		return new ResponseEntity<String>(responseBody, HttpStatus.OK);
	}

	public ResponseEntity<List<Orders>> checkoutCart(String mobNo, String productId) {

		List<Cart> cart = cartUtiity.getCart(mobNo);

		System.out.println(cart);

		for (Cart e : cart) {
			if (e.getProductId().equals(productId)) {

				System.out.println(e.getProductId());

				List<Orders> orders = orderUtility.getOrders(mobNo);

				orders.add(new Orders(e.getProductId(), e.getProductName(), e.getProductPrice() * e.getQuantity(),
						GeneralUtility.getProductRating(), new Date().toString(), GeneralUtility.Paidvia()));

				cart.remove(e);

				return new ResponseEntity<List<Orders>>(orders, HttpStatus.OK);
			}
		}
		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
