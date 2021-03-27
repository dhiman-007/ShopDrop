package com.DropShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.DropShop.Models.User;
import com.DropShop.services.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/user/OrdCheck/{MobNo}/{Category}/{ProductId}")
	public ResponseEntity<List<User>> placingOrder(@PathVariable String MobNo, @PathVariable String Category,
			@PathVariable String ProductId) {
		return orderService.placingOrder(MobNo, Category, ProductId);
	}

}
