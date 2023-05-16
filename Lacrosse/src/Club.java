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
	
	public int getNumPosition(int position) {
		int retNum=0;
		for (Athlete athlete : team) {
			if (athlete.getPosition()==position) {
				retNum+=1;
			}
		}
		return retNum;
	}
	
	public void addAthlete(Athlete athlete) {
		team.add(athlete);
	}
}
