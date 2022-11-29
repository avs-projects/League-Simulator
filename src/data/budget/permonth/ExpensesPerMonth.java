package data.budget.permonth;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Describe the expenses month per month.
 */

public class ExpensesPerMonth {
	
	private HashMap <String,ArrayList<Integer>> salaryPerMonth;
	private HashMap <String,ArrayList<Integer>> logisticPerMonth;
	private LogisticPerMonth lpm;
	private SalaryPerMonth spm;

		
	public ExpensesPerMonth() {
		salaryPerMonth = new HashMap <String,ArrayList<Integer>>();
		logisticPerMonth = new HashMap <String,ArrayList<Integer>>();
		lpm = new LogisticPerMonth();
		spm = new SalaryPerMonth();
	}
	
	public ExpensesPerMonth(HashMap <String,ArrayList<Integer>> salaryPerMonth,
			HashMap <String,ArrayList<Integer>> logisticPerMonth,
			LogisticPerMonth lpm, SalaryPerMonth sbm) {
		this.salaryPerMonth = salaryPerMonth;
		this.logisticPerMonth = logisticPerMonth;
		this.lpm = lpm;
		this.spm = sbm;
	}

	public HashMap<String, ArrayList<Integer>> getSalaryPerMonth() {
		return salaryPerMonth;
	}

	public void setSalaryPerMonth(HashMap<String, ArrayList<Integer>> salaryPerMonth) {
		this.salaryPerMonth = salaryPerMonth;
	}

	public HashMap<String, ArrayList<Integer>> getLogisticPerMonth() {
		return logisticPerMonth;
	}

	public void setLogisticPerMonth(HashMap<String, ArrayList<Integer>> logisticPerMonth) {
		this.logisticPerMonth = logisticPerMonth;
	}

	public LogisticPerMonth getLpm() {
		return lpm;
	}

	public void setLpm(LogisticPerMonth lpm) {
		this.lpm = lpm;
	}

	public SalaryPerMonth getSpm() {
		return spm;
	}

	public void setSpm(SalaryPerMonth spm) {
		this.spm = spm;
	}

}
