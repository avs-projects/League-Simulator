package data.match;

/**
 * The Match class provides information about an Basketball match. 
 * Information about the two Basketball teams, score, players, budget.
 */

public class Match {
	
	private MatchTeam teams;
	private MatchScore score;
	private String currentStadium;
	private MatchPlayers players;
	private MatchBudget budget;
		
	public Match() {
		
	}
	
	public Match( MatchTeam teams, MatchScore score, 
			String currentStadium, MatchPlayers players, MatchBudget budget) {
		this.teams = teams;
		this.score = score;
		this.currentStadium = currentStadium;
		this.players = players;
		this.budget = budget;
	}

	public MatchTeam getTeams() {
		return teams;
	}

	public void setTeams(MatchTeam teams) {
		this.teams = teams;
	}

	public MatchScore getScore() {
		return score;
	}

	public void setScore(MatchScore score) {
		this.score = score;
	}

	public String getCurrentStadium() {
		return currentStadium;
	}

	public void setCurrentStadium(String currentStadium) {
		this.currentStadium = currentStadium;
	}

	public MatchPlayers getPlayers() {
		return players;
	}

	public void setPlayers(MatchPlayers players) {
		this.players = players;
	}

	public MatchBudget getBudget() {
		return budget;
	}

	public void setBudget(MatchBudget budget) {
		this.budget = budget;
	}
}
