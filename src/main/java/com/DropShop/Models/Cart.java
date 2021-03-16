package com.DropShop.Models;

public class Cart {
	private String productId;
	private String productName;
	private String seller;
	private double productPrice;
	private int quantity;

	public Cart(String productId, String productName, String seller, double productPrice, int quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.seller = seller;
		this.productPrice = productPrice;
		this.quantity = quantity;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart() {
	}

}
