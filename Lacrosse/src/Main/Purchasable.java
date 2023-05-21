package Main;

/**
 * The Purchasable Class extends the GameEnvironment Class and stores the price of the athlete/item in question
 * 
 * @author Dominic Dumble, Nathan Scott
 */
public class Purchasable extends GameEnvironment {
	private float price;
	
	/**
	 * This function assigns the cost to the price
	 * 
	 * @param cost is the price
	 */
	public Purchasable(float cost){
		price = cost;
	}
	
	/**
	 * This function returns the price
	 * 
	 * @return float
	 */
	public float getPrice() {
		return price;
	}
}
