import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
public class Hash 
{
	
	public static void main(String[] args) 
	{
		int total = 0;
		ArrayList<String> dataItems = new ArrayList<String>(100);
		ArrayList<LinkedList<String>> hashTable = new ArrayList<LinkedList<String>>(100); // ArrayList comprised of LinkedLists used to detect collisions

		for (int i= 0; i < 100; i++) //Fills the arrayList called hashTable with empty linkedList strings
			hashTable.add(i, new LinkedList<String>());
		
		String firstString = "145623";
		String secondString = "145723";
		
		System.out.println("first String is: " + firstString);
		System.out.println("second String is: " + secondString);
		
		System.out.println("middle of first is: " + firstString.charAt(3));
		System.out.println("middle of first is: " + firstString.charAt(4));
		System.out.println("middle of second is: " + secondString.charAt(3));
		System.out.println("middle of second is: " + secondString.charAt(4));
		
		System.out.println("end of first is: " + firstString.charAt(firstString.length()-1));
		System.out.println("end of second is: " + firstString.charAt(firstString.length()-1));
		
		for(int i = 0; i < firstString.length()+secondString.length(); i++)
		{
			if(i<6)
				total = (int)firstString.charAt(0); 
			else
				total = (int)secondString.charAt(0);
		}
			
		System.out.println("The last two digits of the sum are: " + total);
		
		dataItems.add(String.valueOf(total));
		
		for(int i = 0; i < 100; i++)
		{
		   	int random = (int)(100.0 * Math.random());
		   	dataItems.add(String.valueOf(random));
		}
		
		addTo(dataItems, hashTable);
		
		System.out.println(dataItems);
		System.out.println(hashTable);
	}
	
	private static boolean addTo( ArrayList<String> dataItems, ArrayList<LinkedList<String>> hashTable)
	{
		boolean valid = true; // boolean value for the result of this method

		for(int i = 0; i<dataItems.size(); i++)
	{
		String temp = dataItems.get(i);
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
