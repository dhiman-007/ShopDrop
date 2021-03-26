package com.DropShop.Models;

import java.util.HashMap;
import java.util.List;

public class Products {

	private HashMap<String, List<Product>> Categoroies;

	public HashMap<String, List<Product>> getCategoroies() {
		return Categoroies;
	}

	public void setCategoroies(HashMap<String, List<Product>> categoroies) {
		Categoroies = categoroies;
	}

	public Products(HashMap<String, List<Product>> categoroies) {
		super();
		Categoroies = categoroies;
	}

}
