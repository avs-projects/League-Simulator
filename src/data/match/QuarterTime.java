package data.match;

/**
 * Provides more information about the match score with four quarter.
 */

public class QuarterTime {
	
	private Integer firstQT = 0;
	private Integer secondQT = 0;
	private Integer thirdQT = 0;
	private Integer fourthQT = 0;
	
	public QuarterTime() {
		
	}
	
	public QuarterTime(Integer firstQT,
			Integer secondQT, Integer thirdQT, Integer fourthQT) {
		this.firstQT = firstQT;
		this.secondQT = secondQT;
		this.thirdQT = thirdQT;
		this.fourthQT = fourthQT;
	}

	public Integer getFirstQT() {
		return firstQT;
	}

	public void setFirstQT(Integer firstQT) {
		this.firstQT = firstQT;
	}

	public Integer getSecondQT() {
		return secondQT;
	}

	public void setSecondQT(Integer secondQT) {
		this.secondQT = secondQT;
	}

	public Integer getThirdQT() {
		return thirdQT;
	}

	public void setThirdQT(Integer thirdQT) {
		this.thirdQT = thirdQT;
	}

	public Integer getFourthQT() {
		return fourthQT;
	}

	public void setFourthQT(Integer fourthQT) {
		this.fourthQT = fourthQT;
	}
}
