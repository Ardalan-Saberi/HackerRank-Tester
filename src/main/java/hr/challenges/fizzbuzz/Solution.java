package hr.challenges.fizzbuzz;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n;

		n = in.nextInt();

		for (int i = 1; i <= n; i++) {
			String message = "";
			if (i % 3 == 0) {
				message += "Fizz";
			}
			if (i % 5 == 0) {
				message += "Buzz";
			}
			if (message.equals("")) {
				message += i;
			}

			System.out.println(message);
		}
	}
}