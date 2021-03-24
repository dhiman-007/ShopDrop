package com.DropShop.utility;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DropShop.Models.Address;
import com.DropShop.Models.Cart;
import com.DropShop.Models.Orders;
import com.DropShop.Models.User;
import com.DropShop.services.UserService;

@Service
public class ShopDropUtility {

	@Autowired
	private UserService userService;

	public List<Cart> getCart(String mobNo) {
		List<User> users = UserService.getUsersList();
		List<User> user = users.stream().filter(p -> p.getMobileNumber().equals(mobNo)).collect(Collectors.toList());
		List<Cart> cart = user.get(0).getCart();
		return cart;
	}

	public List<Orders> getOrders(String mobNo) {
		List<User> users = UserService.getUsersList();
		List<User> user = users.stream().filter(p -> p.getMobileNumber().equals(mobNo)).collect(Collectors.toList());
		List<Orders> orders = user.get(0).getOrders();
		return orders;
	}

	public static String updateCart(List<Cart> cart, String op, String productId) {
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

	public static List<Address> getAddressList(String mobNo) {
		List<User> users = UserService.getUsersList();
		List<User> user = users.stream().filter(p -> p.getMobileNumber().equals(mobNo)).collect(Collectors.toList());
		List<Address> addressList = user.get(0).getAddress();
		return addressList;
	}

}
