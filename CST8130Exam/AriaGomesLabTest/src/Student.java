public class Student
{
	private String firstName;
	private String studentNum;
	private float balance;

	public Student() // Default constructor (creates a empty student)
	{
		firstName = " ";
		studentNum = " ";
		balance = 0.0f;
	}

	public Student(String fName, String sNum, float bal) // (Initial Constructor) Creates a new student with new values
	{
		firstName = fName;
		studentNum = sNum;
		balance = bal;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getStudentNum()
	{
		return studentNum;
	}

	public float getBalance()
	{
		return balance;
	}

}