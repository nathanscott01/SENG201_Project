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
		
		@Test
		void athleteStatIncreasetest() {
			testAthlete.statIncrease(0, 0);
			testAthlete.statIncrease(1, 15);
			testAthlete.statIncrease(2, 100);
			assertEquals(14, testAthlete.getStats()[0]);
			assertEquals(25, testAthlete.getStats()[1]);
			assertEquals(120, testAthlete.getStats()[2]);
		}
		
		@Test
		void athleteResttest() {
			testAthlete.rest();
			assertEquals(100, testAthlete.getStats()[2]);
		}
		
		@Test
		void athleteDropStaminatest() {
			Boolean injured = testAthlete.dropStamina(19);
			assertEquals(false, injured);
			injured = testAthlete.dropStamina(10);
			assertEquals(true, injured);
		}
		
		@Test
		void athleteTestStringtest() {
			testAthlete.setPosition(3);
			testAthlete.setNickname("Harrison");
			String athleteOutput = "Harrison: atk-14 def-10 stamina-20 position-Defence";
			assertEquals(athleteOutput, testAthlete.toString());
			testAthlete.setPosition(2);
			athleteOutput = "Harrison: atk-14 def-10 stamina-20 position-Mid";
			assertEquals(athleteOutput, testAthlete.toString());
			testAthlete.setPosition(1);
			athleteOutput = "Harrison: atk-14 def-10 stamina-20 position-Forward";
			assertEquals(athleteOutput, testAthlete.toString());
			testAthlete.setPosition(4);
			athleteOutput = "Harrison: atk-14 def-10 stamina-20 position-Reserve";
			assertEquals(athleteOutput, testAthlete.toString());
			testAthlete.setPosition(77);
			athleteOutput = "This shouldn't happen";
			assertEquals(athleteOutput, testAthlete.toString());
			
			
		}
	}
