package com.DropShop.Models;

public class Address {
	private String State;
	private String localAddress;
	private String pinCode;

	public Address() {
	}

	public Address(String state, String localAddress, String pinCode) {
		super();
		State = state;
		this.localAddress = localAddress;
		this.pinCode = pinCode;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getLocalAddress() {
		return localAddress;
	}

	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

}
