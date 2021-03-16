package com.DropShop.Models;

public class Orders {
	private String productId;
	private String producName;
	private double productPrice;
	private int rating;
	private String orderDate;
	private String paidVia;

	public Orders() {
	}

	public Orders(String productId, String producName, double productPrice, int rating, String orderDate,
			String paidVia) {
		super();
		this.productId = productId;
		this.producName = producName;
		this.productPrice = productPrice;
		this.rating = rating;
		this.orderDate = orderDate;
		this.paidVia = paidVia;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProducName() {
		return producName;
	}

	public void setProducName(String producName) {
		this.producName = producName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getPaidVia() {
		return paidVia;
	}

	public void setPaidVia(String paidVia) {
		this.paidVia = paidVia;
	}

}
