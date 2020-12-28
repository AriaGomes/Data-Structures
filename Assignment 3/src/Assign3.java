import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;
// Many Things not implemented due to Processor Architecture Midterm that I needed to study for

/**
 * Main entry point
 * 
 * @author Aria Gomes
 * @author Melissa Sienkiewicz
 * @version 5.0
 * @since jdk11.0.5.10
 * @see FoodItem
 * @see Inventory
 * @see Fruit
 * @see Vegetable
 * @see Preserve
 */
public class Assign3 
{
	/**
	 * Gives the program the ability to know the date
	 */
	static LocalDate todaysDate;
	
	/**
	 * Helper method to display menu
	 */
	public static void displayMenu() 
	{
		System.out.println("Please select one of the following:");
		System.out.println("1: Add Item to Inventory");
		System.out.println("2: Display Current Inventory");
		System.out.println("3: Buy Item(s)");
		System.out.println("4: Sell Item(s)");
		System.out.println("5: Search for Item");
		System.out.println("6: Remove Expired Items");
		System.out.println("7: Print Expired Items");
		System.out.println("8: Change Today's Date");
		System.out.println("9: To Exit");
		System.out.print("> ");
	}

	
	/**
	 * Gives the user the ability to change the today's date using the Scanner object
	 * @param scanner used change the date
	 */
	public static void changeDate(Scanner scanner) 
	{
		String userTdDate;
		System.out.print("Change todays date to (yyyy-mm-dd): ");
		userTdDate = scanner.next();
		
		LocalDate.parse(userTdDate);
		System.out.println("Sucessfully changed the date to: " + userTdDate);
	}
	
	/**
	 * Main Menu
	 * @param args - Parameters passed into the application
	 */
	public static void main(String[] args) 
	{
		todaysDate = LocalDate.now();
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter(Pattern.compile("[\\r\\n]+"));
		Inventory inventory = new Inventory();
		int choice = 0;
		while (choice != 9) 
		{
			try {
				
				displayMenu();
				if (scanner.hasNext(Pattern.compile("[1-9]"))) 
				{
					choice = scanner.nextInt();
					switch (choice) {
					case 1: // Add Item
						if (!inventory.addItem(scanner))
							System.out.println("Error...could not add item");
						break;
					case 2: // Display Current Inventory
						System.out.println(inventory);
						break;
					case 3: // Buy Item(s)
						if (!inventory.updateQuantity(scanner, true))
							System.out.println("Error...could not buy item");
						break;
					case 4: // Sell Item(s)
						if (!inventory.updateQuantity(scanner, false))
							System.out.println("Error...could not sell item");
						break;
					case 5: // Search for Item
						inventory.searchForItem(scanner, true);
						break;
					case 6 : // Remove Expired Items
						System.err.println("Not Implemented");
						break;
					case 7: // Print Expired Items
						inventory.searchForItem(scanner, false);
						break;
					case 8: // Change Todays Date
						changeDate(scanner);
						break;
					case 9: // To Exit
						System.err.println("\t\tExiting...");
						break;
					default: // Should never get here
						System.out.println("Something went wrong");
						break;
					}
				} 
				else 
				{
					System.out.println("Incorrect value entered");
					scanner.next();
				}
			} 
			catch (Exception e) 
			{
                System.out.println("Error Occurred: " + e.getMessage());
            }
			} 
		scanner.close();
	}
}