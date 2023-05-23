package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Main.Club;

class ClubTest {
	private Club testClub = new Club();

	@Test
	void setNametest() {
		String newName = "Batersea Lacrosse Alliance";
		testClub.setName(newName);
		assertEquals(newName, testClub.getName());
	}

}
