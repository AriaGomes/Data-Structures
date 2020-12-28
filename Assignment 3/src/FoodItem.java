import java.util.Formatter;
import java.util.Scanner;

/**
 * This class encapsulates the behaviour of an item of food to be used with Inventory
 * 
 * @author Melissa Sienkiewicz
 *
 */
public class FoodItem 
{
	/**
	 * Code for food item
	 */
	protected int itemCode;

	/**
	 * Cost of the food item
	 */
	protected float itemCost;

	/**
	 * Name of the food item
	 */
	protected String itemName;

	/**
	 * Price of the food item
	 */
	protected float itemPrice;

	/**
	 * Quantity of the food item
	 */
	private int itemQuantityInStock;

	/**
	 * Default Constructor
	 */
	public FoodItem() {
		itemCode = 0;
		itemName = "";
		itemPrice = 0.0f;
		itemCost = 0.0f;
		itemQuantityInStock = 0;
	}

	

	/**
	 * Returns the item code so it may be used to compare objects
	 *
	 * @return Value of itemCode data member
	 */
	public int getItemCode() {
		return itemCode;
	}

	/**
	 * Reads a valid itemCode from the Scanner object and returns true/false if
	 * successful
	 * 
	 * @param scanner  - Scanner to use for input
	 * @param fromFile - When true, we will not display the questions to the console
	 * @return <code>true</code> if code was populated, <code>false</code> otherwise
	 */
	
	
	

	/**
	 * Compares this object's item code with the one passed in
	 *
	 * @param item - object to compare with
	 * @return <code>true</code> if the itemCode of the object being acted on and
	 *         the item object parameter are the same value, <code>false</code>
	 *         otherwise
	 */
	public boolean isEqual(FoodItem item) {
		return itemCode == item.itemCode;
	}

	/**
	 * Outputs this object to the formatter specified
	 *
	 * @param writer - Formatter to output to
	 */
	public void outputItem(Formatter writer) {
		writer.format("%d\n", itemCode);
		writer.format("%s\n", itemName);
		writer.format("%d\n", itemQuantityInStock);
		writer.format("%.2f\n", itemCost);
		writer.format("%.2f\n", itemPrice);
	}

	@Override
	public String toString() {
		return "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: $"
				+ String.format("%.2f", itemPrice) + " cost: $" + String.format("%.2f", itemCost);
	}

	/**
	 * Updates the quantity field by amount (note amount could be positive or
	 * negative)
	 *
	 * @param amount - what to update by, either can be positive or negative
	 * @return Method returns <code>true</code> if successful, otherwise returns
	 *         <code>false</code>
	 */
	public boolean updateItem(int amount) {
		// If you are removing stock, then check that we have enough stock
		if(amount < 0 && itemQuantityInStock < (amount*-1)) {
			return false;
		}
		itemQuantityInStock += amount;
		return true;
	}

}
