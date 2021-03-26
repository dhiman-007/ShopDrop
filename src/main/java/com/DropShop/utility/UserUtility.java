package com.DropShop.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.DropShop.Models.Address;
import com.DropShop.Models.Cart;
import com.DropShop.Models.Orders;
import com.DropShop.Models.User;

@Service
public class UserUtility {

	private static List<User> usersList = new ArrayList<>();

	static {
		usersList.add(new User("Shubham", "Male", "shub@Gmail.com", "9458707862",
				new ArrayList<Address>(
						Arrays.asList(new com.DropShop.Models.Address("UP", "Saharanpur", "247001", true))),
				new ArrayList<Cart>(Arrays.asList(new Cart("CVD157", "Macbook", "Apple", 1000, 1))),
				new ArrayList<Orders>()));

	}

	public static void setUsersList(List<User> usersList) {
		UserUtility.usersList = usersList;
	}

	public static List<User> getUsersList() {
		return usersList;
	}

}
