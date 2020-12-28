import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Lab8 
{
	public static void main(String[] args) 
	{
		ArrayList<String> dataItems = new ArrayList<String>(100);
		ArrayList<LinkedList<String>> hashTable = new ArrayList<LinkedList<String>>(100); // ArrayList comprised of LinkedLists used to detect collisions

		Scanner keyboard = new Scanner(System.in);

		for (int i= 0; i < 100; i++) //Fills the arrayList called hashTable with empty linkedList strings
			hashTable.add(i, new LinkedList<String>());

		int choice = 0; // User choice variable
		while(choice != 3) // Menu Processing
		{
			displayMenu(); // Displays the Menu calling the method displayMenu
			if(keyboard.hasNext(Pattern.compile("[1-3]")))
			{
				choice = keyboard.nextInt();
				switch(choice)
				{
				case 1: // Add String to array dataItems
					if(!addTo(keyboard, dataItems, hashTable));
					break;
				case 2: // Search for a string in the array dataItems
					hashSearch(keyboard, hashTable);
					break;
				case 3: // Quit
					break;
				default: // Should Never Get Here
					break;
				}
			}
			else
			{
				System.err.println("Invalid choice\n");
				choice = 0;
				keyboard.next();
			}
		}
		keyboard.close(); //Closes the scanner
	}

	public static void displayMenu() // Menu System outs
	{
		System.out.println("1: Add Value to Arraylist dataItems");
		System.out.println("2: Search for a string in the array dataItems");
		System.out.println("3: Exit");
		System.out.print("> ");
	}

	private static boolean addTo(Scanner keyboard, ArrayList<String> dataItems, ArrayList<LinkedList<String>> hashTable)
	{
		boolean valid = true; // boolean value for the result of this method

		System.out.println("Enter String to insert: ");
		String temp = keyboard.next();
		int index = hash(temp);
		if (!search (hashTable, temp, index)) // Invokes the search function to see if the hash already exists inside the ArrayList dataItems
		{
			if(hashTable.get(index).isEmpty())
			{	
			hashTable.get(index).add(temp); // If the hash does not exist inside the table insert it into the the ArrayList
			valid = true;
			}
			else if (!hashTable.get(index).isEmpty())
			{
				hashTable.get(index+1).add(temp); // If the hash does not exist inside the table insert it into the the ArrayList
				valid = true;
			}
			else
		{
			System.err.println ("String " + temp + " is already in structure at index " + index + "\n"); // Else return the a message of where the hash exists inside the ArrayList dataItems
			valid = false;
		}

		
	}
		return valid;
}

	public static boolean search(ArrayList<LinkedList<String>> hashTable, String temp, int index) 
	{
		if (hashTable.get(index).contains(temp)) // Searches for the string at the hashValue and returns true or false
			return true;
		else
			return false;
	}

	private static int hash(String hash)
	{
		int total = 0;

		for (int i = 0; i < hash.length(); i++) // Calculates hash from the string given, if the length of the string is 1 it will take the first char
			if(hash.length() == 1)				// if the string given is longer than 1 char it will add the 1st and 2nd chars together as integer values
				total += (int)hash.charAt(0);
			else
				total += (int)hash.charAt(0) + (int)hash.charAt(1);

		return total % 100;	// returns the char(s) converted to integers modulus by 100 to get the hash value
	}

	private static int hashSearch(Scanner keyboard, ArrayList<LinkedList<String>> hashTable)
	{
		int indexOfHashedString = 0;
		String searchedString;

		System.out.print("Enter a String to search for: ");
		searchedString = keyboard.next();
		indexOfHashedString = hash(searchedString); // stores the index of the hashedString into a variable by invoking the method hash

		if (search (hashTable, searchedString, indexOfHashedString )) // Checks if the hash exists inside of the ArrayList and prints appropriate message
			System.out.println ("String " + searchedString + " is in structure at index " + indexOfHashedString);
		else  
			System.out.println ("String " + searchedString + " is not in structure at index " + indexOfHashedString);

		return indexOfHashedString;
	}
}