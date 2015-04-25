package hr.challenges.credit;

import java.util.*;

public class Solution {

	private static int A, B;

	final static int creditCardHalfWidth = 16;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t;

		t = in.nextInt();

		for (int i = 0; i < t; i++) {
			String creditCardNumber = in.next();
			
			for (int j = 0; j <creditCardHalfWidth; j += 2){
				pokeB(Integer.parseInt(creditCardNumber.substring(j, j+1)));
				pokeA(Integer.parseInt(creditCardNumber.substring(j+1, j+2)));
			}
			System.out.println((A + B) % 10 == 0 ? "Yes" : "No");
		}
	}

	private static void pokeA(int digit) {
		A += digit;
	}

	private static void pokeB(int digit) {
		digit *= 2;
		int rightDigit = digit % 10;
		int leftDigit = digit / 10;
		B += rightDigit + leftDigit;
	}
}