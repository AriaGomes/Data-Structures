import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

/**
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Aria Gomes
 * Student Number: 040878659
 * Course: CST8130 - Data Structures
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 * @author Aria Gomes
 */
public class Numbers 
{	
	//Stores Float values.
	protected Float [] numbers;
	
	//Stores current index for inputting values
	private int currentIndex = 0;
	
	//Store the number of items currently in the array. 
    protected int numItems = 0;
	private int avgCounter = 0;
	
	//Default Constructor
	public Numbers() 
	{
		numItems = 0;
		numbers = new Float[100];
	}

	/**
	 * Constructor that initializes the numbers array.
	 * @param size - Max size of the numbers array
	 */
	public Numbers(int userArrayChoice) 
	{
		numbers = new Float[userArrayChoice];
	//	numItems = size;
	}
	
	/**
	 * Adds a value in the array
	 * @param readingValues 
	 * @param keyboard - Scanner object to use for input
	 */
	public void initValuesinArray(Scanner input, boolean readingValues) 
	{	
		try
		{
			if(readingValues == false)
				System.out.print("Enter value " + (currentIndex+1) + ": ");
			
			numbers[currentIndex] = input.nextFloat();
			currentIndex++;
			numItems++;
		}
		catch(ArrayIndexOutOfBoundsException e)  // Error detection
		{
			input.next();
			System.err.println("Array full");
		}
		catch(InputMismatchException ex)
		{
			input.next();
			System.err.println("Please enter a float value\n");
		}
	}
	
	/*
	 *  Takes Multiple values from the user instead of enter single values like option 3
	 *  @param keyboard is a scanner used for user input
	 */
	public void initMultipleValuesinArray(Scanner keyboard) 
	{
		Float userInput;
		int i, valuesToAdd;
		
		System.out.print("How many values would you like to add: ");
		
		
		try
		{	
			valuesToAdd = keyboard.nextInt();
			
			for(i = 0; i < valuesToAdd; i++)        // Iterates through each element of the array
			{
				System.out.print((i + 1)+": \n"
						+ ">");
				userInput = keyboard.nextFloat();
				
				numbers[i] = userInput;
				numItems++;
			}
		}
		catch(ArrayIndexOutOfBoundsException e)   // Error detection
		{
			keyboard.next();
			System.err.println("Array full");
		}
		catch(InputMismatchException ex)
		{
			keyboard.next();
			System.err.println("Please enter a float value\n");
		}
	}
	
	/**
	 * Calculates the average of all the values in the numbers array.
	 * @return float value that represents the average
	 */
	public float calcAverage() 
	{
		float sum = 0;
		float total = 0;
		
		for(int i = 0; i < numbers.length; i++)
		{		
				try
				{
					avgCounter++;
					sum += Float.valueOf(numbers[i]);
					total = sum/avgCounter;
				}
				catch(Exception e)
				{
					
				}
		}
		return total; // returns the final value as a float
	}

	/**
	 * Returns the value of the array numbers as a string value
	 * @param index value of the array we want to return to our display loop
	 * @return index
	 */
	public String toString(int index) 
	{
		Float x = null;
		
		try
		{
			 x = numbers[index];
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.err.println("--End of Array--\n");
		}
		return x.toString(); // returns the final value back to Lab 2.java's displayMainmenu() class
	}
	
	/**
	 * Asks the user which file name they would like to search for in the src folder and reads each line in the file
	 * @param keyboard is a Scanner object used to get input from the user
	 * @param f is a Scanner Object used to store the external file
	 * @param i is a BufferedReader object used to scan through the file selected by the user 
	 * @throws IOException
	 */
	public void readValues(Scanner keyboard, File f) throws IOException
	{
		String fileName;
		int counter;
		System.out.print("Enter a file name: ");
		fileName = keyboard.next();
		boolean readingValues = true;
		
		if(f.exists())
		{
			try 
			{
				Scanner i = new Scanner(new File("src/"+fileName));
				if(i.hasNextInt()) 
				{
					counter = i.nextInt();
					for (int j = 0; j < counter; j++) 
					{
						initValuesinArray(i, readingValues);
					}
				}
			}
			catch(FileNotFoundException e)
			{
				System.err.println("File doesn't exist");		// Room for improvement(create the non-existing file) 
			}
		}
	}
	
	/**
	 * Asks the user for a filename, if the file does not exist it will be created. 
	 * @param keyboard is a Scanner object used for getting user input
	 * @param f is a File object used for storing the external file
	 * @param o is a BufferedWritter object needed for not overwriting previous data in the file
	 * @param fo is a FileWriter object needed for writing values given from the user to the file
	 * @param writeValuesCouter 
	 * @throws IOException
	 */
	public void writeValues(Scanner keyboard, File f, BufferedWriter o) throws IOException
	{
		String fileName;
		
		System.out.print("Enter a file name: ");
		fileName = keyboard.next();
		File file = new File(fileName);			
		
		
		
		if(f.exists())
		{
			
				o = new BufferedWriter(new FileWriter("src/"+file, true));	// Creates file if it does not exist
				for (int i = 0; i < numbers.length; i++)
				{
					if (numbers[i]!=null) 
						o.write(numbers[i]+"\n");
				}
			o.flush();
			o.close();
	     }
	}

	public void sortArray() 
	{
		for(int i = 1; i < numItems; i++) // Iterates through each element of the array (unsorted subset)
		{
		    float value = numbers[i]; // Creates a placeholder value for the current value
		    int j = i - 1;
		    while(j >= 0 && numbers[j] > value) //Checks if the last value was greater (Sorted subset)
		    {
		      numbers[j + 1] = numbers[j]; // If true lower number is swapped
		      j = j - 1;
		    }
		    numbers[j + 1] = value; // Higher number index is given the placeholder value from before (Insertion)
		  } //Loop repeats until array is sorted
		}
	}	// Insertion Sort uses O(n^2) meaning you have to swap and compare every single item