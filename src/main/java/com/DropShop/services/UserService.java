package com.DropShop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DropShop.Models.User;
import com.DropShop.utility.UserUtility;

@Service
public class UserService {

	@Autowired
	private UserUtility userUtility;

	public List<User> getUsers() {
		return userUtility.getUsersList();
	}

}
