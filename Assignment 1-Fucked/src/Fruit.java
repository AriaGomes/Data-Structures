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

public class Fruit extends FoodItem
{
	private String orchardName;
	
	public Fruit()
	{
		Scanner scanner = new Scanner(System.in);
		addItem(scanner);
	}
	
	public String toString()
	{
		String x;
		x = (super.toString() + "orchard supplier: " + orchardName);
		return x;
	}
	
	public boolean addItem(Scanner scanner)
	{
		String userinputS;
		
		super.addItem(scanner);
		
		System.out.print("Enter the name of the orchard supplier: ");
		userinputS = scanner.next();
		orchardName = userinputS;
		
		return true;	
	}
}
