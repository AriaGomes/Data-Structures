import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class InventoryItem 
{
	LinkedList<LocalDate> expiries = new LinkedList<LocalDate>();
	
	int itemQuantityInStock;
	
	private FoodItem item;
	
	public boolean addItem(Scanner scanner)
	{
		boolean valid = false;

		
		System.out.print("Enter the name for the item: ");
		item.itemName = scanner.next();
		// Input quantity
		while (!valid) {
			
			System.out.print("Enter the quantity for the item: ");
			if (scanner.hasNextInt()) {
				itemQuantityInStock = scanner.nextInt();
				if (itemQuantityInStock < 0) {
					valid = false;
					System.out.println("Invalid input");
					itemQuantityInStock = 0;
				} else
					valid = true;
			} else {
				System.out.println("Invalid input");
				scanner.next();
				valid = false;
			}
		}

		// Input the cost
		valid = false;
		while (!valid) {
			
			System.out.print("Enter the cost of the item: ");
			if (scanner.hasNextFloat()) {
				item.itemCost = scanner.nextFloat();
				if (item.itemCost < 0) {
					valid = false;
					System.out.println("Invalid input");
					item.itemCost = 0;
				} else
					valid = true;
			} else {
				System.out.println("Invalid input");
				scanner.next();
				valid = false;
			}
		}

		// Input the price
		valid = false;
		while (!valid) {
			
			System.out.print("Enter the sales price of the item: ");
			if (scanner.hasNextFloat()) {
				item.itemPrice = scanner.nextFloat();
				if (item.itemPrice < 0) {
					valid = false;
					System.out.println("Invalid input");
					item.itemPrice = 0;
				} else
					valid = true;
			} else {
				System.out.println("Invalid input");
				scanner.next();
				valid = false;
			}
		}
		return true;
	}
	
	
	public int getItemCode() 
	{
		return item.itemCode;
	}

	
	
	
	public boolean inputCode(Scanner scanner) 
	{
		boolean validInput = false;
		while (!validInput) 
		{
			System.out.print("Enter the code for the item: ");
			if (scanner.hasNextInt()) {
				item.itemCode = scanner.nextInt();
				validInput = true;
			} else {
				System.out.println("Invalid code");
				// Clear the invalid input
				scanner.next();
			}
		}
		return true;
	}
	
	
}
