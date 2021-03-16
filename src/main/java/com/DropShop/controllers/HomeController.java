package com.DropShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DropShop.Models.User;
import com.DropShop.services.UserService;

@RestController
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> User() {
		return userService.getUsers();
	}

}
