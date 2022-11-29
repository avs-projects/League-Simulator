package data.budget;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The Budget class is used to store all League earnings and expenses.
 */

public class Budget {
	
	private Integer budget;
	private Earnings earnings;	
	private Expenses expenses;
	
	public Budget () {
		budget = 0;
		earnings = new Earnings();
		expenses = new Expenses();
	}
	
	public Budget (Integer budget, Earnings earnings, Expenses expenses) {
		this.budget = budget;
		this.earnings = earnings;
		this.expenses = expenses;
	}

	public Integer getBudget() {
		return budget;
	}

	public void setBudget(Integer budget) {
		this.budget = budget;
	}

	public Earnings getEarnings() {
		return earnings;
	}

	public void setEarnings(Earnings earnings) {
		this.earnings = earnings;
	}

	public Expenses getExpenses() {
		return expenses;
	}

	public void setExpenses(Expenses expenses) {
		this.expenses = expenses;
	}

	public void initBudget(String month) {
		
		this.getEarnings().getEarningsPerMonth().getSeatSellingPerMonth().put(month, new ArrayList<Integer>());
		this.getEarnings().getEarningsPerMonth().getSeatSellingPerMonth().get(month).add(0);
		this.getEarnings().getEarningsPerMonth().getTvRightPerMonth().put(month, new ArrayList<Integer>());
		this.getEarnings().getEarningsPerMonth().getTvRightPerMonth().get(month).add(0);
		
		this.getExpenses().getExpensesPerMonth().getLogisticPerMonth().put(month, new ArrayList<Integer>());
		this.getExpenses().getExpensesPerMonth().getLogisticPerMonth().get(month).add(0);
		this.getExpenses().getExpensesPerMonth().getSalaryPerMonth().put(month, new ArrayList<Integer>());
		this.getExpenses().getExpensesPerMonth().getSalaryPerMonth().get(month).add(0);
		
		this.getExpenses().getExpensesPerMonth().getLpm().getStadiumRent().put(month, 0);
		this.getExpenses().getExpensesPerMonth().getLpm().getTravel().put(month, 0);
		this.getExpenses().getExpensesPerMonth().getSpm().getCoachSalary().put(month, 0);
		this.getExpenses().getExpensesPerMonth().getSpm().getPlayersSalary().put(month, 0);
		
	}
	
	public void add(String month,Integer value, HashMap <String,ArrayList<Integer>> map) {
		map.get(month).add(value);
	}

}