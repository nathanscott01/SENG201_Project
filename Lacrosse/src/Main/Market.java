package Main;

import java.util.ArrayList;
import java.util.List;

/**
 * The Market Class extends Game Environment. In this class, athletes and items to purchase are generated and
 * stored. When the player wishes to purchase something, the athletes and items are found here. There are seperate functions
 * implemented in this class to view the cost of each athlete or item, or to purchase each athlete or item
 *
 * @author Dominic Dumble, Nathan Scott
 * 
 */
public class Market extends GameEnvironment {
	private List<Athlete> athleteContents;		// List of purchasable Athletes
	private List<Item> itemContents;			// List of purchasable Items

	/**
	 * This function resets the player market when called, and generates a new list of purchasable athletes.
	 * This function calles the createAthlete function found in the GameEnvironment class, where the athletes
	 * stats are generated proportionately to the number of weeks into the game. When players are generated, they
	 * are added to the athleteContents List
	 * 
	 * @param weekNum is the number of weeks into the competition
	 */
	public void resetPlayerMarket(int weekNum) {
		athleteContents.clear();
		int playerNumber = (int)Math.floor(Math.random()*(5-3+1) + 3);
		int current = 1;
		while (current<=playerNumber) {
			current+=1;
			athleteContents.add(createAthlete(weekNum));
		}
		
	}
	
	/**
	 * This function resets the itemContents List and clears it. It then generates more items, where the cost of each
	 * item is proportional to the week number. As a new item is generated, it is then added to the itemList
	 * 
	 * @param weekNum is the week number
	 */
	public void resetItemMarket(int weekNum) {
		itemContents.clear();
		int itemNumber = (int)Math.floor(Math.random()*(5-3+1) + 3);
		int current = 1;
		while (current<=itemNumber) {
			current+=1;
			itemContents.add(createItem(weekNum));
		}
		
	}
	
	/**
	 * This function is called when either the athlete or item market needs reset. A new list is generated and
	 * the respective market is reset.
	 * 
	 * @param type is an integer referring to either the athlete market or the item market
	 */
	public Market(int type) {
		if (type == 0) {
			athleteContents = new ArrayList<Athlete>();
			resetPlayerMarket(1);
		} else {
			itemContents = new ArrayList<Item>();
			resetItemMarket(0);
		}
		
	}
	
	/**
	 * This function removes the athlete from the market and adds it to the team
	 * 
	 * @param index is the index of the selected athlete
	 * @param playerClub is the name of the club
	 * @return athlete.getPrice()
	 */
	public Float buyAthlete(int index, Club playerClub) {
		Athlete athlete = athleteContents.get(index);
		playerClub.addAthlete(athlete);
		athleteContents.remove(athlete);
		return athlete.getPrice();
	}
	
	/**
	 * This function displays the price of the selected athlete
	 * 
	 * @param index is the index of the selected athlete
	 * @return Float
	 */
	public Float getAthletePrice(int index) {
		return athleteContents.get(index).getPrice();
	}
	
	/**
	 * This function picks out the athlete and returns it to be displayed prior to purchase
	 * 
	 * @param index is the index of the chosen athlete
	 * @return Athlete
	 */
	public Athlete getAthlete(int index) {
		Athlete athlete = athleteContents.get(index);
		return athlete;
	}
	
	/**
	 * This function removes the item from the market and adds it to the Clubs inventory, and returns the cost
	 * 
	 * @param index is the index of the chosen item
	 * @param inventory is the Clubs inventory
	 * @return Float
	 */
	public Float buyItem(int index, Inventory inventory) {
		Item item = itemContents.get(index);
		inventory.addItem(item);
		itemContents.remove(item);
		return item.getPrice();
	}
	
	/**
	 * This function returns the cost of the chosen item
	 * 
	 * @param index is the index of the chosen item
	 * @return Float
	 */
	public Float getItemPrice(int index) {
		return itemContents.get(index).getPrice();
	}
	
	/**
	 * This function displays the list of all the athletes available for purchase and returns the number of
	 * athletes available
	 * 
	 * @return int
	 */
	public int printAthleteMarket() {
		int curIndex = 0;
		for(Purchasable athlete : athleteContents) {
			System.out.println(curIndex+". "+athlete+" --- Cost: "+athlete.getPrice());
			curIndex+=1;
		}
		return curIndex;
	}
	 
	/**
	 * This function displays the list of all items available for purchase and returns the number of items
	 * available for purchase
	 * 
	 * @return int
	 */
	public int printItemMarket() {
		int curIndex = 0;
		for(Purchasable item : itemContents) {
			System.out.println(curIndex+". "+item+" --- Cost: "+item.getPrice());
			curIndex+=1;
		}
		return curIndex;
	}
}
