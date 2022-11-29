package data.budget.permonth;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Describe the earnings month per month.
 */

public class EarningsPerMonth {
	
	private HashMap <String,ArrayList<Integer>> seatSellingPerMonth;
	private HashMap <String,ArrayList<Integer>> tvRightPerMonth;
	
	public EarningsPerMonth() {
		seatSellingPerMonth =  new HashMap <String,ArrayList<Integer>>();
		tvRightPerMonth =  new HashMap <String,ArrayList<Integer>>();
	}
	
	public EarningsPerMonth(HashMap <String,ArrayList<Integer>> seatSellingPerMonth,
			HashMap <String,ArrayList<Integer>> tvRightPerMonth) {
		this.seatSellingPerMonth = seatSellingPerMonth;
		this.tvRightPerMonth = tvRightPerMonth;
	}

	public HashMap<String, ArrayList<Integer>> getSeatSellingPerMonth() {
		return seatSellingPerMonth;
	}

	public void setSeatSellingPerMonth(HashMap<String, ArrayList<Integer>> seatSellingPerMonth) {
		this.seatSellingPerMonth = seatSellingPerMonth;
	}

	public HashMap<String, ArrayList<Integer>> getTvRightPerMonth() {
		return tvRightPerMonth;
	}

	public void setTvRightPerMonth(HashMap<String, ArrayList<Integer>> tvRightPerMonth) {
		this.tvRightPerMonth = tvRightPerMonth;
	}
	
}
