package Main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Dominic Dumble, Nathan Scott
 * 
 * Game Environment is the class used to implement and control the different states of the game
 * Game Environment is extended by the Club, Market and Purchasable classes. Game Environment stores the money available,
 * the length and difficulty of the season, and stores the state of the game.
 * 
 *
 */

/**
 * Represents all the states off the game
 */
enum GameState {
	TITLESCREEN, GAMESETUP, TEAMSETUP, WEEKLYSELECT, CLUBVIEW, SWAPATHLETE, INVENTORY, MARKETSELECT,
	ATHLETEMARKET, DRAFTATHELTE, ITEMMARKET, DRAFTITEM, TAKINGBYE, STADIUM, PLAYMATCH, MATCHWIN, MATCHLOSS,
	RESULTSCREEN, GAMEFINISH
}

public class GameEnvironment {
	private int curWeek = 1;
	private int endWeek = 0;
	private int difficulty = 2;
	private float playerMoney = 0;
	private int max = 0;
	private int matchTracker = 0;
	private int playerPoints;
	Scanner sc = new Scanner(System.in);
	
	/**
	 *  calling this advances the weeks by one 
	 */
	public GameState advanceWeek() {
		curWeek +=1;
		// Checks if the current week exceeds season length, ends game if this is the case
		if (curWeek > endWeek){
			return GameState.RESULTSCREEN;
		}
		return GameState.WEEKLYSELECT;
	}
	
	/**
	 * Player input will be used to set the name of the club
	 * 
	 * @param playerInput User inputs their own string
	 * @param playerClub is a Club Class, generated previously
	 */
	public void setClubName(String playerInput, Club playerClub) {
		playerInput = sc.nextLine();
		while ((playerInput.length()<3) | (playerInput.length()>15)){
			System.out.print("\nname must be 3-15 characters: ");
			playerInput = sc.nextLine();
			}
		playerClub.setName(playerInput);
	}
	
	
	/**
	 * getPlayerInt function is used as a general function, where the game asks the user for
	 * a number between min and max. This function is used when selecting a player to draft or purchase, or to select
	 * a player from the team, or to select items.
	 * 
	 * @param min is the minimum index allowed by the system
	 * @param max is the maximum index allowed for the player to select
	 * @param prompt is the prompt relevant to whatever the player is selecting
	 * @return
	 */
	public int getPlayerInt(Integer min, Integer max, String prompt) {   /*gets player input int between min and max*/
		Integer playerInput=-1;
		while ((playerInput<min) | (playerInput>max)){
			System.out.print(prompt);
			try {
		        playerInput= Integer.parseInt(sc.nextLine());
		    } catch (NumberFormatException e) {
//		    	 Returns -1 ???????
		    }
			if ((playerInput<min) | (playerInput>max)){
				System.out.println("Error! Must be an integer between "+min+" and "+max);
			}
		}
		return playerInput;
	}
	
	/**
	 * Takes the user input and sets it as the season length
	 */
	public void setSeasonLength() {           	   /*takes input until one can be set as endWeek*/
		Integer playerInput=0;
		playerInput = getPlayerInt(5, 15, "\nhow many weeks will the season last (5-15): ");
		endWeek = playerInput;
	}
	
	
	/**
	 * initPlayerSetPosition sets the position of the selected athlete on the team. The team is checked via the Club class
	 * to see if the position selected by the player is still available
	 * 
	 * @param athlete is an Athlete Class object, without the position parameter set
	 * @param playerClub a Club Class object, which is used to check if the input position is still available in the team
	 */
	public void initPlayerSetPosition(Athlete athlete, Club playerClub) {
		Integer playerInput=0;
		System.out.println("\n"+athlete);
		playerInput = getPlayerInt(1, 3, "\nSet Player position (1:Forward, 2:Mid, 3:Defense)\nEnter 1-3: ");
		while(playerClub.checkPositionFull(playerInput)) {
			playerInput = getPlayerInt(1, 3, "\nWhoops, that position is full.\nEnter 1-3: ");
		}
		athlete.setPosition(playerInput);
	}
	
	
	/**
	 * createAthlete() is used to generate a new athlete for the team if the team is not full
	 * 
	 * @param curWeek is the current week of the season
	 * @return
	 */
	public Athlete createAthlete(int curWeek) {
		max = 30+5*curWeek;
		int ranAtkStat = (int)Math.floor(Math.random()*(max-15+1) + 15);
		int ranDefStat = (int)Math.floor(Math.random()*(max-15+1) + 15);
		Athlete newAthlete = new Athlete(30, ranAtkStat, ranDefStat, 100);
		newAthlete.setPosition(4);
		return newAthlete;
	}
	
	
	/**
	 * createItem(curWeek) generates a new item each week, with its maximum price increasing proportionately
	 * with each week in the season
	 * 
	 * @param curWeek is the current week of the season
	 * @return
	 */
	public Item createItem(int curWeek) {
		max = 70+15*curWeek;
		int itemCost = (int)Math.floor(Math.random()*(max-40+1) + 40);
		Item newItem = new Item(itemCost);
		return newItem;
	}
	
	
	/**
	 * nameAthlete is called to let the player to create a nick name for the athlete. If no input is received,
	 * the athletes listed name is the one generated by the game.
	 * 
	 * @param athlete is an object of the Athlete Class without the nickname set
	 */
	public void nameAthlete(Athlete athlete) {
		System.out.print("\nEnter nickname or just press enter to let them keep their name: ");
		String playerInputString = sc.nextLine();
		if (playerInputString!="") {
			athlete.setNickname(playerInputString);
		}
	}
	

		/* calling this advances the weeks by one */
		public void resetMatches(List<Match> matches, int curWeek) {
			matches.clear();
			int matchNumber = (int)Math.floor(Math.random()*(5-3+1) + 3);
			int current = 1;
			while (current<=matchNumber) {
				current+=1;
				Match match = new Match(curWeek);
				matches.add(match);
			}
		}
		
		/**
		 * Gamestate controls the state of the game
		 * 
		 * @param state is from the enum Gamestate set
		 * @param playerClub is an object of the class Club
		 * @param playerMarket is an object of the class Market
		 * @param itemMarket is an object of the class Market
		 * @param inventory is an object of the class Inventory
		 * @return
		 */
		public GameState runCurrentState(GameState state, Club playerClub, Market playerMarket, Market itemMarket, Inventory inventory, List<Match> matches) {
			String playerInputString = "";
			Integer playerInputInteger;
			int marketIndex;
			Float price;
			int reserveIndex = -1;
			Athlete athleteTracker;
			GameState nextState;
			
			switch(state) {
				case TITLESCREEN:
					/**
					 * Displays the title screen, stays in this state until player inputs something
					 * @returns the next state, GAMESETUP
					 */
					System.out.print("LACROSSE\n\nenter anything to start: ");
					playerInputString = sc.nextLine();
					return GameState.GAMESETUP;
					
					
				case GAMESETUP:
					/**
					 * Displays a screen and input section for the player to setup game with Club name, 
					 * select game difficulty, allocates money inversely proportionately to the difficulty,
					 * select the length of the season, and setup a match for the first week
					 * 
					 * @returns the next state, TEAMSETUP
					 */
					System.out.println("Set Up Your Club\n");
					System.out.print("Enter a Club name (3-15 characters): ");
					
					setClubName(playerInputString, playerClub); //sets Club name
					
					setSeasonLength();         //sets end week
					
					playerInputInteger = getPlayerInt(1,3,"\nSelect a Difficulty\n\n1. Easy\n2. Normal\n3. Hard\nEnter choice: ");
					difficulty = playerInputInteger;
					playerMoney = 1500/difficulty;
					
					matches.clear();
					playerInputInteger = (int)Math.floor(Math.random()*(5-3+1) + 3);
					marketIndex = 1;
					while (marketIndex<=playerInputInteger) {
						marketIndex+=1;
						Match match = new Match(curWeek);
						matches.add(match);
					}
					
					return GameState.TEAMSETUP;
					
					
				case TEAMSETUP:
					/**
					 * Displays a window for the player to setup the team, player can choose team members in this state
					 * until the team is full. Within each team, there is a set number of slots available for each position,
					 * so the player is limited with regards to how many players they can assign to each position.
					 * Game will stay in TEAMSETUP state until the team is full.
					 * 
					 * The Club Class is accessed in this state to check the number of players in the team
					 * The Athlete Class is accessed in this state to initialise individual athletes and to assign nicknames
					 * 
					 * @returns the WEEKLYSELECT state when team is full
					 */
					while (!playerClub.checkTeamFull()) {        //loop used for player choosing team members
						Athlete newAthlete = createAthlete(curWeek);
						newAthlete.initPlayerSetPosition(newAthlete, playerClub);
						playerClub.addAthlete(newAthlete);
						playerMoney-=newAthlete.getPrice();
						nameAthlete(newAthlete);
					}
					
					
					return GameState.WEEKLYSELECT;
					
					
				case WEEKLYSELECT:
					/**
					 * Player views a window in this state with all the possible options between games. Player puts in an input
					 * to choose which state to go to next.
					 * 
					 * @returns CLUBVIEW, STADIUM, MARKETSELECT or TAKINGBYE upon player input
					 */
					playerInputInteger = getPlayerInt(1,4,"\nWhat would you like to do?\n\n1. Go to Club\n2. Go to Stadium\n3. Visit Market\n4. Take a Bye\nEnter choice: ");
					switch(playerInputInteger) {
						case(1):
							return GameState.CLUBVIEW;
						case(2):
							return GameState.STADIUM;
						case(3):
							return GameState.MARKETSELECT;
						case(4):
							return GameState.TAKINGBYE;
					}
					
					
				case CLUBVIEW:
					/**
					 * Displays a window with the Club name, with a list of the team players and a list of reserves
					 * 
					 * @returns INVENTORY, SWAPATHLETE or WEEKLYSELECT based on player input
					 */
					System.out.println("\nClub Name: "+playerClub.getName()+"\n");
					playerClub.printTeam();
					playerClub.printReserve();
					playerInputInteger = getPlayerInt(1,3,"\nWhat would you like to do?\n\n1. View Inventory\n2. Swap a player with a reserve\n3. Go Back\nEnter choice: ");
					switch(playerInputInteger) {
					case(1):
						return GameState.INVENTORY;
					case(2):
						return GameState.SWAPATHLETE;
					case(3):
						return GameState.WEEKLYSELECT;
				}
					break;
				
				case SWAPATHLETE:   		  /*display inventory, shows items and their effect and use on an athlete*/
					int teamIndex = -1;
					if (playerClub.availableReserve(0)){
						System.out.println();
						for (Athlete athlete : playerClub.getTeam()) {
							teamIndex+=1;
							System.out.println(teamIndex+": "+athlete);
						}
						teamIndex = getPlayerInt(0,teamIndex,"\nEnter number of team member being swapped out: ");
						System.out.println();
						for (Athlete athlete : playerClub.getReserve()) {
							reserveIndex+=1;
							System.out.println(reserveIndex+": "+athlete);
						}
						reserveIndex = getPlayerInt(0,reserveIndex,"\nEnter number of reserve member being swapped out: ");
						playerClub.positionSwap(playerClub.getTeam().get(teamIndex), playerClub.getReserve().get(reserveIndex));
					} else {
						System.out.println("No Available Reserves");
					}
					
					return GameState.CLUBVIEW;
					
				case INVENTORY:   		  /*display inventory, shows items and their effect and use on an athlete*/
					int itemIndex = 0;
					int useIndex;
					System.out.println("Items: ");
					for(Item item : inventory.getInventory()) {
						System.out.println(itemIndex+". "+item);
						itemIndex+=1;
					}
					useIndex = getPlayerInt(0,itemIndex,"\nEnter number of Item you want to use or "+itemIndex+" to leave:");
					if(useIndex != itemIndex) {
						if (!playerClub.availableReserve(-100)) {
							System.out.println("Everyone seems busy training, better try again with some reserves");
							return GameState.CLUBVIEW;
						}
						for (Athlete athlete : playerClub.getReserve()) {
							reserveIndex+=1;
							System.out.println(reserveIndex+": "+athlete);
						}
						reserveIndex = getPlayerInt(0,reserveIndex,"\nEnter number of reserve member the item will be used on: ");
						athleteTracker = playerClub.getReserve().get(reserveIndex);
						inventory.getInventory().get(useIndex).useItem(athleteTracker);
						System.out.println("Item used, "+athleteTracker.getName()[1]+" has had their stats changed\n\n"+athleteTracker);
						inventory.removeItem(inventory.getInventory().get(useIndex));
						return GameState.INVENTORY;
					}
					return GameState.CLUBVIEW;
					
					
				case MARKETSELECT:        /*Choose the athlete store or the item store*/
					playerInputInteger = getPlayerInt(1,5,"\nWelcome to the Market, Which section?      You have:"+playerMoney+" Dollars\n\n1. Athlete Purchase\n2. Athlete Drafting\n3. Item Purchase"
							+ "\n4. Item Drafting\n5. Go Back\nEnter choice: ");
					switch(playerInputInteger) {
						case(1):
							return GameState.ATHLETEMARKET;
						case(2):
							return GameState.DRAFTATHELTE;
						case(3):
							return GameState.ITEMMARKET;
						case(4):
							return GameState.DRAFTITEM;
						case(5):
							return GameState.WEEKLYSELECT;
					}
					
					
				case ATHLETEMARKET:        /*displays a few athletes 3-5 for purchase and their stats*/
					System.out.print("\n Athlete Market\n");
					
					marketIndex = playerMarket.printAthleteMarket();
					playerInputInteger = getPlayerInt(0,marketIndex,"\nEnter index of athlete you want to purchase or "+marketIndex+" to go back: ");
					if (playerInputInteger == marketIndex) {
						return GameState.MARKETSELECT;
					}
					if(playerMoney >= playerMarket.getAthletePrice(playerInputInteger)) {
						price = playerMarket.buyAthlete(playerInputInteger, playerClub);
						playerMoney -=  price;
					} else{
						System.out.print("\n You haven't got enough money for that!\n");
						return GameState.ATHLETEMARKET;
					}
					return GameState.MARKETSELECT;
					
					
				case DRAFTATHELTE:		  /*allows player to draft players and get some money back*/
					System.out.print("Here you can draft athletes from reserves\n");
					int draftReserveIndex = -1;
					if (playerClub.availableReserve(-100)){
						for (Athlete athlete : playerClub.getReserve()) {
							draftReserveIndex+=1;
							System.out.println(draftReserveIndex+": "+athlete+" --- Cost: "+athlete.getPrice());
						}
						draftReserveIndex+=1;
						playerInputInteger = getPlayerInt(0,draftReserveIndex,"\nEnter index of athlete you want to draft or "+draftReserveIndex+" to go back: ");
						if (playerInputInteger != draftReserveIndex) {
							playerMoney += playerClub.getReserve().get(playerInputInteger).getPrice();
							System.out.print("\nItem market\n");
							playerClub.reserveRemoveAthlete(playerClub.getReserve().get(playerInputInteger));
						} else {
							return GameState.MARKETSELECT;
						}
					} else {
						System.out.println("You don't have any Reserves to draft");
						return GameState.MARKETSELECT;
					}
					return GameState.MARKETSELECT;
					
					
				case ITEMMARKET:		  /*displays a few items 3 or more for purchase and their stats*/
					System.out.print("\nItem market\n");
					
					marketIndex = itemMarket.printItemMarket();
					playerInputInteger = getPlayerInt(0,marketIndex,"\nEnter index of athlete you want to purchase or "+marketIndex+" to go back: ");
					if (playerInputInteger == marketIndex) {
						return GameState.MARKETSELECT;
					} else {
						if(playerMoney >= itemMarket.getItemPrice(playerInputInteger)) {
							price = itemMarket.buyItem(playerInputInteger, inventory);
							playerMoney -=  price;
						} else{
							System.out.print("\n You haven't got enough money for that!\n");
							return GameState.ITEMMARKET;
						}
					}
					
					return GameState.MARKETSELECT;
					
					
				case DRAFTITEM:			  /*allows player to draft items and get some money back*/
					System.out.print("Here you can draft items from your inventory\n");
					int draftItemIndex = -1;
					if (inventory.notEmpty()){
						for (Item item : inventory.getInventory()) {
							draftItemIndex+=1;
							System.out.println(draftItemIndex+": "+item+" --- Cost: "+item.getPrice());
						}
						draftItemIndex+=1;
						playerInputInteger = getPlayerInt(0,draftItemIndex,"\nEnter index of the Item you want to draft or "+draftItemIndex+" to go back: ");
						if (playerInputInteger != draftItemIndex) {
							playerMoney += inventory.getInventory().get(playerInputInteger).getPrice();
							inventory.removeItem(inventory.getInventory().get(playerInputInteger));
						} else {
							return GameState.MARKETSELECT;
						}
					} else {
						System.out.println("You don't have any Items to draft");
						return GameState.MARKETSELECT;
					}
					return GameState.MARKETSELECT;
					
					
				case TAKINGBYE:			  /*skips a week, resetting market and matches, runs a random event*/
					nextState = advanceWeek();
					playerMarket.resetPlayerMarket(curWeek);
					itemMarket.resetItemMarket(curWeek);
					matches.clear();
					playerInputInteger = (int)Math.floor(Math.random()*(5-3+1) + 3);
					marketIndex = 1;
					while (marketIndex<=playerInputInteger) {
						marketIndex+=1;
						Match match = new Match(curWeek);
						matches.add(match);
					}
					return nextState;
					
					
				case STADIUM:			  /*displays matches for player to choose from*/
					max = 0;
					for (Match match : matches) {
						System.out.println(max+". "+match);
						max+=1;
					}
					playerInputInteger = getPlayerInt(0,max,"\nEnter index of the Match you want to play or "+max+" to go back: ");
					if (playerInputInteger != max) {
						matchTracker = playerInputInteger;
						if(matches.get(playerInputInteger).playMatch(playerClub)) {
							return GameState.MATCHWIN;
						}else {
							return GameState.MATCHLOSS;
						}
					} else {
						return GameState.WEEKLYSELECT;
					}
					
					
				case MATCHWIN:			  /*display victory screen if player wins match*/
					System.out.println("YOU WON!");
					playerPoints += matches.get(matchTracker).getPoints();
					playerMoney += matches.get(matchTracker).getMoney();
					nextState = advanceWeek();
					playerMarket.resetPlayerMarket(curWeek);
					itemMarket.resetItemMarket(curWeek);
					matches.clear();
					playerInputInteger = (int)Math.floor(Math.random()*(5-3+1) + 3);
					marketIndex = 1;
					while (marketIndex<=playerInputInteger) {
						marketIndex+=1;
						Match match = new Match(curWeek);
						matches.add(match);
					}
					return nextState;
					
					
				case MATCHLOSS:			  /*display loss screen if player loses*/
					System.out.println("YOU LOST!");
					nextState = advanceWeek();
					playerMarket.resetPlayerMarket(curWeek);
					itemMarket.resetItemMarket(curWeek);
					matches.clear();
					playerInputInteger = (int)Math.floor(Math.random()*(5-3+1) + 3);
					marketIndex = 1;
					while (marketIndex<=playerInputInteger) {
						marketIndex+=1;
						Match match = new Match(curWeek);
						matches.add(match);
					}
					return nextState;
					
					
				case RESULTSCREEN:		  /*display the overall result as the player has run out of weeks or athletes*/
					System.out.println("GAME OVER\n\nYou Scored "+playerPoints+" points");
					return GameState.GAMEFINISH;
					
				default:
					break;
			}
			return GameState.GAMEFINISH;
		}
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		Club playerClub = new Club();
		Market playerMarket = new Market(0);
		Market itemMarket = new Market(1);
		Inventory inventory = new Inventory();
		List<Match> matches = new ArrayList<Match>();
		GameState state = GameState.TITLESCREEN;
		
		while(state != GameState.GAMEFINISH) { /*run until the game is finished*/
			state = game.runCurrentState(state, playerClub, playerMarket, itemMarket, inventory, matches);
		}
	}
}
