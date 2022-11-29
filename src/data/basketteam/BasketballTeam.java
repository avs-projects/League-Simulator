package data.basketteam;

import java.util.ArrayList;

import data.budget.Budget;
import data.player.Player;

/**
 * The BasketballTeam class provides information about a basketball team.
 */

public class BasketballTeam {
	
	private Integer id;
	private String name;
	private TeamLocation location;
	private TeamRank rank;
	private String nickname;
	private Budget budget;
	private Integer stat;
	private ArrayList<Player> squad = new ArrayList<Player>();;
	private TeamCoach coach;
	
	public BasketballTeam() {
		
	}
	
	public BasketballTeam(Integer id, String name, TeamLocation location, TeamRank rank, String nickname,
			Budget budget, TeamCoach coach) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.rank = rank;
		this.nickname = nickname;
		this.budget = budget;
		this.coach = coach;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TeamLocation getLocation() {
		return location;
	}

	public void setLocation(TeamLocation location) {
		this.location = location;
	}

	public TeamRank getRank() {
		return rank;
	}

	public void setRank(TeamRank rank) {
		this.rank = rank;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}

	public Integer getStat() {
		return stat;
	}

	public void setStat(Integer stat) {
		this.stat = stat;
	}

	public ArrayList<Player> getSquad() {
		return squad;
	}

	public void setSquad(ArrayList<Player> squad) {
		this.squad = squad;
	}

	public TeamCoach getCoach() {
		return coach;
	}

	public void setCoach(TeamCoach coach) {
		this.coach = coach;
	}
	
	public void add(Player player) {
		this.squad.add(player);
	}
	
	public void calculateStat() {
		int stat = 0;
		for (Player player : squad) {
			stat += player.getOverallRating();
		}
		this.stat = stat/(squad.size());
	}	
	
	
}
