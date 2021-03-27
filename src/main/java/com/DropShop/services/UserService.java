package com.DropShop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.DropShop.Models.User;
import com.DropShop.utility.UserUtility;

@Service
public class UserService {

	@Autowired
	private UserUtility userUtility;

	public ResponseEntity<List<User>> getUsers() {

		List<User> users = userUtility.getUsersList();

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	public ResponseEntity<String> register(User user) {

		List<User> users = userUtility.getUsersList();

		for (User u : users) {

			if (u.getEmail().equals(user.getEmail()) || u.getMobileNumber().equals(user.getMobileNumber())) {

				return new ResponseEntity<String>("User is already registered with these credentials",
						HttpStatus.ALREADY_REPORTED);

			}

			users.add(user);

			return new ResponseEntity<String>("You are Registered!", HttpStatus.CREATED);

		}

		return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
