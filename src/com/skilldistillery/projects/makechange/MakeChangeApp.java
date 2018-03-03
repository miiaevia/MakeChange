/* User Story #1
//
//The user is prompted asking for the price of the item.
//(sysout)
//
//User Story #2
//
//The user is then prompted asking how much money was tendered by the customer.
//(sysout)
//
//User Story #3
//
//Display an appropriate message if the customer provided too little money or 
//the exact amount.
//(if ==, else)
//
//User Story #4
//
//If the amount tendered is more than the cost of the item, 
//display the number of bills and coins that should be given to the customer.
//(if < error, if > cast to int for bill logic (can use % for bill amounts)
//, sub this from double for change (Math.round for rounding))
*/

package com.skilldistillery.projects.makechange;

import java.util.Scanner;

public class MakeChangeApp {
	static double price, custAmount, change, coinsQuar, coinsDimes, coinsNickels;
	static double coinsPennies;
	static int bills20, bills10, bills5, bills1;
	static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {

		priceAmount();
		calcChange();

		kb.close();
	}

	public static void priceAmount() {
		System.out.print("What is the price of the item?: $");
		price = kb.nextDouble();
		System.out.print("What was the amount tendered?: $");
		custAmount = kb.nextDouble();

	}

	public static void calcChange() {
		if (price == custAmount) {
			System.out.println("Thank you, have a good day.");
		}
		else if (price > custAmount) {
			System.err.println("The amount provided is less than the item price. ");
			System.out.println("You still owe "+ -(custAmount - price));
			// System.err.println("Please provide a new amount.");
		}
		else {
			change = Math.round(((custAmount - price) * 100));
			System.out.println("Thank you. Your change is: ");
			calcRemainder();
		}
	}
	public static void calcRemainder() {
		
		
		String[] bill = {"20", "10", "5", "1", "Quarter", "Dime", "Nickel", "Penny"};
//		String[] coins = {"Quarters", "Dimes", "Nickels", "Pennies"};
//		String[] coin = {"Quarter", "Dime", "Nickel", "Penny"};
		int[] values = {2000, 1000, 500, 100, 25, 10, 5, 1};
		
		for (int i = 0; i < values.length; i++) {
			int numberChange = Math.round((int)(change/values[i]));
			if ((values[i] >= 1) && (numberChange != 1)) {
				if (values[i] != 1) {
					System.out.println( numberChange + " " + bill[i] + "s");					
				}
				else {
					System.out.println(numberChange + " Pennies");
				}
				change = change - (numberChange * values[i]);
			}
			else if ((values[i] >= 1 ) && (numberChange == 1)) {
				System.out.println( numberChange + " " + bill[i]);
				change = change - (numberChange * values[i]);
			}
//			else if ((values[i] < 1) && (numberChange > 1)) {
//				System.out.println( numberChange + " " + coin[i]);
//			}
//			else if ((values[i] < 1) && (numberChange <= 1)) {
//				System.out.println( numberChange + " " + coin[i]);
			}
		}
	}


	// public static void remainder() {
	//
	// }

