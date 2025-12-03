/*

Prelim2: Happy Choy's Farm sells organic brown eggs to local customers. They charge Php118 for a dozen eggs, or Php10.05 for individual eggs that are not part of a dozen, individual costs should be declared as named constants. Write a class that prompts a user for the number of eggs in the order and then display the amount owed with corresponding descriptions. Use appropriate data types for variables. Make sure the total cost is properly formatted, with two decimal places for precision. Save the class as Eggs.java.

*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Eggs {
	

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Input number of eggs: ");
		float inputAmount = userInput.nextFloat();	// Determines the amount to be converted
		
		userInput.close();

		List<Integer> eggs = new ArrayList<>();
		eggs.add(12);					// index 0 will be Dozen eggs
		eggs.add(1);					// index 1 will be Loose eggs
		
		
		List<Integer> eggsQuantityList = new ArrayList<>();

		float modulo = inputAmount;
		float dividend = inputAmount;
		int eggsQuantity; 

		int i;
		
		for (i = 0; i < 2; i++) {			// Algorithm for computation
			dividend /= eggs.get(i);
			modulo %= eggs.get(i);
			eggsQuantity = (int) dividend;
			eggsQuantityList.add(eggsQuantity);
			dividend = modulo;			// the dividend the same number as modulo to complete the cycle. Remainder of 24 will be used to determine the loose eggs.
		}
		
		System.out.println("You ordered: " + (int) inputAmount + " eggs. That will be:");
		System.out.println("	Dozens: " + eggsQuantityList.get(0));
		System.out.println("	Loose Eggs: " + eggsQuantityList.get(1));

		float dozenEggPrice = eggsQuantityList.get(0) * 118;
		float constants = eggsQuantityList.get(1) * 10.05f;	// Individual costs will be named as constants

		float totalCost = dozenEggPrice + constants;
		System.out.printf("\nTotal Cost: Php%.2f", totalCost);
	}
}