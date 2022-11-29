package data.budget;

import data.budget.permonth.ExpensesPerMonth;

/**
 * This class provides League expenses divided by two sub categories.
 * Salary and logistic.
 */

public class Expenses {

	private Integer salary;
	private Integer logistic;
	private ExpensesPerMonth expensesPerMonth;
	
	public Expenses () {
		salary = 0;
		logistic = 0;
		expensesPerMonth = new ExpensesPerMonth();
	}
	
	public Expenses (Integer salary, Integer logistic, ExpensesPerMonth expensesPerMonth) {
		this.salary = salary;
		this.logistic = logistic;
		this.expensesPerMonth = expensesPerMonth;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getLogistic() {
		return logistic;
	}

	public void setLogistic(Integer logistic) {
		this.logistic = logistic;
	}

	public ExpensesPerMonth getExpensesPerMonth() {
		return expensesPerMonth;
	}

	public void setExpensesPerMonth(ExpensesPerMonth expensesPerMonth) {
		this.expensesPerMonth = expensesPerMonth;
	}

}
