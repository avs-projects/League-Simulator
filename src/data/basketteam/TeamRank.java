package data.basketteam;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * The TeamRank class is used to store information about team rank.
 */

public class TeamRank {
	
	private Integer victory;
	private Integer defeat;
	private double percentage;
	private Integer rank;
	private Integer	previousRank ;
	private ArrayList<String> form;
	
	public TeamRank() {
		victory = 0;
		defeat = 0;
		percentage = 0;
		rank = 0;
		previousRank = 0;
		form = new ArrayList<String>();
	}
	
	public TeamRank(Integer victory, Integer defeat, Integer percentage, Integer rank, Integer previousRank, ArrayList<String> form) {
		this.victory = victory;
		this.defeat = defeat;
		this.percentage = percentage;
		this.rank = rank;
		this.previousRank = previousRank;
		this.form = form;
	}
	
	public Integer getVictory() {
		return victory;
	}

	public void setVictory(Integer victory) {
		this.victory = victory;
	}

	public Integer getDefeat() {
		return defeat;
	}

	public void setDefeat(Integer defeat) {
		this.defeat = defeat;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getPreviousRank() {
		return previousRank;
	}

	public void setPreviousRank(Integer previousRank) {
		this.previousRank = previousRank;
	}

	public ArrayList<String> getForm() {
		return form;
	}

	public void setForm(ArrayList<String> form) {
		this.form = form;
	}
	
	public String WriteDouble(double percentage) {
		DecimalFormat f = new DecimalFormat();
		f.setMaximumFractionDigits(2);
		return f.format(percentage);
		
	}
	
}