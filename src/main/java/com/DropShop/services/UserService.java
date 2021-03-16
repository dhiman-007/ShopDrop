package com.DropShop.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.DropShop.Models.Address;
import com.DropShop.Models.Cart;
import com.DropShop.Models.Orders;
import com.DropShop.Models.User;

@Service
public class UserService {

	private static List<User> usersList = new ArrayList<>();

	static {
		usersList.add(new User("Shubham", "Male", "shub@Gmail.com", "9458707862",
				new ArrayList<Address>(
						Arrays.asList(new com.DropShop.Models.Address("UP", "Saharanpur", "247001", true))),
				new ArrayList<Cart>(Arrays.asList(new Cart("CVID1257", "Macbook", "Apple", 1000, 1))),
				new ArrayList<Orders>(
						Arrays.asList(new Orders("VHJL2569", "KookaBoora Bat", 545.36, 4, "13-03-2021", "UPI")))));

	}

	public List<User> getUsers() {
		return getUsersList();
	}

	public static List<User> getUsersList() {
		return usersList;
	}

	public static void setUsersList(List<User> usersList) {
		UserService.usersList = usersList;
	}

}
