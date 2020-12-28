import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

/*
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Aria Gomes
 * Student Number: 040878659 
 * Course: CST8130 - Data Structures
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 * @author Aria Gomes
 */

public class Lab3
{
	private static int userChoice = 1;
	private static Scanner input = new Scanner(System.in);
	private static File file = new File("src/numbers.dat");
	private static BufferedWriter ostream;
	private static int index = 0;
	
	// @param args
	public static void main(String[] args) throws IOException
	{
		displayMainMenu();
	}

	// displays main menu to user
	public static void displayMainMenu() throws IOException 
	{
		Numbers num = new Numbers();					/** LOTS OF MENU PROCESSING **/
		int userArrayChoice = 0;

		while(true)
		{
			if(userChoice == 10)
				break;
			else
			{
				System.out.print("Please select one of the following: \n"
						+"1: Initialize a default array\n"
						+"2: To specify the max size of the array\n"
						+"3: Add value to the array\n"
						+"4: Display values in the array\n"
						+"5: Display the average of the values\n"
						+"6: Enter Multiple values\n"
						+"7: Read values from file\n"
						+"8: Save values to file\n"
						+"9: Sort the array\n"
						+"10: To Exit\n"
						+">");

				try
				{
					userChoice = input.nextInt();
				}
				catch(InputMismatchException e)
				{
					System.err.println("Error, Please Enter a number 1-6.\n>");
					input.next();
					displayMainMenu();
					break;
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
					num.initValuesinArray(input, false);
				}
				case 4:
				{
					
					try 
					{		
						for(index = 0; index < num.numbers.length; index++)
						{
							System.out.println(num.toString(index));
						}
						break;
					}

					catch(NullPointerException e)
					{
						if(index <= userArrayChoice)
						{
							index = userArrayChoice;
							break;
						}
					}
					break;
				}
				case 5:
				{	
						System.out.println("Average is: " + num.calcAverage());
					break;
					
				}
				case 6:
				{
					num.initMultipleValuesinArray(input);
					break;
				}
				case 7:
				{	
					num.readValues(input, file);
					break;
				}
				case 8:
				{
					num.writeValues(input, file, ostream);
					break;
				}
				case 9:
					num.sortArray();
					break;
				}
			}
		}
		System.out.println("\n Exiting... \n");
	}
}