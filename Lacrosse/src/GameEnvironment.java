import java.util.Scanner;

enum GameState {
	TITLESCREEN, GAMESETUP, TEAMSETUP, PLAYERPURCHASE, WEEKLYSELECT, CLUBVIEW, PLAYERCARD, INVENTORY, MARKETSELECT,
	PLAYERMARKET, DRAFTPLAYER, ITEMMARKET, DRAFTITEM, TAKINGBYE, STADIUM, PLAYMATCH, MATCHWIN, MATCHLOSS,
	RESULTSCREEN, GAMEFINISH
}

public class GameEnvironment {
	private int curWeek = 0;
	private int endWeek = 0;
	Scanner sc = new Scanner(System.in);
	
	/* calling this advances the weeks by one */
	public void advanceWeek() {
		curWeek +=1;
		if (curWeek > endWeek){   /*implement to end the game */
			
		}
	}
	
	public GameState runCurrentState(GameState state, Club playerClub) {
		String playerInput = "";
		
		switch(state) {
			case TITLESCREEN:         /*Display game name until the user inputs anything*/
				System.out.print("LACROSSE\n\nenter anything to start: ");
				playerInput = sc.nextLine();
				return GameState.GAMESETUP;
				
				
			case GAMESETUP:           /*Set up club name, week number, difficulty*/
				System.out.println("Set Up Your Club\n");
				System.out.print("Enter a Club name (3-15 characters): ");
				playerInput = sc.nextLine();
				playerClub.setName(playerInput);
				System.out.print("\n\n"+playerClub.getName());
				return GameState.TEAMSETUP;
				
				
			case TEAMSETUP:           /*Purchase Starting athletes and choosing positions*/
				break;
				
				
			case PLAYERPURCHASE:      /*Screen for purchase and placement confirmation*/
				break;
				
				
			case WEEKLYSELECT:        /*Display options for weekly actions for player to choose*/
				break;
				
				
			case CLUBVIEW:            /*View club properties. club name, athletes and properties, inventory*/
				break;
				
				
			case PLAYERCARD:		  /*displays athlete stats and position, used by the club view*/
				break;
				
				
			case INVENTORY:   		  /*display inventory, shows items and their effect and use on an athlete*/
				break;
				
				
			case MARKETSELECT:        /*Choose the athlete store or the item store*/
				break;
				
				
			case PLAYERMARKET:        /*displays a few athletes 3-5 for purchase and their stats links to player drafting*/
				break;
				
				
			case DRAFTPLAYER:		  /*allows player to draft players and get some money back*/
				break;
				
				
			case ITEMMARKET:		  /*displays a few items 3 or more for purchase and their stats links to item drafting */
				break;
				
				
			case DRAFTITEM:			  /*allows player to draft items and get some money back*/
				break;
				
				
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
				
				
			case GAMEFINISH:
				break;
			default:
				break;
		}
		return GameState.GAMEFINISH;
	}
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		Club playerClub = new Club();
		GameState state = GameState.TITLESCREEN;
		
		while(state != GameState.GAMEFINISH) { /*run until the game is finished*/
			state = game.runCurrentState(state, playerClub);
		}
	}
}
