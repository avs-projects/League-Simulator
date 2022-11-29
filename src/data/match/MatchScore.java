package data.match;

import java.util.HashMap;

import data.player.Player;

public class MatchScore {
	
	private Integer homeTScore;
	private Integer awayTScore;
	private QuarterTime quarterTimeHome;
	private QuarterTime quarterTimeAway;
	private MatchStats homeStats;
	private MatchStats awayStats;
	private HashMap<Player, Integer> homeScorers;
	private HashMap<Player, Integer> awayScorers;
	private HashMap<Player, Integer> homeAssists;
	private HashMap<Player, Integer> awayAssists;

	public MatchScore() {
		homeTScore = 0;
		awayTScore = 0;
		quarterTimeHome = new QuarterTime();
		quarterTimeAway = new QuarterTime();
		homeStats = new MatchStats();
		awayStats = new MatchStats();
		homeScorers = new HashMap<>();
		awayScorers = new HashMap<>();
		homeAssists = new HashMap<>();
		awayAssists = new HashMap<>();

	}
	
	public MatchScore(Integer homeTScore, Integer awayTScore, 
			QuarterTime quarterTimeHome, QuarterTime quarterTimeAway, MatchStats homeStats, MatchStats awayStats,
			HashMap<Player, Integer> homeScorers, HashMap<Player, Integer> awayScorers, HashMap<Player, Integer> homeAssists,
			HashMap<Player, Integer> awayAssists) {
		this.homeTScore = homeTScore;
		this.awayTScore = awayTScore;
		this.quarterTimeHome = quarterTimeHome;
		this.quarterTimeAway = quarterTimeAway;
		this.homeStats = homeStats;
		this.awayStats = awayStats;
		this.homeScorers = homeScorers;
		this.awayScorers = awayScorers;
		this.homeAssists = homeAssists;
		this.awayAssists = awayAssists;
	}

	public Integer getHomeTScore() {
		return homeTScore;
	}

	public void setHomeTScore(Integer homeTScore) {
		this.homeTScore = homeTScore;
	}

	public Integer getAwayTScore() {
		return awayTScore;
	}

	public void setAwayTScore(Integer awayTScore) {
		this.awayTScore = awayTScore;
	}

	public QuarterTime getQuarterTimeHome() {
		return quarterTimeHome;
	}

	public void setQuarterTimeHome(QuarterTime quarterTimeHome) {
		this.quarterTimeHome = quarterTimeHome;
	}

	public QuarterTime getQuarterTimeAway() {
		return quarterTimeAway;
	}

	public void setQuarterTimeAway(QuarterTime quarterTimeAway) {
		this.quarterTimeAway = quarterTimeAway;
	}

	public MatchStats getHomeStats() {
		return homeStats;
	}

	public void setHomeStats(MatchStats homeStats) {
		this.homeStats = homeStats;
	}

	public MatchStats getAwayStats() {
		return awayStats;
	}

	public void setAwayStats(MatchStats awayStats) {
		this.awayStats = awayStats;
	}

	public HashMap<Player, Integer> getHomeScorers() {
		return homeScorers;
	}

	public void setHomeScorers(HashMap<Player, Integer> homeScorers) {
		this.homeScorers = homeScorers;
	}

	public HashMap<Player, Integer> getAwayScorers() {
		return awayScorers;
	}

	public void setAwayScorers(HashMap<Player, Integer> awayScorers) {
		this.awayScorers = awayScorers;
	}

	public HashMap<Player, Integer> getHomeAssists() {
		return homeAssists;
	}

	public void setHomeAssists(HashMap<Player, Integer> homeAssists) {
		this.homeAssists = homeAssists;
	}

	public HashMap<Player, Integer> getAwayAssists() {
		return awayAssists;
	}

	public void setAwayAssists(HashMap<Player, Integer> awayAssists) {
		this.awayAssists = awayAssists;
	}

}
