package com.DropShop.Models;

public class Address {
	private String State;
	private String localAddress;
	private String pinCode;
	private boolean defaultAddress;

	public Address() {
	}

	public Address(String state, String localAddress, String pinCode, boolean defaultAddress) {
		super();
		this.State = state;
		this.localAddress = localAddress;
		this.pinCode = pinCode;
		this.defaultAddress = defaultAddress;
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

	public boolean isDefaultAddress() {
		return defaultAddress;
	}

	public void setDefaultAddress(boolean defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

}
