import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Main entry point
 * 
 * @author Melissa Sienkiewicz
 *
 */
public class Assign3 
{
	/**
	 * Helper method to display menu
	 */
	public static void displayMenu() {
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
	 * Main Menu
	 * 
	 * @param args - Parameters passed into the application
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter(Pattern.compile("[\\r\\n]+"));
		Inventory inventory = new Inventory();
		int choice = 0;
		while (choice != 9) {
			
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
						inventory.searchForItem(scanner);
						break;
					case 6 : // Remove Expired Items
						//TODO
						break;
					case 7: // Print Expired Items
						//TODO
						break;
					case 8: // Change Todays Date
						//TODO
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
			
		scanner.close();
	}
}
