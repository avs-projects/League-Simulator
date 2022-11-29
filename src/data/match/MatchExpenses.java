package data.match;

public class MatchExpenses {
	
	private Integer stadiumRent;
	private Integer travelHome;
	private Integer travelAway;
	
	public MatchExpenses () {
		stadiumRent = 0;
		travelHome = 0;
		travelAway = 0;
	}
	
	public MatchExpenses(Integer stadiumRent, Integer travelHome, Integer travelAway) {
		this.stadiumRent = stadiumRent;
		this.travelHome = travelHome;
		this.travelAway = travelAway;
	}

	public Integer getStadiumRent() {
		return stadiumRent;
	}

	public void setStadiumRent(Integer stadiumRent) {
		this.stadiumRent = stadiumRent;
	}

	public Integer getTravelHome() {
		return travelHome;
	}

	public void setTravelHome(Integer travelHome) {
		this.travelHome = travelHome;
	}

	public Integer getTravelAway() {
		return travelAway;
	}

	public void setTravelAway(Integer travelAway) {
		this.travelAway = travelAway;
	}
}
