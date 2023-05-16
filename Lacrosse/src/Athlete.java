import java.math.BigDecimal;

public class Athlete extends Purchasable {
	private int atkStat;
	private int defStat;
	private int stamina;
	private String name;
	private String nickname;
	
	public Athlete(BigDecimal cost,int aStat, int dStat, int stam, String ogName) {
		super(cost);
		
		atkStat = aStat;
		defStat = dStat;
		stamina = stam;
		name = ogName;
		nickname = ogName;
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
}
