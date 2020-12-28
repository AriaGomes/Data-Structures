/**
 * File name : BinaryTreeNode.java
 * Author: Aria Gomes, 040878659
 * Assignment: Assignmnet 4 - Phone Tree
 * Date:  2019-12-1
 * Professor: Mellissa Sienkiewicz
 */

/**
 * BinaryTreeNode class used to initialize and create each Node inside the binary tree 
 * Contains the methods used for node manipulation
 * @author Aria Gomes
 * @author Mellissa Sienkiewicz
 * @see BinaryTreeNode
 * @since 13.0.1.9
 * @version 1.0
 */
public class BinaryTreeNode 
{
	/*
	 * Data members for class BinaryTreeNode
	 */
	private String name;
	private String num;
	private BinaryTreeNode left;
	private BinaryTreeNode right;

	/**
	 * BinaryTreeNode Default Constructor
	 * @author Aria Gomes
	 */
	public BinaryTreeNode()
	{
		left = null;
		right = null;
		num = "";
		name = "";
	}

	/**
	 * BinaryTreeNode Initial Constructor
	 * @param name to set the node to
	 * @param num to set the node to
	 */
	public BinaryTreeNode(String name,String num)
	{
		left = null;
		right = null;
		this.name = name;
		this.num = num;
	}

	/**
	 * Gets the data members to be formated properly, and returns them so they can be ouput to the console
	 * @author Aria Gomes 
	 * @return data formated
	 */
	public Object getData() 
	{
		String data=name+": "+num;
		return data;
	}
	
	/**
	 * Returns the name data member
	 * @author Aria Gomes 
	 * @return name data member
	 */
	public String getName() 
	{
		return name;
	}
	
	/**
	 * Returns the left-most node of the binary tree
	 * @author Aria Gomes
	 * @return BinaryTreeNode
	 */
	public BinaryTreeNode getLeft()
	{
		return left;	
	}

	/**
	 * Returns the right-most node of the binary tree
	 * @author Aria Gomes
	 * @return BinaryTreeNode
	 */
	public BinaryTreeNode getRight()
	{
		return right;
	}

	/**
	 * Inserts the Node properly into the tree by comparing itself to the other nodes in the tree
	 * @author Aria Gomes
	 * @param newName node data item one to be inserted
	 * @param newNum node data item two to be inserted
	 */
	public void insert(String newName,String newNum) 
	{
		String lowName=name.toLowerCase();
		String lowNewName=newName.toLowerCase();		
		int var1 = lowNewName.compareTo(lowName);
		System.out.println(var1);
		
		if (var1<0) {
			if (left == null)
				left = new BinaryTreeNode(newName,newNum);
			else 
				left.insert(newName,newNum);
		}
		else if (var1>0) 
		{
			if (right == null)
				right = new BinaryTreeNode(newName,newNum);
			else 
				right.insert(newName,newNum);
		} 
		else if(var1 == 0)
			System.out.println("Duplicate");
	}
	
	/**
	 * Gets the data members and formats them in proper order for insertion into a text file
	 * @author Aria Gomes
	 * @return the formated string
	 */
	public String getToFile() 
	{
		String data=name+"\n"+num;
        return data;
	}
	
	/**
	 * Returns the number data member
	 * @return num data member
	 */
	public String getNum() 
	{
		return num;
	}
}