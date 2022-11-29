package process.team;

import java.util.ArrayList;

import dao.DAO;
import data.basketteam.BasketballTeam;
import factory.AbstractDAOFactory;

public class TeamBuilder {
	
	public TeamBuilder() {
		
	}
	
	public static ArrayList<BasketballTeam> setupTeams (AbstractDAOFactory adf) {
		
		DAO<BasketballTeam> TeamDAO = adf.getTeamDAO();
		ArrayList<BasketballTeam> teams = new ArrayList<BasketballTeam> ();
		
		for(int i=1;i<31;i++) {
			BasketballTeam team = TeamDAO.find(i);
			teams.add(team);		
		}
		return teams;
	}
	
}
