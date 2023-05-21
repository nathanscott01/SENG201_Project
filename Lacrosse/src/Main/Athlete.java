package Main;

/**
 * Athlete Class extends the methods in Purchasable and is used to control the actual individual
 * athletes. The Athlete Class stores the relevant stats of each individual player, their nickname,
 * and position, as well as injuries. Through this class, various methods are available to retrieve
 * information about each athlete.
 *
 * @author Dominic Dumble, Nathan Scott
 * 
 */


public class Athlete extends Purchasable {
	private int atkStat;			// Attack Stats
	private int defStat;			// Defence stats
	private int stamina;			// Stamina stats
	private String name;			// Name
	private String nickname;		// Nickname
	private int position;			// Athletes position in Lacross
	private int injuries = 0;		// Number of injuries obtained

	
	// String array of possible first names
	private String[] firstNames = new String[] {"John","Dominic","Nathan","Max","Robert","Paul","Dave","Gary","Michael","Jimmy",
												"Brodie","Eren","Kyle","Ryan","Jen","Rob","Matt","Marcus","Zach","Greg","Tom",
												"Ben","Casey","Bill","Taylor","Katie","Vivien","Alyssa","Sarah","Tina","Diane",
												"Hannah"};
	// String array of possible last names
	private String[] lastNames = new String[] {"Adams","Dumble","Scott","Hogan","Cummings","Schwarzmann","Treanor","Tumolo",
												"Kent","Dobble","Devens","Fleming","Jones","Brown","Green","Edgeworth","Lautner",
												"Timchal","Grayson","North","Strife","Universe","Cheeseman","Yeager","Reynolds",
												"Gosling","Wick","Vandeley","Hollow","Forger","Tenneson","Higashiyama"};

	/**
	 * A new athlete is initialised in this function. The following parameters are fed into the function, and
	 * the first and last name is generated randomly and assigned to the name of the player.
	 * Nothing is returned from this function
	 * 
	 * @param cost is the cost to purchase the athlete
	 * @param aStat is the attack stats of the athlete
	 * @param dStat is the defence stats of the athlete
	 * @param stam is the stamina stats of the player
	 */
	public Athlete(float cost,int aStat, int dStat, int stam) {
		super(cost);
		atkStat = aStat;
		defStat = dStat;
		stamina = stam;
		int randomFirst = (int)Math.floor(Math.random()*(31) + 1);   //random numbers generated for the athletes name
		int randomLast = (int)Math.floor(Math.random()*(31) + 1);
		String ogName = firstNames[randomFirst]+" "+lastNames[randomLast];
		name = ogName;
		nickname = ogName;
    }
	
	/*GETTERS AND SETTERS BELOW*/
	
	/**
	 * This function takes the player input to select the position of the athlete
	 * 
	 * @param playerInput is an integer representing the desired position for the athlete
	 */
	public void setPosition(int playerInput) {
		position = playerInput;
	}
	
	/**
	 * This function allows the player to set the nickname of the respective athlete, this nickname
	 * will be displayed in place of the name for the duration of the name
	 * 
	 * @param word is the string assigned to the nickname
	 */
	public void setNickname(String word) {
		nickname = word;
	}
	
	/**
	 * This function builds an array showing the different stats of the respective athlete
	 * 
	 * @return int[] of player stats
	 */
	public int[] getStats() {
		int[] retArray = new int[3];
		retArray[0] = atkStat;
		retArray[1] = defStat;
		retArray[2] = stamina;
		
		return retArray;
	}
	
	/**
	 * This function makes an array, the first element showing the name, and the second showing the nickname
	 * 
	 * @return String[] with the two names
	 */
	public String[] getName() {
		String[] retArray = new String[2];
		retArray[0] = name;
		retArray[1] = nickname;
		
		return retArray;
	}
	
	/**
	 * This function will return the position of the player
	 * 
	 * @return position
	 */
	public int getPosition() {
		return position;
	}
	
	/**
	 * This function decreases the stamina of the athlete. If the stamina drops below 0, the injury count of the athlete
	 * will increase by 1
	 * 
	 * @param decrease is the ammount to decrease the athletes stamina by
	 * @return Boolean
	 */
	public Boolean dropStamina(int decrease) {
		stamina -=decrease;
		if (stamina<=0) {
			injuries+=1;
		}
		return stamina<=0;
	}
	
	/**
	 * This function increases one of the stats for the player
	 * 
	 * @param stat selects which stat to increase
	 * @param increase will increase the chosen stat by the amount defined
	 */
	public void statIncrease(int stat, int increase) {
		if(stat==0) {
			atkStat+=increase;
		} else{
			if(stat==1){
			defStat+=increase;
			} else {
				stamina+=increase;
			}
		}
	}
	
	
	/**
	 * This function will return the number of injuries of the respective athlete
	 * 
	 * @return injuries
	 */
	public int getInjuries() {
		return injuries;
	}
	
	/**
	 * This function replenishes the athletes stamina to 100
	 */
	public void rest() {
		stamina = 100;
	}

	@Override
	  public String toString() {
		switch(position) {
			case(1):
				return nickname+": atk-"+atkStat+" def-"+defStat+" stamina-"+stamina+" position-Forward";
			case(2):
				return nickname+": atk-"+atkStat+" def-"+defStat+" stamina-"+stamina+" position-Mid";
			case(3):
				return nickname+": atk-"+atkStat+" def-"+defStat+" stamina-"+stamina+" position-Defence";
			case(4):
				return nickname+": atk-"+atkStat+" def-"+defStat+" stamina-"+stamina+" position-Reserve";
		}
		return "This shouldn't happen";
	  }
}
