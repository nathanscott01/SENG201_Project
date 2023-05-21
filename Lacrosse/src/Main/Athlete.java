package Main;
public class Athlete extends Purchasable {
	private int atkStat;
	private int defStat;
	private int stamina;
	private String name;
	private String nickname;
	private int position;
	
											/*list of random first and last names used for character creation*/
	
	private String[] firstNames = new String[] {"John","Dominic","Nathan","Max","Robert","Paul","Dave","Gary","Michael","Jimmy",
												"Brodie","Eren","Kyle","Ryan","Jen","Rob","Matt","Marcus","Zach","Greg","Tom",
												"Ben","Casey","Bill","Taylor","Katie","Vivien","Alyssa","Sarah","Tina","Diane",
												"Hannah"};
	private String[] lastNames = new String[] {"Adams","Dumble","Scott","Hogan","Cummings","Schwarzmann","Treanor","Tumolo",
												"Kent","Dobble","Devens","Fleming","Jones","Brown","Green","Edgeworth","Lautner",
												"Timchal","Grayson","North","Strife","Universe","Cheeseman","Yeager","Reynolds",
												"Gosling","Wick","Vandeley","Hollow","Forger","Tenneson","Higashiyama"};

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
	public void setPosition(int playerInput) {
		position = playerInput;
	}
	
	public void setNickname(String word) {
		nickname = word;
	}
	
	public int[] getStats() {         //returned as a list of stats
		int[] retArray = new int[3];
		retArray[0] = atkStat;
		retArray[1] = defStat;
		retArray[2] = stamina;
		
		return retArray;
	}
	
	public String[] getName() {		  //returned as a list of name and nickname
		String[] retArray = new String[2];
		retArray[0] = name;
		retArray[1] = nickname;
		
		return retArray;
	}
	
	public int getPosition() {
		return position;
	}
														/*GETTERS AND SETTERS ABOVE*/
	
	public Boolean dropStamina(int decrease) {          /*Decreases the Athletes stamina and returns True if stamina drops to 0*/
		stamina -=decrease;
		return stamina<=0;
	}
	
	public void statIncrease(int stat, int increase) {   /*Used when an item is used for stat increase*/
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
