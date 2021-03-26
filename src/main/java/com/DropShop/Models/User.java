package com.DropShop.Models;

import java.util.List;

public class User {
	private String name;
	private String gender;
	private String email;
	private String MobileNumber;
	private List<Address> address;
	private List<Cart> cart;
	private List<Orders> orders;

	public User() {
	}

	public User(String name, String gender, String email, String mobileNumber, List<Address> address, List<Cart> cart,
			List<Orders> orders) {
		super();
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.MobileNumber = mobileNumber;
		this.address = address;
		this.cart = cart;
		this.orders = orders;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

}
