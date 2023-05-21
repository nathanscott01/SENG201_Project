package Main;

/**
 * The RandomEvent Class extends the GameEnvironment Class and implements random actions
 * on the club and its athletes throughout the game
 * 
 * @author Dominic Dumble, Nathan Scott
 *
 */
public class RandomEvent extends GameEnvironment {
	String eventDescription;
	int chanceValue;
	
	/**
	 * This function will randomly either increase the stats of certain athletes in the team, or the athlete
	 * will randomly leave the team
	 * 
	 * @param randomNum is the random integer generated that determines the outcome of the random events
	 * @param playerClub is the Club
	 * @return String
	 */
	public String runEvent(int randomNum, Club playerClub) {
		if (randomNum<900) {
			randomNum=1;
		}
		if (randomNum>=900 & randomNum<970) {
			randomNum=2;
		} else {
			randomNum=3;
		}
		switch(randomNum){
		/*
		 * Case 1: Athlete stats increase
		 * Case 2: Athlete leaves team
		 * Case 3: New Athlete added to reserves
		 */
		case(1):
			for(Athlete athlete : playerClub.getTeam()) {
				chanceValue = (int)Math.floor(Math.random()*(100)+1);
				if (chanceValue > 97) {
					athlete.statIncrease(0, 5);
					return athlete.getName()[1]+" gained 5 Attack Power";
				}
				if (chanceValue <= 97 & chanceValue>95) {
					athlete.statIncrease(1, 5);
					return athlete.getName()[1]+" gained 5 Defence Power";
				}
			}
		case(2):
			for(Athlete athlete : playerClub.getReserve()) {
				chanceValue = (int)Math.floor(Math.random()*(100)+1);
				if (chanceValue > (99-athlete.getInjuries()*5)) {
					eventDescription = athlete.getName()[1];
					playerClub.getReserve().remove(athlete);
					return eventDescription+" Left. they couldn't take the pressure anymore.";
				}
			}
		default:
			chanceValue = (int)Math.floor(Math.random()*(100)+1);
			if (chanceValue>=101-5*(5-playerClub.getReserve().size())) {
				Athlete newAthlete = new Athlete(50, 27, 27, 100);
				playerClub.getReserve().add(newAthlete);
			}
			break;
			
		}
		return "Nothing Of note happend";
	}
}
