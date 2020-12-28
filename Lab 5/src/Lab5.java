import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Lab5 
{
	static int counter = 0;
	static Scanner input = new Scanner(System.in);
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) 
	{
		displayMenu();

	}

	
	public static void displayMenu()
	{
		int userArrayChoice = 0;

	
		while(true)
		{
			if(userArrayChoice == 4)
				break;
			else
			{
				System.out.print("\nPlease Enter: \n"
						+"1. Add Item\n"
						+"2. Search for Item\n"
						+"3. Display List\n"
						+"4: Exit\n"
						+">");
				try
				{
					userArrayChoice = input.nextInt();
				}
				catch(InputMismatchException e)
				{
					System.err.println("Error, Please Enter a number 1-4.\n");
					input.next();
					displayMenu();
					break;
				}
				switch(userArrayChoice)
				{
				case 1: // Add Item
				{
					addItem(input);
					break;
				}
				case 2: // Search For Item
				{
					Integer arr[] = list.toArray(new Integer[list.size()]); // Creates a static size array to put Arraylist to work with in below method
			        int n = arr.length; 
			        
			        System.out.print("Please specify an Integer: ");
			        int x = input.nextInt();
			        
			        int result = binarySearch(arr, x); 
			        if (result == -1) 
			            System.out.println("Element not present"); 
			        else
			            System.out.println("Element with value " + x + " found at "
			                               + "index " + result);
					break;
				}
				case 3: // Display 
				{
					System.out.println(list.toString());
				}	
		}
	}
			
  }
		System.out.println("\n Exiting... \n");
}
	
	public static boolean addItem(Scanner keyboard)
	{
		Integer userval = 0;
		
		System.out.print("Please specify an Integer: ");
		try 
		{
			userval = keyboard.nextInt();
		}
		catch(InputMismatchException e)
		{
			System.err.println("Please try and add only Integer values and try again");
			keyboard.nextLine();
			addItem(keyboard);
		}
		
		list.add(userval);
		
		return true;
	}  
	
	static int binarySearch(Integer[] arr, int x) 
    { 
        int l = 0, r = arr.length - 1; 
        while (l <= r) 
        { 
            int m = l + (r - l) / 2; 
  
            // Check if x is present at mid 
            if (arr[m] == x) 
                return m; 
  
            // If x greater, ignore left half 
            if (arr[m] < x) 
                l = m + 1; 
  
            // If x is smaller, ignore right half 
            else
                r = m - 1; 
        } 
  
        // if we reach here, then element was 
        // not present 
        return -1; 
    } 
} 