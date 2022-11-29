package data.match;

import data.basketteam.BasketballTeam;

public class MatchTeam {
	
	private BasketballTeam homeTeam;
	private BasketballTeam awayTeam;
	
	public MatchTeam() {
		
	}
	
	public MatchTeam (BasketballTeam homeTeam, BasketballTeam awayTeam) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
	}

	public BasketballTeam getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(BasketballTeam homeTeam) {
		this.homeTeam = homeTeam;
	}

	public BasketballTeam getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(BasketballTeam awayTeam) {
		this.awayTeam = awayTeam;
	}
	
}
