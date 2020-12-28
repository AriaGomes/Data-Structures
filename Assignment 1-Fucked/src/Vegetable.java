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

public class Vegetable extends FoodItem
{
	private String farmName;
	
	public Vegetable()
	{
		Scanner scanner = new Scanner(System.in);
		addItem(scanner);
	}
	
	public String toString()
	{
		String x;
		x = (super.toString() + "farm supplier: " + farmName);
		return x;
	}
	
	public boolean addItem(Scanner scanner)
	{
		String userinputS;
		
		super.addItem(scanner);
		
		System.out.print("Enter the name of the orchard supplier: ");
		userinputS = scanner.next();
		farmName = userinputS;
		
		return true;	
	}
}