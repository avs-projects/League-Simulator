package data.match;

public class MatchStats {
	
	private Integer threePoint;
	private Integer twoPoint;
	private Integer freeThrow;

	public MatchStats() {
		threePoint = 0;
		twoPoint = 0;
		freeThrow = 0;
	}
	
	public MatchStats(Integer threePoint, Integer twoPoint, Integer freeThrow) {
		this.threePoint = threePoint;
		this.twoPoint = twoPoint;
		this.freeThrow = freeThrow;
	}

	public Integer getThreePoint() {
		return threePoint;
	}

	public void setThreePoint(Integer threePoint) {
		this.threePoint = threePoint;
	}

	public Integer getTwoPoint() {
		return twoPoint;
	}

	public void setTwoPoint(Integer twoPoint) {
		this.twoPoint = twoPoint;
	}

	public Integer getFreeThrow() {
		return freeThrow;
	}

	public void setFreeThrow(Integer freeThrow) {
		this.freeThrow = freeThrow;
	}

}
