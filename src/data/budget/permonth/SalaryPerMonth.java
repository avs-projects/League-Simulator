package data.budget.permonth;

import java.util.HashMap;

public class SalaryPerMonth {
	
	private HashMap <String,Integer> playersSalary;
	private HashMap <String,Integer> coachSalary;
	
	public SalaryPerMonth () {
		playersSalary = new HashMap <String,Integer>();
		coachSalary = new HashMap <String,Integer>();
	}
	
	public SalaryPerMonth (HashMap <String,Integer> playersSalary, HashMap <String,Integer> coachSalary) {
		this.playersSalary = playersSalary;
		this.coachSalary =coachSalary;
	}

	public HashMap<String, Integer> getPlayersSalary() {
		return playersSalary;
	}

	public void setPlayersSalary(HashMap<String, Integer> playersSalary) {
		this.playersSalary = playersSalary;
	}

	public HashMap<String, Integer> getCoachSalary() {
		return coachSalary;
	}

	public void setCoachSalary(HashMap<String, Integer> coachSalary) {
		this.coachSalary = coachSalary;
	}

}
