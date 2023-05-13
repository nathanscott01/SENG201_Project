
enum GameState {
	TITLESCREEN, GAMESETUP, TEAMSETUP, PLAYERPURCHASE, WEEKLYSELECT, CLUBVIEW, PLAYERCARD, INVENTORY, MARKETSELECT,
	PLAYERMARKET, DRAFTPLAYER, ITEMMARKET, DRAFTITEM, TAKINGBYE, STADIUM, MATCHVIEW, PLAYMATCH, MATCHWIN, MATCHLOSS,
	RESULTSCREEN, GAMEFINISH
}

public class GameEnvironment {
	private int curWeek = 0;
	private int endWeek = 0;
	
	
	/* calling this advances the weeks by one */
	public void advanceWeek() {
		curWeek +=1;
		if (curWeek > endWeek){   /*implement to end the game */
			
		}
	}
	
	public void runCurrentState(GameState state) {
		switch(state) {
			case TITLESCREEN:
				/*do something*/
				break;
			case GAMESETUP:
				/*do something*/
				break;
			case TEAMSETUP:
				/*do something*/
				break;
			case PLAYERPURCHASE:
				/*do something*/
				break;
			case WEEKLYSELECT:
				/*do something*/
				break;
			case CLUBVIEW:
				/*do something*/
				break;
			case PLAYERCARD:
				/*do something*/
				break;
			case INVENTORY:
				/*do something*/
				break;
			case MARKETSELECT:
				/*do something*/
				break;
			case PLAYERMARKET:
				/*do something*/
				break;
			case DRAFTPLAYER:
				/*do something*/
				break;
			case ITEMMARKET:
				/*do something*/
				break;
			case DRAFTITEM:
				/*do something*/
				break;
			case TAKINGBYE:
				/*do something*/
				break;
			case STADIUM:
				/*do something*/
				break;
			case MATCHVIEW:
				/*do something*/
				break;
			case PLAYMATCH:
				/*do something*/
				break;
			case MATCHWIN:
				/*do something*/
				break;
			case MATCHLOSS:
				/*do something*/
				break;
			case RESULTSCREEN:
				/*do something*/
				break;
			case GAMEFINISH:
				/*do something*/
				break;
		}
	}
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		GameState state = GameState.TITLESCREEN;
		
		while(state != GameState.GAMEFINISH) { /*run until the game is finished*/
			game.runCurrentState(state);
		}
	}
}
