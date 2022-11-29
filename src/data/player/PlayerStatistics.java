package data.player;

public class PlayerStatistics {
	
	private int basketScored;
	
	private int assists;
	
	public PlayerStatistics() {
		basketScored = 0;
		assists = 0;
	}

	public PlayerStatistics(int basketScored, int assists) {
		this.basketScored = basketScored;
		this.assists = assists;
	}

	public int getBasketScored() {
		return basketScored;
	}

	public void setBasketScored(int basketScored) {
		this.basketScored = basketScored;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

}
