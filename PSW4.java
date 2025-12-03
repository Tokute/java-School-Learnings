/*

Ned Markus S. Basilio
CS-101

1. Write the corresponding code for the following problem:

a. Your program should determine and display the conversion of an entered amount in pesos to the following currency bill denominations: 1000, 500, 200, 100, 50 and 20.

b. Breakdown of bills should start from the highest possible denomination.

c. Use appropriate data types for variables.

2. Use proper documentation and comment as needed. Do not forget to comment your name and section at the beginning of your program.

3. Save the Prelim Seatwork program as  PSW4.java.
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class PSW4 {
	

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Input Amount: ");
		float inputAmount = userInput.nextFloat();	// Determines the amount to be converted
		
		userInput.close();

		List<Integer> bills = new ArrayList<>();
		bills.add(1000);
		bills.add(500);
		bills.add(200);
		bills.add(100);
		bills.add(50);
		bills.add(20);		

		List<Integer> billsQuantityList = new ArrayList<>();

		float modulo = inputAmount;
		float dividend = inputAmount;
		int billsQuantity; 

		int i;
		
		for (i = 0; i < 6; i++) {			// Algorithm for computation
			dividend /= bills.get(i);
			modulo %= bills.get(i);
			billsQuantity = (int) dividend;
			billsQuantityList.add(billsQuantity);
			dividend = modulo;			// the dividend the same number as modulo to complete the cycle. Remainder of 20 will be used to determine 10, 10 then 5, 5 then 1.
		}
		
		List<String> billsList = new ArrayList<String>();
		billsList.add("Thousands");
		billsList.add("Five Hundreds");
		billsList.add("Two Hundreds");
		billsList.add("Hundreds");
		billsList.add("Fifties");
		billsList.add("Twenties");		
		
		System.out.println("Denominations:");
		for (i = 0; i < 6; i++) {
			System.out.println("	" + billsList.get(i) + ": " + billsQuantityList.get(i));
		}
	}
}