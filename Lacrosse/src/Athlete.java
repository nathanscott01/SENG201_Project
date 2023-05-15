import java.math.BigDecimal;

public class Athlete extends Purchasable {
	private int atkStat;
	private int defStat;
	private int stamina;
	private String name;
	private String nickName;
	
	public Athlete(BigDecimal cost,int aStat, int dStat, int stam, String ogName) {
		super(cost);
		
		atkStat = aStat;
		defStat = dStat;
		stamina = stam;
		name = ogName;
		nickName = ogName;
    }
}
