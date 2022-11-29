package data.basketteam;

/**
 * The TeamRanking class is used to store League ranking.
 * The ranking is divided in two parts.
 */

public class TeamRanking {
	
	private BasketballTeam easternConference [];
	private BasketballTeam westernConference [];
	
	public TeamRanking() {
		easternConference = new BasketballTeam[15];
		westernConference = new BasketballTeam[15];
	}
	
	public TeamRanking(BasketballTeam easternConference[], BasketballTeam westernConference[]) {
		this.easternConference = easternConference;
		this.westernConference = westernConference;
	}

	public BasketballTeam[] getEasternConference() {
		return easternConference;
	}

	public void setEasternConference(BasketballTeam[] easternConference) {
		this.easternConference = easternConference;
	}

	public BasketballTeam[] getWesternConference() {
		return westernConference;
	}

	public void setWesternConference(BasketballTeam[] westernConference) {
		this.westernConference = westernConference;
	}

}
