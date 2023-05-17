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
	
	public void setSeasonLength() {           	   /*takes input until one can be set as endWeek*/
		Integer playerInput=0;
		while ((playerInput<5) | (playerInput>15)){
			System.out.print("\nhow many weeks will the season last (5-15): ");
			try {
		        playerInput= Integer.parseInt(sc.nextLine());
		    } catch (NumberFormatException e) {
		        System.out.println("Error! Must be an integer between 5 and 15");
		    }
		}
		endWeek = playerInput;
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
				
				setClubName(playerInput, playerClub); //sets Club name
				
				setSeasonLength();         //sets end week
				
				System.out.print("\n\n"+playerClub.getName());
				System.out.println("\n\n"+endWeek);
				return GameState.TEAMSETUP;
				
				
			case TEAMSETUP:           /*Purchase Starting athletes and choosing positions*/
				System.out.print("MADEITHERE\n");
				Athlete newAthlete = new Athlete(123, 12, 12, 12, "john");
				newAthlete.setPosition(1);
				playerClub.teamAddAthlete(newAthlete);
				Athlete newAthlete1 = new Athlete(123, 12, 12, 12, "john");
				newAthlete1.setPosition(1);
				playerClub.teamAddAthlete(newAthlete1);
				Athlete newAthlete2 = new Athlete(123, 12, 12, 12, "john");
				newAthlete2.setPosition(2);
				playerClub.teamAddAthlete(newAthlete2);
				System.out.println(playerClub.getNumPosition(2));
				
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
