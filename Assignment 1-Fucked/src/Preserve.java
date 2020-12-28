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

public class Preserve extends FoodItem
{
	private int jarSize;
	
	public Preserve()
	{
		Scanner scanner = new Scanner(System.in);
		addItem(scanner);
	}
	
	public String toString()
	{
		String x;
		x = (super.toString() + "size: " + jarSize + "mL");
		return x;
	}
	
	public boolean addItem(Scanner scanner) 
	{
		int userInputI;
		
		super.addItem(scanner);
		
		System.out.print("Enter the size of the jar in millilitres:");
		userInputI = scanner.nextInt();
		jarSize = userInputI;
		
		return true;
	}
}