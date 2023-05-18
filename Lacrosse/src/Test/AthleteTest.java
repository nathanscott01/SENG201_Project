	package Test;
	
	import static org.junit.jupiter.api.Assertions.*;
	import org.junit.jupiter.api.Test;
	import Main.Athlete;
	
	
	class AthleteTest {
	
		@Test
		void test() {
			Athlete testAthlete = new Athlete(13000, 14, 10, 20);
			int[] expectedStats = {14, 10, 20};
			assertEquals(expectedStats, testAthlete.getStats());
		}
	
	}
