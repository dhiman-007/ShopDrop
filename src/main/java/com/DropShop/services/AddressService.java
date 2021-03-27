package com.DropShop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.DropShop.Models.Address;
import com.DropShop.utility.AddressUtility;

public class AddressService {

	@Autowired
	private UserService userService;

	@Autowired
	private static AddressUtility addressUtility;

	public static ResponseEntity<List<Address>> addYourAddress(Address address, String mobNo) {
		List<Address> addressList = addressUtility.getAddressList(mobNo);
		addressList.add(address);
		return new ResponseEntity<List<Address>>(addressList, HttpStatus.CREATED);
	}

	public static ResponseEntity<String> deleteAddress(String mobNo, String pinCode) {
		List<Address> addressList = addressUtility.getAddressList(mobNo);
		String responseBody;
		for (int i = 0; i < addressList.size(); i++) {
			Address address = addressList.get(i);
			if (address.getPinCode().equals(pinCode)) {
				addressList.remove(i);
				responseBody = "Address Sucessfully Deleted!";
				return new ResponseEntity<String>(responseBody, HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
