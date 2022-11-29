package data.player;

public class PlayerRank {
	
	private Player playersPoints[];
	private Player playersAssists[];
	
	public PlayerRank() {
		playersPoints = new Player[300];
		playersAssists = new Player[300];
	}
	
	public PlayerRank(Player playersPoints[], Player playersAssists[]) {
		this.playersPoints = playersPoints;
		this.playersAssists = playersAssists;
	}

	public Player[] getPlayersPoints() {
		return playersPoints;
	}

	public void setPlayersPoints(Player[] playersPoints) {
		this.playersPoints = playersPoints;
	}

	public Player[] getPlayersAssists() {
		return playersAssists;
	}

	public void setPlayersAssists(Player[] playersAssists) {
		this.playersAssists = playersAssists;
	}
	
}
