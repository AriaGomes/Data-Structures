import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Aria Gomes
 * Student Number: 040878659 
 * Course: CST8130 - Data Structures
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 * @author Aria Gomes
 */

public class Lab1 
{
	static int userChoice = 1;
	static Scanner input = new Scanner(System.in);
	static Pattern whitespace = Pattern.compile("(\\w)(\\s+)([\\.,])");
	Matcher matcher = whitespace.matcher(whitespace.pattern());
	
	// @param args
	public static void main(String[] args)
	{
		displayMainMenu();
	}

	// displays main menu to user
	public static void displayMainMenu() 
	{
		Numbers num = new Numbers();					/** LOTS OF MENU PROCESSING **/
		int userArrayChoice = 0;

		while(true)
		{
			
			if(userChoice == 6)
				break;
			
			else
			{
				System.out.print("Please select one of the following: \n"
						+"1: Initialize a default array\n"
						+"2: To specify the max size of the array\n"
						+"3: Add value to the array\n"
						+"4: Display values in the array\n"
						+"5: Display the average of the values\n"
						+"6: To Exit\n"
						+ ">");

				try
				{
					userChoice = input.nextInt();
				}
				catch(InputMismatchException e)
				{
					System.err.println("Error, Please Enter a number 1-6.\n>");
					input.next();
					displayMainMenu();
					
				}
				switch(userChoice)
				{
				case 1:
				{
					num = new Numbers();
					break;
				}
				case 2:
				{
					System.out.print("Enter max array value:\n"
							+ ">");	

					try
					{
						userArrayChoice = input.nextInt();
						break;
					}
					catch(InputMismatchException e)
					{
						input.next();
						System.err.println("Please enter a valid value\n>");
					}
					num = new Numbers(userArrayChoice);
					break;
				}

				case 3:
				{
					try 
					{
						num.initValuesinArray(input);
					}
					catch(InputMismatchException e)
					{
						System.err.println("Please enter a float\n>");
					}
					break;
				}
				case 4:
				{
					int i = 0;
					
					try 
					{		
						for(i = 0; i < Numbers.numItems; i++)
						{
							System.out.println(num.toString(i));
						}
						break;
					}

					catch(NullPointerException e)
					{
						if(i <= userArrayChoice)
						{
							i = userArrayChoice;
							break;
						}
						else
						{
							System.err.println("No values in the array\n>");
							break;
						}
					}
				}
				case 5:
				{	
					try 
					{
						System.out.println("Average is: " + num.calcAverage());
					}
					catch(NullPointerException e)
					{
						System.out.print("Add value(s)");		
					}
					
					break;
					
				}
				}
			}
		}
		System.out.println("\n Exiting... \n");
	}
}