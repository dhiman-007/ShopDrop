package com.DropShop.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DropShop.Models.Cart;
import com.DropShop.Models.Orders;
import com.DropShop.utility.CartUtiity;
import com.DropShop.utility.OrderUtility;

@Service
public class CartService {

	@Autowired
	private UserService userService;

	@Autowired
	private CartUtiity cartUtiity;

	@Autowired
	private OrderUtility orderUtility;

	public String addToCart(Cart cart, String mobNo) {
		List<Cart> cartToAdd = cartUtiity.getCart(mobNo);
		cartToAdd.add(cart);
		return "Product is Successfully Added to your Cart";

	}

	public List<Cart> getCart(String mobNo) {
		List<Cart> cart = cartUtiity.getCart(mobNo);
		return cart;

	}

	public String performOnCart(String mobNo, String op, String productId) {
		List<Cart> cart = cartUtiity.getCart(mobNo);
		String result = cartUtiity.updateCart(cart, op, productId);
		return result;
	}

	public String getCartPrice(String mobNo) {
		List<Cart> cart = cartUtiity.getCart(mobNo);
		double totalCartPrice = 0;
		for (int i = 0; i < cart.size(); i++) {
			totalCartPrice = cart.get(i).getProductPrice() * cart.get(i).getQuantity();
		}
		return "Your total cart price is Rs: " + totalCartPrice + "/-";
	}

	public String checkoutCart(String mobNo, String productId) {
		// TODO Auto-generated method stub
		List<Cart> cart = cartUtiity.getCart(mobNo);
		for (Cart e : cart) {
			if (e.getProductId().equals(productId)) {
				try {
					List<Orders> orders = orderUtility.getOrders(mobNo);
					orders.add(new Orders(e.getProductId(), e.getProductName(), e.getProductPrice(), 0,
							new Date().toString(), "PhonePay"));
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
				cart.remove(e);
				return "Succesfully Placed Order";
			}
		}
		return "Unable to Process Order at this time";
	}

}
