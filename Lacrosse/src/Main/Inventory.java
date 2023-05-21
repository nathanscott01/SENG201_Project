package Main;

import java.util.ArrayList;
import java.util.List;

/** 
 * The Inventory Class extends the GameEnvironment Class and is responsible for controlling all aspects of the inventory
 *
 * @author Dominic Dumble, Nathan Scott
 * 
 */
public class Inventory extends GameEnvironment {
	private List<Item> itemContents;		// List of items in Inventory
	
	/**
	 * This function initialises the inventory with an ArrayList
	 * 
	 */
	public Inventory() {
		itemContents = new ArrayList<Item>();
	}
	
	/**
	 * This function adds items to the inventory
	 * 
	 * @param item is the item to be added
	 */
	public void addItem(Item item) {
		itemContents.add(item);
	}
	
	/**
	 * This function retrieves everything within the inventory
	 * @return itemContents
	 */
	public List<Item> getInventory(){
		return itemContents;
	}
	
	/**
	 * This function removes the item from the inventory
	 * 
	 * @param item is the item to remove
	 */
	public void removeItem(Item item) {
		itemContents.remove(item);
	}
	
	/**
	 * This function checks whether the inventory has items or not
	 * 
	 * @return Boolean
	 */
	public Boolean notEmpty() {
		for(Item item : itemContents) {
			return true;
		}
		return false;
	}
}
