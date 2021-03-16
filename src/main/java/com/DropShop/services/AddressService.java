package com.DropShop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.DropShop.Models.Address;
import com.DropShop.utility.ShopDropUtility;

public class AddressService {

	@Autowired
	private UserService userService;

	@Autowired
	private static ShopDropUtility shopDropUtility;

	public static List<Address> addYourAddress(Address address, String mobNo) {
		List<Address> addressList = shopDropUtility.getAddressList(mobNo);
		addressList.add(address);
		return addressList;
	}

}
