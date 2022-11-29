package data.basketteam;

/**
 * The TeamLocation class provides information about a team location.
 * Information about its conference, division, and stadium are stored.
 */

public class TeamLocation {
	
	private String location;
	private String conference;
	private String division;
	private TeamStadium stadium;
	
	public TeamLocation() {
		
	}
	
	public TeamLocation(String location, String conference, String division, TeamStadium stadium) {
		this.location = location;
		this.conference = conference;
		this.division = division;
		this.stadium = stadium;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getConference() {
		return conference;
	}

	public void setConference(String conference) {
		this.conference = conference;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public TeamStadium getStadium() {
		return stadium;
	}

	public void setStadium(TeamStadium stadium) {
		this.stadium = stadium;
	}

}
