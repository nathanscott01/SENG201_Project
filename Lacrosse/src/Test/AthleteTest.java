	package Test;
	
	import static org.junit.jupiter.api.Assertions.*;
	import org.junit.jupiter.api.Test;
	import Main.Athlete;
	
	
	class AthleteTest {
		private Athlete testAthlete = new Athlete(13000, 14, 10, 20);
		private int[] expectedStats = {14, 10, 20};
		private String nickname = "Harrison";
	
		@Test
		void athleteStattest() {
			assertEquals(expectedStats[0], testAthlete.getStats()[0]);
			assertEquals(expectedStats[1], testAthlete.getStats()[1]);
			assertEquals(expectedStats[2], testAthlete.getStats()[2]);
		}
		
		@Test
		void athleteNicknametest() {
			testAthlete.setNickname("Harrison");
			assertEquals(nickname, testAthlete.getName()[1]);		
		}
		
		@Test
		void athletePositiontest() {
			testAthlete.setPosition(3);
			assertEquals(3, testAthlete.getPosition());
		}
		
		@Test
		void athleteInjurytest() {
			assertEquals(0, testAthlete.getInjuries());
		}
	}
