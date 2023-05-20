package Main;

import java.util.ArrayList;
import java.util.List;

public class Inventory extends GameEnvironment {
	private List<Item> itemContents;
	
	public Inventory() {
		itemContents = new ArrayList<Item>();
	}
	
	public void addItem(Item item) {
		itemContents.add(item);
	}
	
	public List<Item> getInventory(){
		return itemContents;
	}
	
	public void removeItem(Item item) {
		itemContents.remove(item);
	}
	
	public Boolean notEmpty() {
		for(Item item : itemContents) {
			return true;
		}
		return false;
	}
}
