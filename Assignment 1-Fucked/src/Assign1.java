/*
 ============================================================================
 Name        : Assign1.java
 Author      : Aria Gomes
 Version     : 1.0
 Copyright   : Stealing is Wrong!
 Description : Assignment 1: Creates many types of FoodItems with the ability to view inventory (No ability to sell or buy) 
 ============================================================================
 */
import java.util.Scanner;

public class Assign1 
{
	private static Scanner input;
	
	public static void main(String[] args) 
	{
		Inventory in = new Inventory();
		
		displayMenu(in);
		input.close();
	}

	public static void displayMenu(Inventory in)
	{
		String userChoice = "";
		input = new Scanner(System.in);
		do
		{
			System.out.print("Please select one of the following:\n"
					+ "1: Add Item to Inventory\n" + 
					"2: Display Current Inventory\n" + 
					"3: Buy Item(s)\n" + 
					"4: Sell Item(s)\n" + 
					"5: To Exit\n"
					+">");

			userChoice = input.next();

			switch(userChoice)
			{
				case "1":
				{
					in.addItem(input);
					break;
				}
				case "2": 
				{
					in.toString();
					break;
				}
				case "3": //Needs work(started late no time)
				{
					System.err.println("Please note this function does not work");
					in.updateQuantity(input, true);
					break;
				}
				case "4": //Needs work(started late no time)
				{
					System.err.println("Please note this function does not work");
					in.updateQuantity(input, false);
					break;
				}
				default:
				{
					if(userChoice.equals("5"))
					{
						System.out.println("\n\n\t\t--Exiting--\n\n");
						break;
					}
					else
						System.err.println("<Must be  a number 1-5>");
				}	
			}
		}while(!userChoice.equals("5"));
	}
}