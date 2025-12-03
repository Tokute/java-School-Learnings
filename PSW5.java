/*

Ned Markus S. Basilio
CS-101

Factory workers paid an hourly rate depending on skill level:

Skill Level Hourly Pay Rate
1	Php187.25
2	Php249.50
3	Php421.00

Base hours per week is 40 hours
Factory worker only allowed at most 7 hours overtime (over the base hours) weekly
OT rate is paid at one and one-half times the usual rate (1.5x?)
Overtime hours exceed, extra hours no longer paid
In addition, workers in skill levels 2 and 3 can choose the following insurance options:

Option Explanation                           Weekly Cost to Employee
1           Medical insurance                     843.50
2           Dental insurance                      632.00
3           Long-term disability insurance        410.00

Workers in skill level 3 can participate in the cooperative shares at 3% of their gross pay weekly

*/

import java.util.Scanner;

public class PSW5
{
	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);
		Scanner userInput2 = new Scanner(System.in); // for String and char
		
		/* --- Initialization of important variables --- */

		float hoursWorked;
		float hourlyRate = 0.00F; // what the final hourly rate will be used
		
		float medicalInsuranceCost = 843.50F;
		float dentalInsuranceCost = 632.00F;
		float longTermDisabilityInsuranceCost = 410.00F;
		int userInsurance = 0;
		float deductions = 0.00F; // will be used for computation. value of the costs above will be used depending on the insurance choice of the user
		
		float netPay = 0.00F;
		char userSharesStatus = 'z';

		/* --- Start of code --- */

		System.out.println("==== IC Philippines Payroll Program ====\n");
		
		// Skill level section
		System.out.print("Input Skill Level[1-3] : ");
		int userSkillLevel = userInput.nextInt();
		
		switch (userSkillLevel)
		{
			case 1:
			hourlyRate = 187.25F;
			break;
			case 2:
			hourlyRate = 249.50F;
			break;
			case 3:
			hourlyRate = 421.00F;
			break;
			default:
			break;
		}
		
		// Different Skill level outcomes section
		if (userSkillLevel == 2 || userSkillLevel == 3) {
			System.out.println("You are eligible for the following insurance:\n1. Medical Insurance: Php 843.50\n2. Dental Insurance: Php 632.00\n3. Long-term Disability Insurance: Php 410.00");
			System.out.print("Insurance Option: ");
			userInsurance = userInput.nextInt();
		}

		if (userSkillLevel == 3) {
			System.out.print("Cooperative Shares (y/n): ");
			userSharesStatus = userInput2.nextLine().charAt(0);
		}

		switch (userInsurance) {
			case 1:
			deductions = medicalInsuranceCost;
			break;
			case 2:
			deductions = dentalInsuranceCost;
			break;
			case 3:
			deductions = longTermDisabilityInsuranceCost;
			break;
			default:
			break;
		}

		
		// Hours Worked and overtime section
		System.out.print("Hours Worked: ");
		float userHoursWorked = userInput.nextFloat();
		hoursWorked = userHoursWorked;	// so that we can still keep the original hours that the user has inputted. hoursWorked will be mainly used for computing overtime pay + regular pay
		float overtimeHours = 0.00F;

		if (hoursWorked > 40) {	// 40 is the maximum hours for one week
			hoursWorked = 40;
			overtimeHours = userHoursWorked - 40; // calculates overtime
		}
		
		if (overtimeHours > 7)
			overtimeHours = 7; //ensures that overtime hours can't go past 7 (7 is the max overtime hours).
		
		// Computations
		
		float regularPay = hoursWorked * hourlyRate;
		float overtimePay = overtimeHours * (hourlyRate * 1.5F);
		float grossPay = regularPay + overtimePay;

		// Outcomes for Net Payment

			// deducts 3% to grossPay if user participates in cooperative shares.

		if (userSharesStatus == 'y' && userSkillLevel == 3) {
			deductions += (grossPay * 0.03);	
			}
		
		if (userSkillLevel == 1) {
			netPay = grossPay;
		} else if (userSkillLevel != 1) {
			netPay = grossPay - deductions;
		}

		// Printing section

		System.out.println("Your Weekly Payroll: ");
		System.out.printf("	Hours Worked: %.1f", userHoursWorked);
		System.out.printf("\n	Hourly Rate: Php%,.2f", hourlyRate);
		System.out.printf("\n	Regular Pay: Php%,.2f", regularPay);
		System.out.printf("\n	Overtime Pay: Php%,.2f", overtimePay);
		System.out.printf("\n	Gross Pay: Php%,.2f", grossPay);
		System.out.printf("\n	Deductions: Php%,.2f", deductions);
		System.out.printf("\n	Net Pay: Php%,.2f", netPay);
	}
}