import java.util.Scanner;
import java.util.regex.Pattern;

public class Lab7 
{
	
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		keyboard.useDelimiter(Pattern.compile("[\\n\\r]+"));
		BinaryTree tree = new BinaryTree();
		
		
		int choice = 0;
		while(choice != 4)
		{
			displayMenu();
			if(keyboard.hasNext(Pattern.compile("[1-4]")))
			{
				choice = keyboard.nextInt();
				switch(choice)
				{
				case 1: // Add Value to Tree
					boolean valid = false;
					while(!valid)
					{
						System.out.print("Enter an integer to add to the tree: ");
						if(keyboard.hasNextInt())
						{
							valid = true;
							int toAdd = keyboard.nextInt();
							tree.insertInTree(toAdd);
						}
						else
						{
							System.out.println("Invalid integer");
							valid = false;
							keyboard.next();
						}
					}
					break;
				case 2: // Display Tree (In-Order Traversal)
					System.out.println("Tree Traversal");
					tree.displayInOrder();
					System.out.println();
					break;
				case 3:
					System.out.print("Height of tree is: " +(tree.getHeight()+1) + "\n");
					break;
				case 4:
					System.out.println("Exiting...");
					break;
				default:
					break;
				}
			}
			else
			{
				System.out.println("Invalid choice");
				choice = 0;
				keyboard.next();
			}
		}
		keyboard.close();
	}
	
	public static void displayMenu()
	{
		System.out.println("1: Add Value to Tree");
		System.out.println("2: Display Tree (In-Order Traversal)");
		System.out.println("3: Display Height");
		System.out.println("4: To Exit");
		System.out.print("> ");
	}
	
	public void displayInOrder (BinaryTreeNode subRoot)
	{
		if (subRoot == null)   
			return;
		displayInOrder (subRoot.getLeft());
		System.out.print(" " + subRoot.getData() + " ");
		displayInOrder (subRoot.getRight());
	}
}