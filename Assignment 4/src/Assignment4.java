import java.io.File;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * File name : Assignment4.java
 * Author: Aria Gomes, 040878659
 * Assignment: Assignmnet 4 - Phone Tree
 * Date:  2019-12-1
 * Professor: Mellissa Sienkiewicz
 */

/**
 * Main wrapper class that contains the Main Menu and basic functions for the Binary Tree
 * @author Aria Gomes
 * @since jdk 13.0.1.9
 * @version 1.0
 * @see BinaryTree
 * @see BinaryTreeNode 
 */
public class Assignment4 
{	
	static int isFound = 0;
	public static void main(String args[])
	{ 
		/*
		 * Declaration of objects used within the class passed as arguments
		 * This main class holds a loop of the main selection menu
		 */
		Scanner userInput = new Scanner(System.in);
		userInput.useDelimiter(Pattern.compile("[\\n\\r]+"));
		BinaryTree tree = new BinaryTree();
		BinaryTreeNode subRoot = new BinaryTreeNode();
		
		int choice = 0;
		while (choice != 7) 
		{
			menu();
			if (userInput.hasNext(Pattern.compile("[1-7]"))) 
			{
				choice = userInput.nextInt();
				switch(choice){
				case 1: // Display
					tree.display();
					break;
				case 2: // Add 1 Item 
					System.out.print("Enter name of contact: ");
					String name = userInput.next();
					System.out.print("Enter phone number for contact: ");
					String num = userInput.next();
					num = num.replaceAll("[\\s-()]", "");
					tree.insertInTree(name,num);							
					break;
				case 3: // Add Contacts from a File
					//NOT IMPLEMENTED BUT ATTEMPTED
					readFromFile(userInput);
					System.out.print("------------TREE---------------"
							+ "\n>");
					tree.display();
					tree.maxDepth();
					break;
				case 4:// Save Contacts to a File
					saveFile(userInput, tree);
					break;
				case 5:// Determine if a Contact is in the List
					System.out.print("Enter name of contact: ");
					String a = userInput.next();
					System.out.print("Enter phone number for contact: ");
					String b = userInput.next();
					int x = search(subRoot, a, b);
					if(x == 1)
					{
						System.out.println("Contact found in tree");
						isFound = 0;
					}
					else if(x == 0)
						System.out.print("Contact NOT found in tree");
					break;
				case 6:// List out who calls whom
					tree.callsWho(subRoot);
					break;
				case 7:// To Exit
					System.out.println("Exiting....");
					break;
				default:
					break;
				}
			}	
			else{
				System.err.println("Invalid choice");
				choice = 0;
				userInput.next();
			}
		}		
	}
	/*
	 * Contains all system.out lines needed for the main menu
	 */
	public static void menu() //Menu
	{
		System.out.println("\nPlease select one of the following: ");
		System.out.println("1: Display the Phone Tree");
		System.out.println("2: Add one Contact to the List");
		System.out.println("3: Add Contacts from a File");
		System.out.println("4: Save Contacts to a File");
		System.out.println("5: Determine if a Contact is in the List");
		System.out.println("6: List out who calls whom");
		System.out.println("7: To Exit");
		System.out.print("> ");     
	}
	/**
	 * Takes the current state of the binary tree and writes it to a file name of the users choosing inside the program directory 
	 * @author Aria Gomes
	 * @param userInput Object scanner used for entering the file name
	 * @param tree Passing in the binary tree to be written to the file
	 */
	public static void saveFile(Scanner userInput, BinaryTree tree) //Save to File
	{
		BinaryTreeNode root = tree.root;
	    Formatter writer;
        if(root==null) 
        {
            System.err.println("List is empty");
        }
        else
        {
            try 
            {
                System.out.print("Enter the filename to save to: ");
                String filename = userInput.next();
                File file = new File(filename);
                file.createNewFile();
                file.setWritable(true);
                writer = new Formatter(file);
                file(root, userInput, writer);
                writer.flush();
                writer.close();
                System.out.print("File Created");
            } 
            	catch (IOException e) 
            {
                System.err.println("Could not create file, " + e.getMessage()); // Creates file if it does not exist
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
    private static void file(BinaryTreeNode subRoot, Scanner userInput, Formatter writer) 
    {
        if(subRoot == null)    
            return;
        file(subRoot.getLeft(), userInput, writer);
        writer.format(subRoot.getToFile()+"\n");
        file(subRoot.getRight(), userInput, writer);
    }
    /**
     * TODO
     * Reads the data of Contact names and phone numbers and adds them into the Binary Tree
     * @author Aria Gomes
     * @param scanner object used to get the filename used to read the data from
     */
    public static void readFromFile(Scanner scanner)  // Attempted Read from file, Not implemented
    {
        try 
        {
            System.out.print("Enter the filename to read from: ");
            String filename = scanner.next();

            File file = new File(filename);
            if (file.exists()) 
            {
                Scanner fileReader = new Scanner(file);
                fileReader.useDelimiter("[\\r\\n]+");
                while (fileReader.hasNext()) 
                {
                    if (!insertFromFile(fileReader, true)) 
                    {
                        System.err.println("Error Encountered while reading the file, aborting...");
                        break;
                    }
                }
            }
            else
                System.out.println("File Not Found, ignoring...");
        } 
        catch (Exception e) 
        {
            System.err.println("Error: " + e.getMessage());
        }
    }
	private static boolean insertFromFile(Scanner fileReader, boolean b) 
	{
		System.out.print(fileReader.hasNextLine());
		return true;
	}
    /**
     * Recursive method which searches through the binary tree for name and number
     * @param subRoot reference object of BinaryTreeNode, used to use functions of specific node at specific elements
     * @param name is a String variable used to locate the node in the tree containing the contact
     * @param number is a String variable used to locate the node in the tree containing the contact
     */
    private static int search(BinaryTreeNode subRoot, String name, String number) 
    {
    	int isFound = 0;
    	
        if(subRoot == null)    
            return 0;
        
        search(subRoot.getLeft(), name, number);
        if(name.equalsIgnoreCase(subRoot.getName())) 
        {
            if(number.equalsIgnoreCase(subRoot.getNum())) 
                isFound = 1;       
        }
        search(subRoot.getRight(), name, number);
        return isFound;
    }
}