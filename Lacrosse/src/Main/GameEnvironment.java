package Main;
import java.util.Scanner;

enum GameState {
	TITLESCREEN, GAMESETUP, TEAMSETUP, PLAYERPURCHASE, WEEKLYSELECT, CLUBVIEW, SWAPATHLETE, INVENTORY, MARKETSELECT,
	ATHLETEMARKET, DRAFTATHELTE, ITEMMARKET, DRAFTITEM, TAKINGBYE, STADIUM, PLAYMATCH, MATCHWIN, MATCHLOSS,
	RESULTSCREEN, GAMEFINISH
}

public class GameEnvironment {
	private int curWeek = 1;
	private int endWeek = 0;
	private int difficulty = 2;
	private float playerMoney = 0;
	Scanner sc = new Scanner(System.in);
	
	/* calling this advances the weeks by one */
	public GameState advanceWeek() {
		curWeek +=1;
		if (curWeek > endWeek){   /*ends game if end week reached */
			return GameState.RESULTSCREEN;
		}
		return GameState.WEEKLYSELECT;
	}
	
	public void setClubName(String playerInput, Club playerClub) {     /*takes input until one can be set as club name*/
		playerInput = sc.nextLine();
		while ((playerInput.length()<3) | (playerInput.length()>15)){
			System.out.print("\nname must be 3-15 characters: ");
			playerInput = sc.nextLine();
			}
		playerClub.setName(playerInput);
	}
	
	public int getPlayerInt(Integer min, Integer max, String prompt) {   /*gets player input int between min and max*/
		Integer playerInput=-1;
		while ((playerInput<min) | (playerInput>max)){
			System.out.print(prompt);
			try {
		        playerInput= Integer.parseInt(sc.nextLine());
		    } catch (NumberFormatException e) {
		    }
			if ((playerInput<min) | (playerInput>max)){
				System.out.println("Error! Must be an integer between "+min+" and "+max);
			}
		}
		return playerInput;
	}
	
	public void setSeasonLength() {           	   /*takes input until one can be set as endWeek*/
		Integer playerInput=0;
		playerInput = getPlayerInt(5, 15, "\nhow many weeks will the season last (5-15): ");
		endWeek = playerInput;
	}
	
	public void playerSetPosition(Athlete athlete) { /*Player sets an athletes position*/
		Integer playerInput=0;
		playerInput = getPlayerInt(1, 4, "\nSet Player position (1:Forward, 2:Mid, 3:Defense)\nEnter 1-3: ");
		athlete.setPosition(playerInput);
	}
	
	public Athlete createAthlete(int curWeek) {   				/*creates a randomized athlete based on current week !!!!!(week based not implimented) */
		int max = 30+5*curWeek;
		int ranAtkStat = (int)Math.floor(Math.random()*(max-15+1) + 15);
		int ranDefStat = (int)Math.floor(Math.random()*(max-15+1) + 15);
		Athlete newAthlete = new Athlete(30, ranAtkStat, ranDefStat, 100);
		newAthlete.setPosition(4);
		return newAthlete;
	}
	
	public GameState runCurrentState(GameState state, Club playerClub, Market playerMarket, Market itemMarket) {
		String playerInputString = "";
		Integer playerInputInteger;
		
		switch(state) {
			case TITLESCREEN:         /*Display game name until the user inputs anything*/
				System.out.print("LACROSSE\n\nenter anything to start: ");
				playerInputString = sc.nextLine();
				return GameState.GAMESETUP;
				
				
			case GAMESETUP:           /*Set up club name, week number, difficulty*/
				System.out.println("Set Up Your Club\n");
				System.out.print("Enter a Club name (3-15 characters): ");
				
				setClubName(playerInputString, playerClub); //sets Club name
				
				setSeasonLength();         //sets end week
				
				playerInputInteger = getPlayerInt(1,3,"\nSelect a Difficulty\n\n1. Easy\n2. Normal\n3. Hard\nEnter choice: ");
				difficulty = playerInputInteger;
				playerMoney = 1500/difficulty;
				
				return GameState.TEAMSETUP;
				
				
			case TEAMSETUP:           /*Purchase Starting athletes and choosing positions*/
				while (!playerClub.checkTeamFull(playerClub)) {        //loop used for player choosing team members
					Athlete newAthlete = createAthlete(curWeek);
					newAthlete.playerSetPosition(newAthlete);
					playerClub.addAthlete(newAthlete);
					playerMoney-=newAthlete.getPrice();
				}
				
				
				return GameState.WEEKLYSELECT;
				
				
			case PLAYERPURCHASE:      /*Screen for purchase and placement confirmation*/
				System.out.print("MADEITHERE\n");
				break;
				
				
			case WEEKLYSELECT:        /*Display options for weekly actions for player to choose*/
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
				
				
			case CLUBVIEW:            /*View club properties. club name, athletes and properties, inventory*/
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
				int reserveIndex = -1;
				if (playerClub.availableReserve()){
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
				break;
				
				
			case MARKETSELECT:        /*Choose the athlete store or the item store*/
				playerInputInteger = getPlayerInt(1,5,"\nWelcome to the Market, Which section?\n\n1. Athlete Purchase\n2. Athlete Drafting\n3. Item Purchase"
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
				
				int marketIndex = playerMarket.printAthleteMarket();
				playerInputInteger = getPlayerInt(1,marketIndex,"\nEnter index of athlete you want to purchase or "+marketIndex+" to go back: ");
				if (playerInputInteger == marketIndex) {
					return GameState.MARKETSELECT;
				}
				if(playerMoney >= playerMarket.getAthletePrice(playerInputInteger)) {
					playerMarket.buyAthlete(playerInputInteger, playerClub);
					playerMoney -=  playerMarket.getAthletePrice(playerInputInteger);
				}
				return GameState.MARKETSELECT;
				
				
			case DRAFTATHELTE:		  /*allows player to draft players and get some money back*/
				System.out.print("Here you can draft athletes from reserves\n");
				int draftReserveIndex = -1;
				if (playerClub.availableReserve()){
					for (Athlete athlete : playerClub.getReserve()) {
						draftReserveIndex+=1;
						System.out.println(draftReserveIndex+": "+athlete);
					}
					draftReserveIndex+=1;
					playerInputInteger = getPlayerInt(1,draftReserveIndex,"\nEnter index of athlete you want to draft or "+draftReserveIndex+" to go back: ");
					if (playerInputInteger == draftReserveIndex) {
						playerMoney+=playerClub.getReserve().get(draftReserveIndex).getPrice();
						playerClub.reserveRemoveAthlete(playerClub.getReserve().get(draftReserveIndex));
					} else {
						return GameState.MARKETSELECT;
					}
				} else {
					System.out.println("You don't have any reserves to draft");
					return GameState.MARKETSELECT;
				}
				return GameState.MARKETSELECT;
				
				
			case ITEMMARKET:		  /*displays a few items 3 or more for purchase and their stats*/
				System.out.print("MADEITHERE item market\n");
				return GameState.MARKETSELECT;
				
				
			case DRAFTITEM:			  /*allows player to draft items and get some money back*/
				System.out.print("MADEITHERE draft item\n");
				return GameState.MARKETSELECT;
				
				
			case TAKINGBYE:			  /*skips a week, resetting market and matches, runs a random event*/
				break;
				
				
			case STADIUM:			  /*displays matches for player to choose from*/
				break;
				
				
			case PLAYMATCH:			  /*display athlete match-ups*/
				break;
				
				
			case MATCHWIN:			  /*display victory screen if player wins match*/
				break;
				
				
			case MATCHLOSS:			  /*display loss screen if player loses*/
				break;
				
				
			case RESULTSCREEN:		  /*display the overall result as the player has run out of weeks or athletes*/
				break;
				
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
		GameState state = GameState.TITLESCREEN;
		
		while(state != GameState.GAMEFINISH) { /*run until the game is finished*/
			state = game.runCurrentState(state, playerClub, playerMarket, itemMarket);
		}
	}
}
