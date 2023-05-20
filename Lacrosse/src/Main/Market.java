package Main;

import java.util.ArrayList;
import java.util.List;

public class Market extends GameEnvironment {
	private List<Athlete> athleteContents;
	private List<Item> itemContents;
	
	public void resetPlayerMarket(int weekNum) {        /*used for athlete market creation and reset*/
		athleteContents.clear();
		int playerNumber = (int)Math.floor(Math.random()*(5-3+1) + 3);
		int current = 1;
		while (current<=playerNumber) {
			current+=1;
			athleteContents.add(createAthlete(weekNum));
		}
		
	}
	
	public void resetItemMarket(int weekNum) {        /*used for item market creation and reset*/
		itemContents.clear();
		int itemNumber = (int)Math.floor(Math.random()*(5-3+1) + 3);
		int current = 1;
		while (current<=itemNumber) {
			current+=1;
			//itemContents.add(createItem(weekNum));   -----------------------------------------------------------------------------------------
		}
		
	}
	
	public Market(int type) {                        /*Market constructor*/
		if (type == 0) {
			athleteContents = new ArrayList<Athlete>();
			resetPlayerMarket(1);
		} else {
			itemContents = new ArrayList<Item>();
			resetItemMarket(0);
		}
		
	}
	
	public void buyAthlete(int index, Club playerClub) {
		Athlete athlete = athleteContents.get(index);
		playerClub.addAthlete(athlete);
		athleteContents.remove(athlete);
	}
	
	public Float getAthletePrice(int index) {
		return athleteContents.get(index).getPrice();
	}
	
	public Float getItemPrice(int index) {
		return itemContents.get(index).getPrice();
	}
	
	public int printAthleteMarket() {      /*Prints athlete market and returns total index*/
		int curIndex = 0;
		for(Purchasable athlete : athleteContents) {
			System.out.println(curIndex+". "+athlete+" --- Cost: "+athlete.getPrice());
			curIndex+=1;
		}
		return curIndex;
	}
	  
	public int printItemMarket() {      /*Prints item market and returns total index*/
		int curIndex = 0;
		for(Purchasable item : itemContents) {
			System.out.println(curIndex+". "+item+" --- Cost: "+item.getPrice());
		}
		return curIndex;
	}
}
