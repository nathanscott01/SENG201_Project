package Main;
public class Item extends Purchasable{
	
	public Item(float cost) {
		super(cost);
    }
	
	@Override
	public String toString() {
		return "There is items here";
	}
}
