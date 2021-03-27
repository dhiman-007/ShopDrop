package com.DropShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DropShop.Models.User;
import com.DropShop.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> User() {
		return userService.getUsers();
	}

	@PostMapping("/user/register")
	public ResponseEntity<String> register(@RequestBody User user) {
		return userService.register(user);
	}

//	@GetMapping("/user/{MobNo}/login")
//	Public User login(@PathVariable String MobNo) {
//		return userService.login(MobNo);
//	}

}
