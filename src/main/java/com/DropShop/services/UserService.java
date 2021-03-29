package com.DropShop.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.DropShop.Exceptions.NotFoundExcepton;
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

	public ResponseEntity<User> getUser(String email) {
		// TODO Auto-generated method stub
		List<User> users = userUtility.getUsersList();
		List<User> userIamLookingFor = users.stream().filter(p -> p.getEmail().equalsIgnoreCase(email))
				.collect(Collectors.toList());
		if (userIamLookingFor == null) {
			throw new NotFoundExcepton("No User found with the given Email Id");
		}
		User user = userIamLookingFor.get(0);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
