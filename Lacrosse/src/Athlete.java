public class Athlete extends Purchasable {
	private int atkStat;
	private int defStat;
	private int stamina;
	private String name;
	private String nickname;
	private int position;
	
	public Athlete(float cost,int aStat, int dStat, int stam, String ogName) {
		super(cost);
		
		atkStat = aStat;
		defStat = dStat;
		stamina = stam;
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
	
	public int[] getStats() {
		int[] retArray = new int[3];
		retArray[0] = atkStat;
		retArray[1] = defStat;
		retArray[2] = stamina;
		
		return retArray;
	}
	
	public String[] getName() {
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
}
