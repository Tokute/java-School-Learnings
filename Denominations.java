/*

Ned Markus S. Basilio
CS-101

Prelim3: Write a class that determines and displays the conversion of an entered amount in pesos to the following currency coin denominations: 20, 10, 5, and 1. Breakdown should start from the highest possible denomination. Use appropriate data types for variables. Save the class as Denominations.java

*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Denominations {
	

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Input Amount: ");
		float inputAmount = userInput.nextFloat();	// Determines the amount to be converted
		
		userInput.close();

		List<Integer> coins = new ArrayList<>();
		coins.add(20);
		coins.add(10);
		coins.add(5);
		coins.add(1);
		
		List<Integer> coinsQuantityList = new ArrayList<>();

		float modulo = inputAmount;
		float dividend = inputAmount;
		int coinsQuantity; 

		int i;
		
		for (i = 0; i < 4; i++) {			// Algorithm for computation
			dividend /= coins.get(i);
			modulo %= coins.get(i);
			coinsQuantity = (int) dividend;
			coinsQuantityList.add(coinsQuantity);
			dividend = modulo;			// the dividend the same number as modulo to complete the cycle. Remainder of 20 will be used to determine 10, 10 then 5, 5 then 1.
		}
		
		System.out.println("Denominations:");
		System.out.println("	Twenties: " + coinsQuantityList.get(0));
		System.out.println("	Tens: " + coinsQuantityList.get(1));
		System.out.println("	Fives: " + coinsQuantityList.get(2));
		System.out.print("	Ones: " + coinsQuantityList.get(3));
	}
}