
import java.util.InputMismatchException;
import java.util.Scanner;

public class Inventory 
{
	protected static int numItems;
	protected FoodItem[] inventory = new FoodItem[20];
	
	public Inventory()
	{
		inventory = new FoodItem[20];
	}
	
	public String toString()
	{
		String[] x = new String[20];
		
		for(int i = 0; i < numItems; i++)
			x[i] = inventory[i].toString();
		
		for(int i = 0; i < numItems; i++)
			System.out.println(x[i]);
		
		return String.valueOf(true);
	}
	
	public int alreadyExists(FoodItem item)
	{
		int length = 20;
		int aEindex = -1;
		
			while (aEindex < length) 
			{   
	           
	            if(inventory[aEindex].itemCode == item.itemCode)
	            {
	                return aEindex;
	            }
	            else
	            { 
	            		aEindex = aEindex + 1; 
	            		alreadyExists(item);
	            }	
	        } 
			return aEindex;
		}
	
	public boolean addItem(Scanner scanner)
	{
		boolean SUCCESS = false;
		
		if(numItems < 20)
		{	
			String foodType;
			System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)?");
			
			foodType = scanner.next();
			foodType = String.valueOf(foodType.charAt(0));
			foodType = foodType.toLowerCase(); // makes the userinput lowercase and cheek only the first char
			
			switch(foodType)
			{
				case "f":
				{
					inventory[numItems] = new Fruit();
					numItems++;
					break;
				}
				case "v":
				{
					inventory[numItems] = new Vegetable();
					numItems++;
					break;
				}
				case "p":
				{
					inventory[numItems] = new Preserve();
					numItems++;
					break;
				}
				default:
				{
					System.err.println("Please enter a valid input\n");
					break;
				}
			}
			SUCCESS = true;
		}
		else
		{
			SUCCESS = false;
			System.err.println("No room in array to create more FoodItems, try selling");
		}		
		
			return SUCCESS;
	}
	
	public boolean updateQuantity(Scanner scanner, boolean buyOrSell)//True for buying false selling
	{
		String word;
		int existingIndex = -1;
		
		if(buyOrSell==true)
			word="buy";
		else
			word="sell";
		
		
		try 
		{
		System.out.print("Enter a valid item code: ");
		scanner.nextInt();
		
		try 
		{	
		for(int i = 0; i < numItems; i++)
		{
			if(existingIndex != -1)
				break;
			
			System.out.print(existingIndex = alreadyExists(inventory[i]));
		}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.err.println("The index with that item code does not exist");
		}
			
		
		System.out.println("Enter a valid quantity to " + word);
		scanner.nextInt();
		}
		catch(InputMismatchException e)
		{
			scanner.next();
			System.err.println("Enter a valid value\n");
		}
		
		return false;
	}
}