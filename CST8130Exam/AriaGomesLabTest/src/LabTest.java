import java.util.Scanner;
import java.util.regex.Pattern;

public class LabTest 
{
	public static void main(String[] args) 
	{
		Scanner userInput = new Scanner(System.in);
		userInput.useDelimiter(Pattern.compile("[\\n\\r]+"));
		StudentRegistrar sR = new StudentRegistrar();

		int choice = 0;
		while (choice != 5) 
		{
			displayMenu();
			if (userInput.hasNext(Pattern.compile("[1-5]"))) 
			{
				choice = userInput.nextInt();
				switch(choice)
				{
				case 1: // Add Student to College Registrar
					sR.addToRegistrar(userInput);
					break;
				case 2: // Display Students in the Registrar 
					sR.displayRegistrar();
					break;
				case 3: // Set College Registrar Name
					sR.setRegistrarName(userInput);
					break;
				case 4: // Search for a Student"
					sR.search(userInput);
					break;
				case 5: // Exit
					break;
				default: // Should never get here
					System.err.println("An error has occured");
					break;
				}
			}	
			else
			{
				System.err.println("Unsupported choice");
				choice = 0;
				userInput.next();
			}
		}	

		if(choice == 5)
		{
			userInput.close();
			System.err.println("\t\tExiting...");
		}
	}

	private static void displayMenu()
	{
		System.out.print("-----------Main Menu-----------\n"
				+ "Please Select one of the following:\n"
				+ "1: Add Student to College Registrar\n"
				+ "2: Display Students in the Registrar\n"
				+ "3: Set College Registrar Name\n"
				+ "4: Search for a Student\n"
				+ "5: Exit\n"
				+ ">");
	}	
}