package com.DropShop.utility;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DropShop.Models.Address;
import com.DropShop.Models.User;

@Service
public class AddressUtility {

	@Autowired
	private static UserUtility userUtility;

	public static List<Address> getAddressList(String mobNo) {
		List<User> users = userUtility.getUsersList();
		List<User> user = users.stream().filter(p -> p.getMobileNumber().equals(mobNo)).collect(Collectors.toList());
		List<Address> addressList = user.get(0).getAddress();
		return addressList;
	}
}
