package data.budget.permonth;

import java.util.HashMap;

public class LogisticPerMonth {
	
	private HashMap <String,Integer> stadiumRent;
	private HashMap <String,Integer> travel;
	
	public LogisticPerMonth () {
		stadiumRent = new HashMap <String,Integer>();
		travel = new HashMap <String,Integer>();
	}
	
	public LogisticPerMonth (HashMap <String,Integer> stadiumRent, HashMap <String,Integer> travel) {
		this.stadiumRent = stadiumRent;
		this.travel = travel;
	}

	public HashMap <String,Integer> getStadiumRent() {
		return stadiumRent;
	}

	public void setStadiumRent(HashMap <String,Integer> stadiumRent) {
		this.stadiumRent = stadiumRent;
	}

	public HashMap <String,Integer> getTravel() {
		return travel;
	}

	public void setTravel(HashMap <String,Integer> travel) {
		this.travel = travel;
	}

}
