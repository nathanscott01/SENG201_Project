package Main;
import java.util.ArrayList;
import java.util.List;

/**
 * Club Class extends the methods in GameEnviroment and controls the team and reserve lists.
 * The Club Class implements methods which swap athletes on and off the team, and in and out of
 * the reserves, as well as displaying who can and can't play in matches
 *
 * @author Dominic Dumble, Nathan Scott
 *
 */

public class Club extends GameEnvironment {
	private String clubName;				// Name of the club
	private List<Athlete> team;				// List of athletes playing in the team
	private List<Athlete> reserve;			// List of athletes in the reserves
	
	/**
	 * This function initialises the Club by setting up the team and reserve lists
	 */
	public Club() {
		team = new ArrayList<Athlete>();
		reserve = new ArrayList<Athlete>();
	}
	
	/*Getters and setters*/
	
	/**
	 * This function retrieves the name of the Club
	 * @return clubName
	 */
	public String getName() {
		return clubName;
	}
	
	/**
	 * Sets the name of the club
	 * @param newName is the name to assign to the Club
	 * @return void
	 */
	public void setName(String newName) {
		clubName = newName;
	}
	
	/**
	 * This function retrieves the list of the athletes in the team
	 * @return team
	 */
	public List<Athlete> getTeam(){
		return team;
	}
	
	/**
	 * This function retrieves the list of athletes in the reserves
	 * @return reserve
	 */
	public List<Athlete> getReserve(){
		return reserve;
	}
	
	/**
	 * This function returns the number of athletes assigned to the respective position
	 * on the team
	 * 
	 * @param position is the specified position in the format 1:Forward, 2:Mid, 3:Defense
	 * @return retNum
	 */
	public int getNumPosition(int position) {
		int retNum=0;
		if (position == 4) {
			for (Athlete athlete : reserve) {
				retNum+=1;
			}
		} else {
			for (Athlete athlete : team) {
				if (athlete.getPosition()==position) {
					retNum+=1;
				}
			}
		}
		return retNum;
	}
	
	/**
	 * This function adds the given athlete to the team
	 * 
	 * @param athlete to add to team
	 * @return void
	 */
	public void addAthlete(Athlete athlete) {
		if (athlete.getPosition()==4) {
			reserve.add(athlete);
		} else {
			team.add(athlete);
		}
	}
	
	
	/**
	 * This function removes the athlete from the team
	 * 
	 * @param athlete is the respective athlete to remove
	 * @return void
	 */
	public void teamRemoveAthlete(Athlete athlete) {
		team.remove(athlete);
	}
	
	/**
	 * This function removes the respective athlete from the reserves
	 * 
	 * @param athlete is the respective athlete to remove
	 * @return void
	 */
	public void reserveRemoveAthlete(Athlete athlete) {
		reserve.remove(athlete);
	}
	
	/**
	 * This function checks if the team is full or not
	 * 
	 * @return teamFull
	 */
	public Boolean checkTeamFull() {   /*Checks if the team is full*/
		Boolean teamFull = false;
		if (getNumPosition(1)==2 & getNumPosition(2)==3 & getNumPosition(3)==2) {
			teamFull = true;
		}
		return teamFull;
	}
	
	/**
	 * This function identifies if the reserve list is full or not
	 * 
	 * @return reservesFull
	 */
	public Boolean ReserveFull(){
		Boolean reservesFull = false;
		if (getNumPosition(4)==5) {
			reservesFull = true;
		}
		return reservesFull;
	}
	
	/**
	 * This functions determines if a position is full or not on a team
	 * @param query is the position in question
	 * @return true, false
	 */
	public Boolean checkPositionFull(int query) {
		switch(query) {
		case(1):
			if (getNumPosition(1)==2) {
				return true;
			} else {
				return false;
			}
		case(2):
			if (getNumPosition(2)==3) {
				return true;
			} else {
				return false;
			}
		case(3):
			if (getNumPosition(3)==2) {
				return true;
			} else {
				return false;
			}
		case(4):
			if (getNumPosition(4)==5) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	
	/**
	 * This function prints the athletes in the team in each position,
	 * Forwards, Mid and Defence respectively
	 * 
	 * @returns void
	 */
	public void printTeam() {
		System.out.println("\nForwards:");
		for (Athlete athlete : team) {
			if (athlete.getPosition()==1) {
				System.out.println(athlete);
			}
		}
		System.out.println("\nMid:");
		for (Athlete athlete : team) {
			if (athlete.getPosition()==2) {
				System.out.println(athlete);
			}
		}
		System.out.println("\nDefence:");
		for (Athlete athlete : team) {
			if (athlete.getPosition()==3) {
				System.out.println(athlete);
			}
		}
	}
	
	/**
	 * This function prints the reserves in the team
	 * 
	 * @returns void
	 */
	public void printReserve() {               /*prints reserves*/
		System.out.println("\n\nReserve:");
		for (Athlete athlete : reserve) {
			System.out.println(athlete);
		}
	}
	
	/**
	 * This function returns whether or not a reserve exists and if they have stamina still
	 * 
	 * @param stam will always be passed in as 0. If an athlete has stamina, they can play
	 * @return true, false
	 */
	public Boolean availableReserve(int stam) {
		int playerCount = 0;
		for (Athlete athlete : reserve) {
			if (athlete.getStats()[2]>stam) {
				playerCount+=1;
			}
		}
		if(playerCount>0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This function checks if am athlete's stamina is less than or equal to 0
	 * @return true, false
	 */
	public Boolean cantPlayNow() {
		for (Athlete athlete : team) {
			if (athlete.getStats()[2] <= 0) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This function swaps the position of two athletes
	 * 
	 * @param athlete1 to swap
	 * @param athlete2 to swap
	 * @return void
	 */
	public void positionSwap(Athlete athlete1, Athlete athlete2) {    /*swaps positions of athlete1 and athlete2*/
		int pos_tracker;
		pos_tracker = athlete1.getPosition();
		athlete1.setPosition(athlete2.getPosition());
		athlete2.setPosition(pos_tracker);
		addAthlete(athlete1);
		teamRemoveAthlete(athlete1);
		addAthlete(athlete2);
		reserveRemoveAthlete(athlete2);
	}
}
