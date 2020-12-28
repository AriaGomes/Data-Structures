/*
 ============================================================================
 Name        : Assign1.java
 Author      : Aria Gomes
 Version     : 1.0
 Copyright   : Stealing is Wrong!
 Description : Assignment 1: Creates many types of FoodItems with the ability to view inventory (No ability to sell or buy) 
 ============================================================================
 */
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FoodItem 
{
	protected int itemCode;
	private String itemName;
	private float itemPrice;
	private int itemQuantityInStock;
	private float itemCost;
	
	public FoodItem()
	{
		itemCode = 0;
		itemName = null;
		itemPrice = 0;
		itemQuantityInStock = 0;
		itemCost = 0;
	}
	
	public String toString()
	{
		String formattedString = null;
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		formattedString = "Item: " + itemCode + "  " + itemName + "  " + itemQuantityInStock + " price: " + "$" + df.format(itemPrice) + "  " + "cost: " + "$" + df.format(itemCost) + " ";
		return formattedString;
	}
	
	public boolean updateItem(int ammount)
	{
		itemQuantityInStock = ammount;
		return true;
	}
	
	public boolean isEqual(FoodItem item)
	{
		boolean equal = false;
		
		if(itemCode == item.itemCode)
			equal = true;
		else
			equal = false;
		
		return equal;
	}
	
	public boolean addItem(Scanner scanner) 
	{
		String userInputS;
		int userInputI;			// temporary scanner variables
		float userInputF;
		
		try
		{
		System.out.print("Enter the code for the item: ");
		userInputI = scanner.nextInt();
		itemCode = userInputI;
		
		System.out.print("Enter the name for the item: ");
		userInputS = scanner.next();
		itemName = userInputS;
		
		do
		{
			System.out.print("Enter the quantity for the item: ");
			userInputI = scanner.nextInt();
			if(userInputI < 0)
				System.err.print("\nEnter a valid quantity (must be a postive int): ");
			
		}while(itemQuantityInStock < 0);
		itemQuantityInStock = userInputI;
		
		do
		{
			System.out.print("Enter the cost of the item: ");
			userInputF = scanner.nextFloat();
			if(userInputF < 0)
				System.err.print("\nEnter a valid cost (must be a postive float): "); //Error checking for negative values
			
		}while(userInputF < 0);
		itemCost = userInputF;
		
		do
		{
			System.out.print("Enter the sales price of the item: ");
			userInputF = scanner.nextFloat();
			if(userInputF < 0)
				System.err.print("\nEnter a valid sales price (must be a postive float): ");
			
		}while(userInputF < 0);
		itemPrice = userInputF;
		}
		catch(InputMismatchException e)
		{	
			scanner.next();
			System.err.println("Please enter correct values and try again ");
			addItem(scanner);
		}
		
		return true;
	}
	
	public boolean inputCode(Scanner scanner)
	{
		int userItemCode;
		boolean EXISTS = false;
		System.out.print("Enter valid item code: ");
		userItemCode = scanner.nextInt();
		
		if(itemCode == userItemCode)
			EXISTS = true;
		else
		{
			System.err.println("Code not found in inventory...");
			EXISTS = false;
		}
		return EXISTS;
	}
}