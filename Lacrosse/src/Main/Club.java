package Main;
import java.util.ArrayList;
import java.util.List;

public class Club extends GameEnvironment {
	private String clubName;
	private List<Athlete> team;
	private List<Athlete> reserve;
	
	public Club() {                        /*Club constructor*/
		team = new ArrayList<Athlete>();
		reserve = new ArrayList<Athlete>();
	}
	
											/*Getters and setters*/
	public String getName() {
		return clubName;
	}
	
	public void setName(String newName) {
		clubName = newName;
	}
	
	public List<Athlete> getTeam(){
		return team;
	}
	
	public List<Athlete> getReserve(){
		return reserve;
	}
	
	public int getNumPosition(int position) {		/*returns the number of players in a specified position
	 												  1:Forward, 2:Mid, 3:Defense*/
		int retNum=0;
		for (Athlete athlete : team) {
			if (athlete.getPosition()==position) {
				retNum+=1;
			}
		}
		return retNum;
	}
	
	public void addAthlete(Athlete athlete) {      	/*Adds given athlete to the Club Team*/
		if (athlete.getPosition()==4) {
			reserve.add(athlete);
		} else {
			team.add(athlete);
		}
	}
	
	public void teamRemoveAthlete(Athlete athlete) {    /*Removes given athlete from the Club Team*/
		team.remove(athlete);
	}
	
	public void reserveRemoveAthlete(Athlete athlete) {    /*Removes given athlete from the Club Team*/
		reserve.remove(athlete);
	}
	
	public Boolean checkTeamFull(Club club) {   /*Checks if the team is full*/
		if (club.getNumPosition(1)==2 & club.getNumPosition(2)==3 & club.getNumPosition(3)==2) {
			return true;
		}
		return false;
	}
	
	public void printTeam() {					/*prints team*/
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
	
	public void printReserve() {               /*prints reserves*/
		System.out.println("\n\nReserve:");
		for (Athlete athlete : reserve) {
			System.out.println(athlete);
		}
	}
	
	public Boolean availableReserve(int stam) {   /*returns true if a reserve exists and they have stamina*/
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
