package com.DropShop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.DropShop.Models.Address;
import com.DropShop.utility.AddressUtility;

public class AddressService {

	@Autowired
	private UserService userService;

	@Autowired
	private static AddressUtility addressUtility;

	public static List<Address> addYourAddress(Address address, String mobNo) {
		List<Address> addressList = addressUtility.getAddressList(mobNo);
		addressList.add(address);
		return addressList;
	}

	public static String deleteAddress(String mobNo, String pinCode) {
		List<Address> addressList = addressUtility.getAddressList(mobNo);
		for (int i = 0; i < addressList.size(); i++) {
			Address address = addressList.get(i);
			if (address.getPinCode().equals(pinCode)) {
				addressList.remove(i);
				return "Address Sucessfully Deleted";
			}
		}
		return "No Address Found with given pinCode!";
	}

}
