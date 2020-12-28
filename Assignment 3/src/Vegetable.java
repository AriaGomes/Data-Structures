import java.util.Formatter;
import java.util.Scanner;

/**
 * @author Melissa Sienkiewicz
 *
 */
public class Vegetable extends InventoryItem {
	/**
	 * Name of the farm the vegetable came from
	 */
	private String farmName;

	/**
	 * Default Constructor
	 */
	public Vegetable() 
	{
		super();
		farmName = "";
	}

	@Override
	public boolean addItem(Scanner scanner) {
		if (super.addItem(scanner)) 
		{
			System.out.print("Enter the name of the farm supplier: ");
			farmName = scanner.next();
		}
		return true;
	}

	/**
	 * @deprecated
	 * @param writer
	 */
	public void outputItem(Formatter writer) 
	{
		writer.format("v\n");
		writer.format("%s\n", farmName);
	}

	@Override
	public String toString() 
	{
		return super.toString() + " farm supplier: " + farmName;
	}
}
