package data.calendar;

import java.util.ArrayList;

import data.match.Match;

public class Date {
	
	private Integer number;
	private String day;
	private String month;
	private Integer year;
	private ArrayList <Match> games;
	
	public Date() {
		
	}
	
	public Date (int number, String day, String month, Integer year, ArrayList<Match> games) {
		this.number = number;
		this.day = day;
		this.month = month;
		this.year = year;
		this.games = games;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public ArrayList<Match> getGames() {
		return games;
	}

	public void setGames(ArrayList<Match> games) {
		this.games = games;
	}

}
