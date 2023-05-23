package Test;

import static org.junit.jupiter.api.Assertions.*;
import Main.Item;

import org.junit.jupiter.api.Test;

class ItemsTest {
	Item testItem = new Item(217);
	

	@Test
	void costtest() {
		assertEquals(217, testItem.getPrice());
	}

}
