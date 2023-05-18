package Main;
public class Purchasable extends GameEnvironment {
	private float price;
	
	public Purchasable(float cost){
		price = cost;
	}
	
	public float getPrice() {
		return price;
	}
}
