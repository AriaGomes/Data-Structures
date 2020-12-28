import java.util.Formatter;
import java.util.Scanner;

/**
 * @author Melissa Sienkiewicz
 *
 */
public class Fruit extends InventoryItem 
{
	/**
	 * Name of the orchard the fruit is from
	 */
	private String orchardName;

	/**
	 * Default Constructor
	 */
	public Fruit() {
		super();
		orchardName = "";
	}


	public boolean addItem(Scanner scanner) {
		if (super.addItem(scanner)) 
		{
			System.out.print("Enter the name of the orchard supplier: ");
			orchardName = scanner.next();
		}
		return true;
	}

	/**
	 * @deprecated
	 * @param writer
	 */
	public void outputItem(Formatter writer) 
	{
		writer.format("f\n");
		writer.format("%s\n", orchardName);
	}

	@Override
	public String toString() {
		return super.toString() + " orchard supplier: " + orchardName;
	}
}
