package data.match;

/**
 * Provides the match earnings and expenses.
 */

public class MatchBudget {
	
	private MatchEarnings earnings;
	
	private MatchExpenses expenses;
	
	public MatchBudget () {
		earnings = new MatchEarnings();
		expenses = new MatchExpenses();
	}
	
	public MatchBudget (MatchEarnings earnings, MatchExpenses expenses) {
		this.expenses = expenses;
	}

	public MatchEarnings getEarnings() {
		return earnings;
	}

	public void setEarnings(MatchEarnings earnings) {
		this.earnings = earnings;
	}

	public MatchExpenses getExpenses() {
		return expenses;
	}

	public void setExpenses(MatchExpenses expenses) {
		this.expenses = expenses;
	}
	
	

}
