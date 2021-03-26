package com.DropShop.utility;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class GeneralUtility {

	public static String getRandomID() {
		String random = "";
		Random r = new Random();
		String characters = "ABCDEFGHIJLMNOPQRSTUVWXYZ";
		String numbers = "123456789";
		int max = 24, min = 1;
		for (int i = 0; i < 6; i++) {
			if (i < 3) {
				random += characters.charAt((int) Math.round(Math.random() * (max - min) + min));
			} else {
				max = 8;
				random += numbers.charAt((int) Math.round(Math.random() * (max - min) + min));
			}
		}
		return random;
	}

	public static int getProductRating() {
		return (int) Math.round(Math.random() * (4 - 1) + 1);
	}

	public static String Paidvia() {
		String[] Paymentoptions = { "PayTm", "PhonePay", "Gpay" };
		String paymentOp = Paymentoptions[(int) Math.round(Math.random() * (2 - 1) + 1)];
		return paymentOp;
	}

}
