package Main;

/**
 * The Match Class extends the GameEnvironment Class and generates matches and opposing teams for the
 * player to compete against. 
 * 
 * @author Dominic Dumble, Nathan Scott
 *
 */
public class Match extends GameEnvironment{

	Club enemyClub;			// Initialises an enemy club
	int pointReward;		// Initialises variable for the point reward
	int moneyReward;		// Money Reward upon winning the match
	int atkPower = 0;		// Attack Score
	int defPower = 0;		// Defence Score
	
	
	private String[] clubNames = new String[] {"Thunderbolts Lacrosse Club", "Venomous Vipers Lacrosse", "Shadowhawkes Lacrosse Society",
		"Avalanche Lacrosse Alliance", "Eclipse Lacrosse Alliance", "Phoenix Rising Lacrosse", "Iron Wolves Lacrosse", "Stormchasers Lacrosse Club",
		"Crimson Fury Lacrosse", "Cobalt Corsairs Lacrosse", "Blaze Brigade Lacrosse Club", "Serpentines Lacrosse Society", "Noble Knights Lacrosse",
		"Whirlwind Warriors Lacrosse", "Zenith Lacrosse Club"};
	
	/**
	 * This function initialises the matches that the player can select from. These matches are randomly generated
	 * along with the opposing team and the athletes within
	 * 
	 * @param curWeek is the current week
	 */
	public Match(int curWeek) {
		enemyClub = new Club();
		int randomClubName = (int)Math.floor(Math.random()*(14) + 1);   //random numbers generated for the athletes name
		
		enemyClub.setName(clubNames[randomClubName]);
		for (int i = 0; i < 2; i++) {
			Athlete athlete = createAthlete(curWeek);
			athlete.setPosition(1);
			enemyClub.addAthlete(athlete);
		}
		for (int i = 0; i < 3; i++) {
			Athlete athlete = createAthlete(curWeek);
			athlete.setPosition(2);
			enemyClub.addAthlete(athlete);
		}
		for (int i = 0; i < 2; i++) {
			Athlete athlete = createAthlete(curWeek);
			athlete.setPosition(3);
			enemyClub.addAthlete(athlete);
		}
		
		for(Athlete athlete : enemyClub.getTeam()) {
			atkPower += athlete.getStats()[0];
			defPower += athlete.getStats()[1];
		}
		atkPower = atkPower/7;
		defPower = defPower/7;
		
		moneyReward=(atkPower+defPower)*3;
		pointReward=moneyReward*100;
	}
	
	/**
	 * This function "plays" the match. The outcome of the match is done by comparing the stats of each team. 
	 * The function will return True if the game is won
	 * 
	 * @param playerClub is the players Club
	 * @return Boolean
	 */
	public Boolean playMatch(Club playerClub) {
		int atkTracker = 0;
		int midTracker = 2;
		int defTracker = 5;
		int playerScore = 0;
		int enemyScore = 0;
		int stat;
		for (Athlete athlete : playerClub.getTeam()) {
			if (athlete.getPosition()==1) {                  //Player attacker
				if (athlete.getStats()[0]>=enemyClub.getTeam().get(defTracker).getStats()[1]) {
					playerScore += athlete.getStats()[0] - enemyClub.getTeam().get(defTracker).getStats()[1];
				} else {
					enemyScore += enemyClub.getTeam().get(defTracker).getStats()[1] - athlete.getStats()[0];
					athlete.dropStamina(enemyClub.getTeam().get(defTracker).getStats()[1] - athlete.getStats()[0]);
				}
				defTracker+=1;
			} else {
				if (athlete.getPosition()==2) {     //player mid
					stat = (int)Math.floor(Math.random()*(2)+1);
					if(stat==1) {
						if (athlete.getStats()[0]>=enemyClub.getTeam().get(midTracker).getStats()[1]) {
							playerScore += athlete.getStats()[0] - enemyClub.getTeam().get(midTracker).getStats()[1];
						} else {
							enemyScore += enemyClub.getTeam().get(midTracker).getStats()[1] - athlete.getStats()[0];
							athlete.dropStamina(enemyClub.getTeam().get(midTracker).getStats()[1] - athlete.getStats()[0]);
						}
						midTracker+=1;
					} else {
						if (athlete.getStats()[1]>=enemyClub.getTeam().get(midTracker).getStats()[0]) {
							playerScore += athlete.getStats()[1] - enemyClub.getTeam().get(midTracker).getStats()[0];
						} else {
							enemyScore += enemyClub.getTeam().get(midTracker).getStats()[0] - athlete.getStats()[1];
							athlete.dropStamina(enemyClub.getTeam().get(midTracker).getStats()[0] - athlete.getStats()[1]);
						}
						midTracker+=1;
					}
				} else { //player def
					if (athlete.getStats()[1]>=enemyClub.getTeam().get(atkTracker).getStats()[0]) {
						playerScore += athlete.getStats()[1] - enemyClub.getTeam().get(atkTracker).getStats()[0];
					} else {
						enemyScore += enemyClub.getTeam().get(atkTracker).getStats()[0] - athlete.getStats()[1];
						athlete.dropStamina(enemyClub.getTeam().get(atkTracker).getStats()[0] - athlete.getStats()[1]);
					}
					atkTracker+=1;
				}
			}
		}
		if (playerScore>=enemyScore) {
			return true;
		} else{
			return false;
		}
	}
	
	/**
	 * This function returns the point reward
	 * 
	 * @return int
	 */
	public int getPoints() {
		return pointReward;
	}
	
	/**
	 * This function returns the money won from the game
	 * 
	 * @return int
	 */
	public int getMoney() {
		return moneyReward;
	}
	
	@Override
	/**
	 * This function returns a string with the outcome of the match
	 * 
	 * @return String
	 */
	public String toString() {
		return enemyClub.getName()+": Attack Score-"+atkPower+" || Defence Score-"+defPower+" || Money Reward-"+moneyReward+" || Point Reward-"+pointReward;
	}
}