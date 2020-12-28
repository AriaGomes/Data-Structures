/**
 * File name : BinaryTree.java
 * Author: Aria Gomes, 040878659
 * Assignment: Assignmnet 4 - Phone Tree
 * Date:  2019-12-1
 * Professor: Mellissa Sienkiewicz
 */

/**
 * BinaryTree class used to initialize and create a Binary Tree. Contains the methods used for the general tree
 * @author Aria Gomes
 * @author Mellissa Sienkiewicz
 * @see BinaryTreeNode
 * @since 13.0.1.9
 * @version 1.0
 */
public class BinaryTree 
{
	/*
	 * Declaration of reference member objects
	 */
	BinaryTreeNode root = null;
	BinaryTreeNode x = new BinaryTreeNode();

	/**
	 * Insertion of a new Node into the existing tree using the reference objects
	 * @param newName, Data member one to be entered into the node of type String
	 * @param newNum, Data member two to be entered into the node of type String
	 */
	public void insertInTree(String newName,String newNum) 
	{
		if(root == null)
			root = new BinaryTreeNode(newName,newNum);
		else
			root.insert(newName,newNum);
	}

	/**
	 * Displays the current state of the binary tree, If the tree is empty it will display an empty message.
	 * @author Aria Gomes
	 */
	public void display() 
	{
		if(root==null)
			System.err.println("The List is Empty");
		else
			System.out.println("Phone List:");	
		display(root);
	}

	/**
	 * Displays the current state of the binary tree from the node passed in as an argument
	 * @param subRoot node to start displaying from
	 * @author Aria Gomes
	 */
	private void display(BinaryTreeNode subRoot) 
	{
		if(subRoot == null)
			return;
		display(subRoot.getLeft());
		System.out.println(subRoot.getData()+" ");
		display(subRoot.getRight());
	}

	/**
	 * Finds the current height of the tree, non paramatized(called from the main class)
	 * Displays the message, then calls the method where we find the height
	 * @author Aria Gomes
	 */
	public void maxDepth() 
	{
		System.out.println("Height is: " + (maxDepth(root)));
	}

	/**
	 * Finds the current height of the tree at the trees current state
	 * @author Aria Gomes
	 */
	public int maxDepth(BinaryTreeNode subRoot)
	{ 
		if (subRoot == null) 
			return 0; 
		else{ 
			int lDepth = maxDepth(subRoot.getLeft()); 
			int rDepth = maxDepth(subRoot.getRight()); 
			if (lDepth > rDepth) 
				return (lDepth + 1); 
			else 
				return (rDepth + 1); 
		}
	}

	/**
	 * Checks the tree for duplicate values
	 * @param newName String value used to compare
	 * @param newNum String value used to compare
	 * @return result of found
	 * @author Aria Gomes
	 */
	public int isDuplicate(String newName,String newNum) 
	{
		int isFound = 0;
		
		for(int i=0; i<maxDepth(root); i++)
			if (newName  ==  newNum) 
			{
				System.err.println("Duplicate");
				isFound = 1;
			}
		return isFound;
	} 

/**
 * Displays who calls who by accessing the far most right node and the far most left node
 * @param subRoot reference node used to get each role
 * @author Aria Gomes
 */
public void callsWho(BinaryTreeNode subRoot) 
{
    if(subRoot == null)    
        return;
    
    callsWho(subRoot.getLeft());
    if(subRoot.getName()!=null) {
        System.out.print(subRoot.getName()+" Calls ->");
    
        if(subRoot.getName()==null) 
            System.out.print("\n");
    }
    callsWho(subRoot.getRight());
    }
}