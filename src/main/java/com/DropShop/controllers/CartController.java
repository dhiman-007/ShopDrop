package com.DropShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DropShop.Models.Cart;
import com.DropShop.services.CartService;

import jdk.jfr.Description;

@RestController
public class CartController {

	@Autowired
	private static CartService cartService;

	@PostMapping("/user/{mobNo}")
	public String addToCart(@RequestBody Cart cart, @PathVariable String mobNo) {
		return cartService.addToCart(cart, mobNo);
	}

	@GetMapping("/user/{MobNo}/getCart")
	public List<Cart> getCart(@PathVariable String MobNo) {
		if (MobNo.length() > 10) {
			throw new Error("Enter Valid Mobile Number");
		}
		return cartService.getCart(MobNo);
	}

	@GetMapping("/user/{MobNo}/{op}/{productId}")
	@Description("cart Operation such as delete, Increasing and decreasing Product Quantity")
	public String performOnCart(@PathVariable String MobNo, @PathVariable String op, @PathVariable String productId) {
		return cartService.performOnCart(MobNo, op, productId);
	}

	@GetMapping("/user/{MobNo}/getCartPrice")
	public String getCartPrice(@PathVariable String MobNo) {
		return cartService.getCartPrice(MobNo);
	}

}
