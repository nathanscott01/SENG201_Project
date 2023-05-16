import java.math.BigDecimal;

public class Purchasable extends GameEnvironment {
	private BigDecimal price;
	
	public Purchasable(BigDecimal cost){
		price = cost;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
}
