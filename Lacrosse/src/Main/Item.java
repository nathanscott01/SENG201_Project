package Main;

/**
 * The Item Class extends Purchasable and controls the movement and actions performed on individual items
 * In this class, items are generated randomly, as well as the effects they have on the athlete.
 *
 * @author Dominic Dumble, Nathan Scott
 * 
 */
public class Item extends Purchasable{
	int statChange = 0;			// The change in the respective stat
	int changeType = 0;			// The stat in question that will be changed
	String textDesc;
	
	private String[] descriptions = new String[] {"Green Goo, It's glowing", "New Shoes, Fancy", "Sweat Bands, Handy drink for emergencies", "New Stick, Balls stick better",
												  "New clothes, Maybe don't head out naked", "Syringe, It's legal I swear", "Energy Drink, Run faster! Jump Higher!", "A Salad, Scrumptious"};
	/**
	 * This function randomly generates items
	 * 
	 * @param cost is the cost of each item
	 */
	public Item(float cost) {
		super(cost);
		statChange = (int)Math.floor(Math.random()*(25) + 1);
		changeType = (int)Math.floor(Math.random()*(2+1));
		textDesc = descriptions[(int)Math.floor(Math.random()*(7+1))];
    }
	
	
	/**
	 * This function is implemented so that the athlete can consume or use the item.
	 * This function increases the respective stat of the athlete
	 * @param athlete is the athlete that will be using the item
	 * @return void
	 */
	public void useItem(Athlete athlete) {
		athlete.statIncrease(changeType, statChange);
	}
	
	@Override
	/**
	 * This function displays the effect the item has on the athlete
	 * 
	 * @return String[]
	 */
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
