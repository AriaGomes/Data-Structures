import java.util.*; 

public class Lab4  
{     
	public static void main(String[] args)      
	{         

		Scanner scanner = new Scanner(System.in);         
		String word = "";                  


		while(!word.equals("exit"))         
		{         
			System.out.println("Please enter palindrome or exit to terminate the program: ");         

			word = scanner.next();                 

			if(isPalindrome(word))             
				System.out.println("The word "+word+" IS a palindrome\n");

			else         
			{
				if(word.toLowerCase().equals("exit"))
					break;

				System.out.println("The word "+word+" IS NOT a palindrome\n");         
			}
		}     
	}          

	static public boolean isPalindrome(String palindrome)    
	{                        

		if(palindrome.length()==1||palindrome.length()==0)                	
			return true;    

		//System.out.println("first="+ st.charAt(0) +"  last="+ st.charAt(st.length()-1));    // Same line as line below, used for visualization         

		if(palindrome.charAt(0)==palindrome.charAt(palindrome.length()-1))                 
			return isPalindrome(palindrome.substring(1, (palindrome.length()-1)));     // Recursive method call   (throws away first and last character)                 

		return false;     

	}
}