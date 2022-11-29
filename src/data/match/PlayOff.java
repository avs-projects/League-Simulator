package data.match;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import data.basketteam.BasketballTeam;

/**
 * Describes all Playoff phases.
 */

public class PlayOff {
	
	private ArrayList<BasketballTeam> firstRound;
	private ArrayList<BasketballTeam> semiFinal;
	private ArrayList<BasketballTeam> finalConference;
	private ArrayList<BasketballTeam> finalNBA;
	
	private LinkedHashMap<String,Match> playOffCounter = new LinkedHashMap<String,Match>();
	
	public PlayOff() {
		firstRound = new ArrayList<BasketballTeam>();
		semiFinal = new ArrayList<BasketballTeam>();
		finalConference = new ArrayList<BasketballTeam>();
		finalNBA = new ArrayList<BasketballTeam>();
		playOffCounter = new LinkedHashMap<String,Match>();
	}
	
	public PlayOff(ArrayList<BasketballTeam> firstRound,ArrayList<BasketballTeam> semiFinal,
			ArrayList<BasketballTeam> finalConference,ArrayList<BasketballTeam> finalNBA,LinkedHashMap<String,Match>
	playOffCounter) {
		this.firstRound = firstRound;
		this.semiFinal = semiFinal;
		this.finalConference = finalConference;
		this.finalNBA = finalNBA;
		this.playOffCounter = playOffCounter;
	}

	public ArrayList<BasketballTeam> getFirstRound() {
		return firstRound;
	}

	public void setFirstRound(ArrayList<BasketballTeam> firstRound) {
		this.firstRound = firstRound;
	}

	public ArrayList<BasketballTeam> getSemiFinal() {
		return semiFinal;
	}

	public void setSemiFinal(ArrayList<BasketballTeam> semiFinal) {
		this.semiFinal = semiFinal;
	}

	public ArrayList<BasketballTeam> getFinalConference() {
		return finalConference;
	}

	public void setFinalConference(ArrayList<BasketballTeam> finalConference) {
		this.finalConference = finalConference;
	}

	public ArrayList<BasketballTeam> getFinalNBA() {
		return finalNBA;
	}

	public void setFinalNBA(ArrayList<BasketballTeam> finalNBA) {
		this.finalNBA = finalNBA;
	}

	public LinkedHashMap<String, Match> getPlayOffCounter() {
		return playOffCounter;
	}

	public void setPlayOffCounter(LinkedHashMap<String, Match> playOffCounter) {
		this.playOffCounter = playOffCounter;
	}
	
}
