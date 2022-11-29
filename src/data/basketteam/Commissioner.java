package data.basketteam;

/**
 * The Commissioner class handles information about the league budget.
 */

public class Commissioner {
	
	private double luxuryTax;
	
	private long tvRight;
	
	private long budget;
	
	public Commissioner() {
		luxuryTax = 0;
		tvRight = 0;
		budget = 0;
	}
	
	public Commissioner(double luxuryTax, long tvRight, long budget) {
		this.luxuryTax = luxuryTax;
		this.tvRight = tvRight;
		this.budget = budget;
	}

	public double getLuxuryTax() {
		return luxuryTax;
	}

	public void setLuxuryTax(double luxuryTax) {
		this.luxuryTax = luxuryTax;
	}

	public long getTvRight() {
		return tvRight;
	}

	public void setTvRight(long tvRight) {
		this.tvRight = tvRight;
	}

	public long getBudget() {
		return budget;
	}

	public void setBudget(long budget) {
		this.budget = budget;
	}

}
