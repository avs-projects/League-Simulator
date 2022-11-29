package process.league;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

import data.basketteam.BasketballTeam;
import data.basketteam.Commissioner;
import data.basketteam.TeamRanking;
import data.calendar.Date;
import data.match.Match;
import data.match.PlayOff;
import data.player.Player;
import data.player.PlayerRank;
import factory.AbstractDAOFactory;
import process.season.AllStarEngine;
import process.season.BudgetAnalyse;
import process.season.Calendar;
import process.season.EventBuilder;
import process.season.EventEngine;
import process.season.MatchBuilder;
import process.season.MatchEngine;
import process.season.SeasonBuilder;
import process.team.TeamBuilder;

public class League implements LeagueInterface{
	
	private AbstractDAOFactory factory;
	private ArrayList<BasketballTeam> teams;
	private ArrayList<Date> games;
	private PlayOff playOff;
	private TeamRanking teamsRanking;
	private PlayerRank playersRank;
	private Commissioner commissioner;
	private ArrayList<BasketballTeam> teamLuxuryTax;
	
	private HashMap<String,String> winners;
	
	private Integer luxuryTax = 120000000;
	private String step;
	private Integer currentSeason;
	private Integer nbjourney;
	
	int nb = 0;
	int index = 0;
	
	public League() {

		factory = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		teams = new ArrayList<BasketballTeam>();
		games = new ArrayList<Date>();
		playOff = new PlayOff();
		teamsRanking = new TeamRanking();
		playersRank = new PlayerRank();
		commissioner = new Commissioner();
		teamLuxuryTax = new ArrayList<BasketballTeam>();
		winners = new HashMap<>();
		
		step = "RegularSeason";
		currentSeason = 0;
		nbjourney = 0;
		
		teams = TeamBuilder.setupTeams(factory);
		games = Calendar.createCalendar();
		
		// Initiate all the League need to start.
		
		SeasonBuilder.setupNewSeason(nbjourney,30,games,teams);
		SeasonBuilder.initRanking(teams,teamsRanking.getEasternConference(),teamsRanking.getWesternConference());
		SeasonBuilder.initBudget(teams);
		SeasonBuilder.initSalary(teams);
		SeasonBuilder.initPlayersRanking(teams, playersRank);
		SeasonBuilder.initStat(teams);
	}
	
	// Play a match depending on the event.

	public ArrayList<Match> play() {
		ArrayList <Match> matches = new ArrayList<>();
		
		if(step.equals("Christmas") || step.equals("AllStarGame")) {
			step = "RegularSeason";
		}
		
		else if(step.equals("endSeason") && games.get(nbjourney).getMonth().equals("Octobre")) {
			SeasonBuilder.setupNewSeason(nbjourney/3,30,games,teams);
			SeasonBuilder.draft(teams);
			playersRank = new PlayerRank();
			playOff = new PlayOff();
			teamsRanking = new TeamRanking(); 
			
			commissioner.setTvRight(0);
			
			for(int i=0;i<teams.size();i++) {
				for(int j=0;j<teams.get(i).getSquad().size();j++) {
					teams.get(i).getRank().setForm(new ArrayList<String>());
					teams.get(i).getRank().setPreviousRank(teams.get(i).getRank().getRank());
					teams.get(i).getSquad().get(j).setGamesPlayed(0);
					teams.get(i).getSquad().get(j).getPlayerStatistics().setBasketScored(0);
					teams.get(i).getSquad().get(j).getPlayerStatistics().setAssists(0);
					teams.get(i).getSquad().get(j).setAge(teams.get(i).getSquad().get(j).getAge()+1);
					if(teams.get(i).getSquad().get(j).getAge()>32) {
						teams.get(i).getSquad().get(j).setOverallRating(teams.get(i).getSquad().get(j).getOverallRating()-((int) (Math.random()*3)));
					}
					if(teams.get(i).getSquad().get(j).getAge()<21) {
						teams.get(i).getSquad().get(j).setOverallRating(teams.get(i).getSquad().get(j).getOverallRating()+((int) (Math.random()*3)));
					}
				}
				Collections.sort(teams.get(i).getSquad());
				teams.get(i).getBudget().getEarnings().getTvRight().setViewers(0);

			}
			
			
			SeasonBuilder.initPlayersRanking(teams, playersRank);
			SeasonBuilder.initRanking(teams,teamsRanking.getEasternConference(),teamsRanking.getWesternConference());
			
			step = "RegularSeason";
			currentSeason = 0;
		}
		
		if(games.get(nbjourney).getMonth().equals("Decembre") && games.get(nbjourney).getNumber()==25) {
			EventBuilder.christmasGame(nbjourney, games, teamsRanking);
			step = "Christmas";
		}
		
		if(games.get(nbjourney).getMonth().equals("Fevrier") && games.get(nbjourney).getNumber()==18) {
			EventBuilder.AllStarGame(nbjourney, games, teams,teamsRanking.getEasternConference(),teamsRanking.getWesternConference());
			step = "AllStarGame";
		}
		
		// Initiate the playOff start.
		if (currentSeason==177) {
			EventBuilder.playOff(games, nbjourney, teamsRanking.getEasternConference(),teamsRanking.getWesternConference(),playOff.getPlayOffCounter());
			BudgetAnalyse.payment(teams,commissioner,teamsRanking.getWesternConference(),teamsRanking.getEasternConference());
			nb=nbjourney;
			index = currentSeason;
			step = "FirstRound";
		}
		
		// Allow a team to pass depending on its number of wins.

		else if (currentSeason>177) {
			if(step.equals("FirstRound")) {
				for (int i = 0; i<games.get(nbjourney-1).getGames().size(); i++) {
					if(currentSeason == index+1 || currentSeason==index+2 || currentSeason==index+5 || currentSeason==index+6) {
						if((playOff.getPlayOffCounter().get(games.get(nbjourney-1).getGames().get(i).getTeams().getHomeTeam().getName()+
							games.get(nbjourney-1).getGames().get(i).getTeams().getAwayTeam().getName()).getScore().getHomeTScore()!=4) && 
							playOff.getPlayOffCounter().get(games.get(nbjourney-1).getGames().get(i).getTeams().getHomeTeam().getName()+
									games.get(nbjourney-1).getGames().get(i).getTeams().getAwayTeam().getName()).getScore().getAwayTScore()!=4 &&
								(playOff.getPlayOffCounter().get(games.get(nbjourney-1).getGames().get(i).getTeams().getHomeTeam().getName()+
										games.get(nbjourney-1).getGames().get(i).getTeams().getAwayTeam().getName()).getScore().getHomeTScore()+playOff.getPlayOffCounter().
										get(games.get(nbjourney-1).getGames().get(i).getTeams().getHomeTeam().getName()+
												games.get(nbjourney-1).getGames().get(i).getTeams().getAwayTeam().getName()).getScore().getAwayTScore())>=4) {
							
							EventBuilder.playOffThen(games, nbjourney, games.get(nbjourney-1).getGames().get(i).getTeams().getHomeTeam(),
							games.get(nbjourney-1).getGames().get(i).getTeams().getAwayTeam(),playOff.getPlayOffCounter());
						}
					}
					else {
						if((playOff.getPlayOffCounter().get(games.get(nbjourney-1).getGames().get(i).getTeams().getAwayTeam().getName()+
								games.get(nbjourney-1).getGames().get(i).getTeams().getHomeTeam().getName()).getScore().getHomeTScore()!=4) && 
									playOff.getPlayOffCounter().get(games.get(nbjourney-1).getGames().get(i).getTeams().getAwayTeam().getName()+
											games.get(nbjourney-1).getGames().get(i).getTeams().getHomeTeam().getName()).getScore().getAwayTScore()!=4 &&
										(playOff.getPlayOffCounter().get(games.get(nbjourney-1).getGames().get(i).getTeams().getAwayTeam().getName()+
												games.get(nbjourney-1).getGames().get(i).getTeams().getHomeTeam().getName()).getScore().getHomeTScore()+playOff.getPlayOffCounter().
												get(games.get(nbjourney-1).getGames().get(i).getTeams().getAwayTeam().getName()+
														games.get(nbjourney-1).getGames().get(i).getTeams().getHomeTeam().getName()).getScore().getAwayTScore())>=4) {
							EventBuilder.playOffThen(games, nbjourney, games.get(nbjourney-1).getGames().get(i).getTeams().getAwayTeam(),	
							games.get(nbjourney-1).getGames().get(i).getTeams().getHomeTeam(),playOff.getPlayOffCounter());
						}
					}		
				}
				
				int tmp=0;
				
				for(int j=0;j<playOff.getPlayOffCounter().size();j++) {
					if((playOff.getPlayOffCounter().get(games.get(nb).getGames().get(j).getTeams().getHomeTeam().getName()+
							games.get(nb).getGames().get(j).getTeams().getAwayTeam().getName()).getScore().getHomeTScore()==4) ||
							(playOff.getPlayOffCounter().get(games.get(nb).getGames().get(j).getTeams().getHomeTeam().getName()+
									games.get(nb).getGames().get(j).getTeams().getAwayTeam().getName()).getScore().getAwayTScore()==4)) {
							tmp++;
					}
				}
				
				if(tmp==8) {
					for(int j=0;j<playOff.getPlayOffCounter().size();j++) {
						if((playOff.getPlayOffCounter().get(games.get(nb).getGames().get(j).getTeams().getHomeTeam().getName()+
								games.get(nb).getGames().get(j).getTeams().getAwayTeam().getName()).getScore().getHomeTScore()==4)) {
							playOff.getFirstRound().add(games.get(nb).getGames().get(j).getTeams().getHomeTeam());
						}
						else if((playOff.getPlayOffCounter().get(games.get(nb).getGames().get(j).getTeams().getHomeTeam().getName()+
								games.get(nb).getGames().get(j).getTeams().getAwayTeam().getName()).getScore().getAwayTScore()==4)) {
							playOff.getFirstRound().add(games.get(nb).getGames().get(j).getTeams().getAwayTeam());

						}
					}
					playOff.setPlayOffCounter(new LinkedHashMap<String,Match>());
					EventBuilder.qualify(games, nbjourney, playOff.getFirstRound(), playOff.getPlayOffCounter());
					step = "Semi";
					nb=nbjourney;
					index=currentSeason;
				}
			}
			
			else if(step.equals("Semi")||step.equals("FinaleConference")||step.equals("FinaleNBA")){

				for (int i = 0; i<games.get(nb).getGames().size(); i++) {
					
					if((playOff.getPlayOffCounter().get(games.get(nb).getGames().get(i).getTeams().getHomeTeam().getName()+
							games.get(nb).getGames().get(i).getTeams().getAwayTeam().getName()).getScore().getHomeTScore()!=4) && 
							playOff.getPlayOffCounter().get(games.get(nb).getGames().get(i).getTeams().getHomeTeam().getName()+
									games.get(nb).getGames().get(i).getTeams().getAwayTeam().getName()).getScore().getAwayTScore()!=4 &&
								(playOff.getPlayOffCounter().get(games.get(nb).getGames().get(i).getTeams().getHomeTeam().getName()+
										games.get(nb).getGames().get(i).getTeams().getAwayTeam().getName()).getScore().getHomeTScore()+playOff.getPlayOffCounter().
										get(games.get(nb).getGames().get(i).getTeams().getHomeTeam().getName()+
												games.get(nb).getGames().get(i).getTeams().getAwayTeam().getName()).getScore().getAwayTScore())>=4) {
					EventBuilder.playOffThen(games, nbjourney, games.get(nb).getGames().get(i).getTeams().getHomeTeam(),
							games.get(nb).getGames().get(i).getTeams().getAwayTeam(),playOff.getPlayOffCounter());
				}
			
			}
				int tmp=0;
				
				for(int j=0;j<playOff.getPlayOffCounter().size();j++) {
					if((playOff.getPlayOffCounter().get(games.get(nb).getGames().get(j).getTeams().getHomeTeam().getName()+
							games.get(nb).getGames().get(j).getTeams().getAwayTeam().getName()).getScore().getHomeTScore()==4) ||
							(playOff.getPlayOffCounter().get(games.get(nb).getGames().get(j).getTeams().getHomeTeam().getName()+
									games.get(nb).getGames().get(j).getTeams().getAwayTeam().getName()).getScore().getAwayTScore()==4)) {
							tmp++;
					}
				}
				if(step.equals("Semi")) {
				
				if(tmp==4) {
					for(int j=0;j<playOff.getPlayOffCounter().size();j++) {
						if((playOff.getPlayOffCounter().get(games.get(nb).getGames().get(j).getTeams().getHomeTeam().getName()+
								games.get(nb).getGames().get(j).getTeams().getAwayTeam().getName()).getScore().getHomeTScore()==4)) {
							playOff.getSemiFinal().add(games.get(nb).getGames().get(j).getTeams().getHomeTeam());
						}
						else if((playOff.getPlayOffCounter().get(games.get(nb).getGames().get(j).getTeams().getHomeTeam().getName()+
								games.get(nb).getGames().get(j).getTeams().getAwayTeam().getName()).getScore().getAwayTScore()==4)) {
							playOff.getSemiFinal().add(games.get(nb).getGames().get(j).getTeams().getAwayTeam());

						}
					}
					playOff.setPlayOffCounter(new LinkedHashMap<String,Match>());
					EventBuilder.qualify(games, nbjourney, playOff.getSemiFinal(), playOff.getPlayOffCounter());
					step = "FinaleConference";
					nb=nbjourney;
					index=currentSeason;
				}
		
				}
				if(step.equals("FinaleConference")) {
					if(tmp==2) {
						for(int j=0;j<playOff.getPlayOffCounter().size();j++) {
							if((playOff.getPlayOffCounter().get(games.get(nb).getGames().get(j).getTeams().getHomeTeam().getName()+
									games.get(nb).getGames().get(j).getTeams().getAwayTeam().getName()).getScore().getHomeTScore()==4)) {
								playOff.getFinalConference().add(games.get(nb).getGames().get(j).getTeams().getHomeTeam());
							}
							else if((playOff.getPlayOffCounter().get(games.get(nb).getGames().get(j).getTeams().getHomeTeam().getName()+
									games.get(nb).getGames().get(j).getTeams().getAwayTeam().getName()).getScore().getAwayTScore()==4)) {
								playOff.getFinalConference().add(games.get(nb).getGames().get(j).getTeams().getAwayTeam());

							}
						}
						playOff.setPlayOffCounter(new LinkedHashMap<String,Match>());
						EventBuilder.qualify(games, nbjourney, playOff.getFinalConference(), playOff.getPlayOffCounter());
						step = "FinaleNBA";
						nb=nbjourney;
						index=currentSeason;
					}
				}
				if(step.equals("FinaleNBA")) {
					if(tmp==1) {
						for(int j=0;j<playOff.getPlayOffCounter().size();j++) {
							if((playOff.getPlayOffCounter().get(games.get(nb).getGames().get(j).getTeams().getHomeTeam().getName()+
									games.get(nb).getGames().get(j).getTeams().getAwayTeam().getName()).getScore().getHomeTScore()==4)) {
								playOff.getFinalNBA().add(games.get(nb).getGames().get(j).getTeams().getHomeTeam());
								winners.put("winner"+games.get(nbjourney).getYear(), games.get(nb).getGames().get(j).getTeams().getHomeTeam().getName());
							}
							else if((playOff.getPlayOffCounter().get(games.get(nb).getGames().get(j).getTeams().getHomeTeam().getName()+
									games.get(nb).getGames().get(j).getTeams().getAwayTeam().getName()).getScore().getAwayTScore()==4)) {
								playOff.getFinalNBA().add(games.get(nb).getGames().get(j).getTeams().getAwayTeam());
								winners.put("winner"+games.get(nbjourney).getYear(), games.get(nb).getGames().get(j).getTeams().getAwayTeam().getName());

							}
						}
						playOff.setPlayOffCounter(new LinkedHashMap<String,Match>());
						step = "endSeason";
						winners.put("best scorer"+games.get(nbjourney).getYear(), playersRank.getPlayersPoints()[0].getName() +" "+
								playersRank.getPlayersPoints()[0].getPlayerStatistics().getBasketScored());
						winners.put("best setter"+games.get(nbjourney).getYear(), playersRank.getPlayersAssists()[0].getName() +" "+
								playersRank.getPlayersAssists()[0].getPlayerStatistics().getAssists());
					}
				}
			}	
		}
		
		//Play a match with all earnings and expenses.
		
		if(!step.equals("endSeason")) {
			for (int i = 0; i<games.get(nbjourney).getGames().size(); i++) {
				
				MatchBuilder.getPlayersMatch(games.get(nbjourney).getGames().get(i));
			
				if (currentSeason>=177) {
					BudgetAnalyse.seatSellingEvent(nbjourney, games.get(nbjourney).getGames().get(i), games,step,commissioner);
					BudgetAnalyse.expensesEvent(nbjourney, games.get(nbjourney).getGames().get(i), games,step);
					BudgetAnalyse.tvRightEvent(step,nbjourney, games.get(nbjourney).getGames().get(i), games, commissioner);
					matches.add(MatchEngine.simulatePlayOff(games.get(nbjourney).getGames().get(i)));
					MatchEngine.counter(games.get(nbjourney).getGames().get(i), playOff.getPlayOffCounter(),index,currentSeason);
				
				}
				else if(step.equals("RegularSeason")){
					BudgetAnalyse.seatSelling(nbjourney, games.get(nbjourney).getGames().get(i), games);
					BudgetAnalyse.expenses(nbjourney, games.get(nbjourney).getGames().get(i), games,step);
					BudgetAnalyse.tvRight(nbjourney, games.get(nbjourney).getGames().get(i), games, commissioner);
					SeasonBuilder.triBulleDecroissant(teamsRanking.getEasternConference());
					SeasonBuilder.triBulleDecroissant(teamsRanking.getWesternConference());
					matches.add(MatchEngine.playRegularMatch(games.get(nbjourney).getGames().get(i)));
			
				}
				else if(step.equals("Christmas")) {
					BudgetAnalyse.seatSellingEvent(nbjourney, games.get(nbjourney).getGames().get(i), games, step, commissioner);
					BudgetAnalyse.expensesEvent(nbjourney, games.get(nbjourney).getGames().get(i), games,step);
					BudgetAnalyse.tvRightEvent(step,nbjourney, games.get(nbjourney).getGames().get(i), games, commissioner);
					matches.add(EventEngine.simulateMatch(games.get(nbjourney).getGames().get(i)));	
				}
				else if(step.equals("AllStarGame")) {
					BudgetAnalyse.seatSellingEvent(nbjourney, games.get(nbjourney).getGames().get(i), games, step,commissioner);
					BudgetAnalyse.expensesEvent(nbjourney, games.get(nbjourney).getGames().get(i), games,step);
					BudgetAnalyse.tvRightEvent(step,nbjourney, games.get(nbjourney).getGames().get(i), games, commissioner);
					matches.add(AllStarEngine.simulateMatch(games.get(nbjourney).getGames().get(i)));	
				}
				
				triBulleDecroissantPoints(playersRank.getPlayersPoints());
				triBulleDecroissantAssists(playersRank.getPlayersAssists());
			}
		}
		
		if(games.get(nbjourney).getNumber()==1) {
			BudgetAnalyse.payday(teams, nbjourney, games, luxuryTax, commissioner, teamLuxuryTax);
		}
		
		currentSeason++;
		nbjourney++;

		return matches;
	}
	
	public HashMap<String,String> getWinners() {
		return winners;
	}
	public Commissioner getCommissioner() {
		return commissioner;
	}
	
	public PlayerRank getPlayersRank() {
		return playersRank;
	}
	
	public int getNbJourney() {
		return nbjourney;
	}
	
	public ArrayList <Date> getGames() {
		return games;
	}
	
	public ArrayList<BasketballTeam> getTeamList() {
		return teams;
	}
	
	public String getDate(int i) {
		return games.get(nbjourney-i).getDay().substring(0,3).toUpperCase()+". "+games.get(nbjourney-i).getNumber()+" "+games.get(nbjourney-i).getMonth().substring(0,3).toUpperCase();
	}
	
	public TeamRanking getTeamsRanking() {
		return teamsRanking;
	}
	
	public int getCurrentSeason() {
		return currentSeason;
	}
	
	public PlayOff getPlayOff() {
		return playOff;
	}
	
	public String getStep() {
		return step;
	}

	public BasketballTeam getTeam(String name) {
		BasketballTeam result = null;
		for(BasketballTeam team : teams) {
			if(team.getName().equals(name)) {
				result = team;
			}
		}
		return result;
	}
	
	public void triBulleDecroissantPoints(Player tableau[]) {
		int longueur = tableau.length;
		Player tampon = null;
		boolean permut;
 
		do {
			permut = false;
			for (int i = 0; i < longueur - 1; i++) {
				float div=tableau[i].getPlayerStatistics().getBasketScored();
				float div2= tableau[i + 1].getPlayerStatistics().getBasketScored();
				
				if(tableau[i].getGamesPlayed()!=0) {
					div=(float)tableau[i].getPlayerStatistics().getBasketScored()/tableau[i].getGamesPlayed();
				}
				if(tableau[i+1].getGamesPlayed()!=0) {
					div2=(float)tableau[i+1].getPlayerStatistics().getBasketScored()/tableau[i+1].getGamesPlayed();
				}
					
				
				if (div<div2) {
					tampon = tableau[i];
					tableau[i] = tableau[i + 1];
					tableau[i + 1] = tampon;
					permut = true;
				}
			}
		} while (permut);
	}
	
	public void triBulleDecroissantAssists(Player tableau[]) {
		int longueur = tableau.length;
		Player tampon = null;
		boolean permut;
 
		do {
			permut = false;
			for (int i = 0; i < longueur - 1; i++) {
				float div=tableau[i].getPlayerStatistics().getAssists();
				float div2= tableau[i + 1].getPlayerStatistics().getAssists();
				
				if(tableau[i].getGamesPlayed()!=0) {
					div=(float)tableau[i].getPlayerStatistics().getAssists()/tableau[i].getGamesPlayed();
				}
				if(tableau[i+1].getGamesPlayed()!=0) {
					div2=(float)tableau[i+1].getPlayerStatistics().getAssists()/tableau[i+1].getGamesPlayed();
				}
						
				if (div<div2) {
					tampon = tableau[i];
					tableau[i] = tableau[i + 1];
					tableau[i + 1] = tampon;
					permut = true;
				}
			}
		} while (permut);
	}
}
