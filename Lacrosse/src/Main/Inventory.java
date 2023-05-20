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
}
