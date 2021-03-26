package com.DropShop.utility;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DropShop.Models.Orders;
import com.DropShop.Models.User;

@Service
public class OrderUtility {

	@Autowired
	private UserUtility userUtility;

	public List<Orders> getOrders(String mobNo) {
		List<User> users = userUtility.getUsersList();
		List<User> user = users.stream().filter(p -> p.getMobileNumber().equals(mobNo)).collect(Collectors.toList());
		List<Orders> orders = user.get(0).getOrders();
		return orders;
	}

}
