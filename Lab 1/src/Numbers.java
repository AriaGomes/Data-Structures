import java.util.Scanner;

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
	int currentIndex = 0;
	
	//Store the number of items currently in the array. 
	static protected int numItems;
	
	//Default Constructor
	public Numbers() 
	{
		numItems = 0;
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
		
		userInput = input.nextFloat();
		
		try
		{
			numbers[currentIndex] = userInput;
			currentIndex++;
		}
		catch(ArrayIndexOutOfBoundsException e)  // Error detection
		{
			System.err.println("Array full");
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
			sum += numbers[i].floatValue();
		}
		return ((float)(sum/numItems));
	}

	/**
	 * Returns the value of the array numbers as a string value
	 * @param index value of the array we want to return to our display loop
	 * @return index
	 */
	public String toString(int index) 
	{
		Float x = numbers[index];
		return x.toString();
	}
}