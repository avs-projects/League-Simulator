package data.match;

import java.util.ArrayList;

import data.player.Player;

public class MatchPlayers {
	
	private ArrayList<Player> homePlayers;
	private ArrayList<Player> homeSubPlayers;
	private ArrayList<Player> awayPlayers;
	private ArrayList<Player> awaySubPlayers;
			
	public MatchPlayers () {
		homePlayers = new ArrayList<Player>();
		homeSubPlayers = new ArrayList<Player>();
		awayPlayers = new ArrayList<Player>();
		awaySubPlayers = new ArrayList<Player>();
	}
	
	public MatchPlayers (ArrayList<Player> homePlayers, ArrayList<Player> homeSubPlayers, 
			ArrayList<Player> awayPlayers,  ArrayList<Player> awaySubPlayers) {
		this.homePlayers = homePlayers;
		this.homeSubPlayers = homeSubPlayers;
		this.awayPlayers = awayPlayers;
		this.awaySubPlayers = awaySubPlayers;
	}

	public ArrayList<Player> getHomePlayers() {
		return homePlayers;
	}

	public void setHomePlayers(ArrayList<Player> homePlayers) {
		this.homePlayers = homePlayers;
	}

	public ArrayList<Player> getHomeSubPlayers() {
		return homeSubPlayers;
	}

	public void setHomeSubPlayers(ArrayList<Player> homeSubPlayers) {
		this.homeSubPlayers = homeSubPlayers;
	}

	public ArrayList<Player> getAwayPlayers() {
		return awayPlayers;
	}

	public void setAwayPlayers(ArrayList<Player> awayPlayers) {
		this.awayPlayers = awayPlayers;
	}

	public ArrayList<Player> getAwaySubPlayers() {
		return awaySubPlayers;
	}

	public void setAwaySubPlayers(ArrayList<Player> awaySubPlayers) {
		this.awaySubPlayers = awaySubPlayers;
	}
}
