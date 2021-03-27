package com.DropShop.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DropShop.Models.Address;
import com.DropShop.services.AddressService;

@RestController
public class AddressController {

	@PostMapping("/user/{mobNo}/addAddress")
	public ResponseEntity<List<Address>> addyourAddress(@RequestBody Address address, @PathVariable String mobNo) {
		return AddressService.addYourAddress(address, mobNo);
	}

	@DeleteMapping("/user/{mobNo}/{pinCode}")
	public ResponseEntity<String> deleteAddress(@PathVariable String mobNo, @PathVariable String pinCode) {
		return AddressService.deleteAddress(mobNo, pinCode);
	}

}
