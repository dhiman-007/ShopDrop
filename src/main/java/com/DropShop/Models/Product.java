package com.DropShop.Models;

public class Product {
	private String PublicProductId;
	private double PublicProductPrice;
	private String PublicNameOfProduct;
	private String PublicSpecification;
	private int PublicproductRating;

	public String getPublicProductId() {
		return PublicProductId;
	}

	public void setPublicProductId(String publicProductId) {
		PublicProductId = publicProductId;
	}

	public Double getPublicProductPrice() {
		return PublicProductPrice;
	}

	public void setPublicProductPrice(double publicProductPrice) {
		PublicProductPrice = publicProductPrice;
	}

	public String getPublicNameOfProduct() {
		return PublicNameOfProduct;
	}

	public void setPublicNameOfProduct(String publicNameOfProduct) {
		PublicNameOfProduct = publicNameOfProduct;
	}

	public String getPublicSpecification() {
		return PublicSpecification;
	}

	public void setPublicSpecification(String publicSpecification) {
		PublicSpecification = publicSpecification;
	}

	public int getPublicproductRating() {
		return PublicproductRating;
	}

	public void setPublicproductRating(int publicproductRating) {
		PublicproductRating = publicproductRating;
	}

	public Product(String publicProductId, Double publicProductPrice, String publicNameOfProduct,
			String publicSpecification, int publicproductRating) {
		super();
		PublicProductId = publicProductId;
		PublicProductPrice = publicProductPrice;
		PublicNameOfProduct = publicNameOfProduct;
		PublicSpecification = publicSpecification;
		PublicproductRating = publicproductRating;
	}

}
