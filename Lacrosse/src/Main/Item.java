package Main;

/**
 * 
 * @author Dominic Dumble, Nathan Scott
 * 
 * 
 *
 */
public class Item extends Purchasable{
	int statChange = 0;
	int changeType = 0;
	String textDesc;
	
	private String[] descriptions = new String[] {"Green Goo, It's glowing", "New Shoes, Fancy", "Sweat Bands, Handy drink for emergencies", "New Stick, Balls stick better",
												  "New clothes, Maybe don't head out naked", "Syringe, It's legal I swear", "Energy Drink, Run faster! Jump Higher!", "A Salad, Scrumptious"};
	
	public Item(float cost) {
		super(cost);
		statChange = (int)Math.floor(Math.random()*(25) + 1);
		changeType = (int)Math.floor(Math.random()*(2+1));
		textDesc = descriptions[(int)Math.floor(Math.random()*(7+1))];
    }
	
	public void useItem(Athlete athlete) {
		athlete.statIncrease(changeType, statChange);
	}
	
	@Override
	public String toString() {
		switch(changeType) {
		case(0):
			return textDesc+": increases Attack by "+statChange;
		case(1):
			return textDesc+": increases Defence by "+statChange;
		}
		return textDesc+": increases Stamina by "+statChange;
	}
}
