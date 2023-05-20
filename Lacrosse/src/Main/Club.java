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
	
	public void teamAddAthlete(Athlete athlete) {      	/*Adds given athlete to the Club Team*/
		team.add(athlete);
	}
	
	public void teamRemoveAthlete(Athlete athlete) {    /*Removes given athlete from the Club Team*/
		team.remove(athlete);
	}
	
	public Boolean checkTeamFull(Club club) {   /*Checks if the team is full*/
		if (club.getNumPosition(1)==2 & club.getNumPosition(2)==3 & club.getNumPosition(3)==2) {
			return true;
		}
		return false;
	}
	
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
	
	public void printReserve() {
		System.out.println("\n\nReserve:");
		for (Athlete athlete : reserve) {
			System.out.println(athlete);
		}
	}
	
	public Boolean availableReserve() {
		int playerCount = 0;
		for (Athlete athlete : reserve) {
			if (athlete.getStats()[2]>0) {
				playerCount+=1;
			}
		}
		if(playerCount>0) {
			return true;
		} else {
			return false;
		}
	}
}
