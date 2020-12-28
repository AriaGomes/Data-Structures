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
	private Float [] numbers;
	
	//Stores current index for inputting values
	private int currentIndex = 0;
	
	//Store the number of items currently in the array. 
	static protected int numItems = 1;
	
	//Default Constructor
	public Numbers() 
	{
		numItems = 1;
		numbers = new Float[0];
	}

	/**
	 * Constructor that initializes the numbers array.
	 * @param size - Max size of the numbers array
	 */
	public Numbers(int size) 
	{
		numbers = new Float[size];
		numItems = size;
	}
	
	/**
	 * Adds a value in the array
	 * @param keyboard - Scanner object to use for input
	 */
	public void initValuesinArray(Scanner input) 
	{
		Float userInput;
		
		System.out.print((currentIndex + 1)+": \n"
					+ ">");
		
		try
		{
			userInput = input.nextFloat();
			
			numbers[currentIndex] = userInput;
			currentIndex++;
		}
		catch(ArrayIndexOutOfBoundsException e)  // Error detection
		{
			System.err.println("Array full");
		}
		
	}
	
	/*
	 *  Takes Multiple values from the user instead of enter single values like option 3
	 *  @param keyboard is a scanner used for user input
	 */
	public void initMultipleValuesinArray(Scanner keyboard) 
	{
		Float userInput;
		int i;
		
		try
		{	
			for(i = 0; i < numItems; i++)        // Iterates through each element of the array
			{
				System.out.print((i + 1)+": \n"
						+ ">");
				
				userInput = keyboard.nextFloat();
				
				numbers[i] = userInput;
			}
		}
		catch(ArrayIndexOutOfBoundsException e)   // Error detection
		{
			System.err.println("Array full");
		}
		catch(InputMismatchException ex)
		{
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
		
		for(int i = 0; i < numItems; i++)
		{
			try
			{
				sum += numbers[i].floatValue();
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.err.println("Enter Values\n");
			}
		}
		return ((float)(sum/numItems)); // returns the final value casted as a float
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
	public void readValues(Scanner keyboard, File f, BufferedReader i) throws IOException
	{
		String fileName;
		
		System.out.println("Enter a file name: ");
		fileName = keyboard.next();
		
		if(f.exists())
		{
			try 
			{
				i = new BufferedReader(new FileReader("src/"+fileName));
			}
			catch(FileNotFoundException e)
			{
				System.err.println("File doesn't exist");		// Room for improvement(create the non-existing file) 
			}
			String x;
			
			while((x = i.readLine()) != null)		// Iterates through each line of the file
				System.out.println(x);
		}
		i.close();
	}
	
	/**
	 * Asks the user for a filename, if the file does not exist it will be created. 
	 * @param keyboard is a Scanner object used for getting user input
	 * @param f is a File object used for storing the external file
	 * @param o is a BufferedWritter object needed for not overwriting previous data in the file
	 * @param fo is a FileWriter object needed for writing values given from the user to the file
	 * @throws IOException
	 */
	public void writeValues(Scanner keyboard, File f, BufferedWriter o, FileWriter fo) throws IOException
	{
		float textFileValue;
		int valuesToAdd;
		String fileName;
		
		System.out.print("Enter a file name: ");
		fileName = keyboard.next();
		File file = new File(fileName);			
		
		fo = new FileWriter("src/"+file, true);	// Creates file if it does not exist
		o = new BufferedWriter(fo);
		
		if(f.exists())
		{
			System.out.print("How many values do you wish to add? ");
			valuesToAdd = keyboard.nextInt();
			
			for(int j = 0; j < valuesToAdd; j++)		// Loop is user-set, and will ask user for values to add to the file
			{
				System.out.print("Enter value: ");
				textFileValue = keyboard.nextFloat();
				o.write(String.valueOf(textFileValue + "\n"));
			}
			o.close();
			fo.close();
		}
	}
}