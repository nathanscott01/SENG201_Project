package Main;

public class Match extends GameEnvironment{

	Club enemyClub;
	int pointReward;
	int moneyReward;
	int atkPower = 0;
	int defPower = 0;
	
	public Match(int curWeek) {
		enemyClub = new Club();
		enemyClub.setName("This a Club");
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
	
	public Boolean playMatch(Club playerClub) { /*returns true if match is won*/
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
	
	public int getPoints() {
		return pointReward;
	}
	
	public int getMoney() {
		return moneyReward;
	}
	
	@Override
	public String toString() {
		return enemyClub.getName()+": Attack Score-"+atkPower+" || Defence Score-"+defPower+" || Points-"+moneyReward+" || Money-"+pointReward;
	}
}