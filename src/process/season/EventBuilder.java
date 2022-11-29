package process.season;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import data.basketteam.BasketballTeam;
import data.basketteam.TeamRank;
import data.basketteam.TeamRanking;
import data.budget.Budget;
import data.calendar.Date;
import data.match.Match;
import data.match.MatchBudget;
import data.match.MatchPlayers;
import data.match.MatchScore;
import data.match.MatchTeam;
import data.player.Player;

public class EventBuilder {
	
	/**
	 * Create matches for the Christmas day.
	 * 
	 * @param number of days, matches list, teams ranking.
	 */
	
	public static void christmasGame(int nbjourney,ArrayList <Date> games, TeamRanking teamRanking) {
		int random = (int) (Math.random()*2)+3;
		
		ArrayList<BasketballTeam> teamsList = new ArrayList<BasketballTeam>();
		ArrayList<Integer> randomList = new ArrayList<Integer>();

		for(int i=0; i<10; i++) {
			if(i<5) {
				teamsList.add(teamRanking.getWesternConference()[i]);
			}
			else {
				teamsList.add(teamRanking.getEasternConference()[10-i]);
			}
		}
		
		for(int i=0; i<random*2;i++) {
			int random1 = (int) (Math.random()*9);
			while(randomList.contains(random1)) {
				random1 = (int) (Math.random()*9);
			}
			randomList.add(random1);
		}
		
		for(int i=0; i<randomList.size();i=i+2) {
			games.get(nbjourney).getGames().add(new Match(new MatchTeam(teamsList.get(randomList.get(i)),teamsList.get(randomList.get(i+1))), new MatchScore(), teamsList.get(randomList.get(i)).getLocation().getStadium()
					.getName(), new MatchPlayers(), new MatchBudget()));
		}
	}
	
	/**
	 * Create matches for the All Star Game with the best players of the League.
	 * 
	 * @param number of days, matches list, teams list, eastern conference ranking, western conference ranking.
	 */
	
	public static void AllStarGame(int nbjourney,ArrayList <Date> year, ArrayList<BasketballTeam> league, BasketballTeam conferenceEst[], BasketballTeam conferenceOuest[]) {
		
		BasketballTeam allStarTeam1=  new BasketballTeam(31,"",league.get((int)(Math.random()*30)).getLocation(),null,"Team n°1",new Budget(),null);
		allStarTeam1.setRank(new TeamRank (0,0,0,1,0,new ArrayList<String>()));
		allStarTeam1.getBudget().initBudget(year.get(nbjourney).getMonth()+year.get(nbjourney).getYear());
		
		BasketballTeam allStarTeam2=  new BasketballTeam(32,"",league.get((int)(Math.random()*30)).getLocation(),null,"Team n°2",new Budget(),null);
		allStarTeam2.setRank(new TeamRank(0,0,0,1,0,new ArrayList<String>()));
		allStarTeam2.getBudget().initBudget(year.get(nbjourney).getMonth()+year.get(nbjourney).getYear());

		Player[] playersOuest = new Player[30];
		Player[] playersEst = new Player[30];
		
		for(int i=0;i<league.size();i++) {
			Collections.sort(league.get(i).getSquad());
		}
		
		int j = 0;
		
		for(int i=0; i<conferenceEst.length;i++) {
			playersEst[j] = conferenceEst[i].getSquad().get(9);
			playersEst[j+1] = conferenceEst[i].getSquad().get(8);
			j=j+2;
		}
		
		j=0;
		
		for(int i=0; i<conferenceOuest.length;i++) {
			playersOuest[j] = conferenceOuest[i].getSquad().get(9);
			playersOuest[j+1] = conferenceOuest[i].getSquad().get(8);
			j=j+2;
		}
		
		triStats(playersEst);
		triStats(playersOuest);
		
		for(int i=0; i<10;i++) {
			if(i==0) {
				allStarTeam1.add(playersEst[i]);
				allStarTeam2.add(playersOuest[i]);
			}
			else {
				if((int)(Math.random()*2)==0) {
				allStarTeam1.add(playersEst[i]);
				allStarTeam2.add(playersOuest[i]);
				}
				else {
				allStarTeam2.add(playersEst[i]);
				allStarTeam1.add(playersOuest[i]);
				}
			}
		}
		
		allStarTeam1.setName("Team "+allStarTeam1.getSquad().get(0).getName());
		allStarTeam2.setName("Team "+allStarTeam2.getSquad().get(0).getName());

		year.get(nbjourney).getGames().add(new Match(new MatchTeam(allStarTeam1,allStarTeam2), new MatchScore(),null, new MatchPlayers(), new MatchBudget()));
	}
	
	/**
	 * Create matches for the play off.
	 * 
	 * @param Matches list, number of days, eastern conference ranking, western conference ranking, list of games won or lost in play off.
	 */
	
	public static void playOff(ArrayList <Date> games, int nbjourney, BasketballTeam easternConference [], BasketballTeam westernConference [], HashMap<String,Match> counterPlayOff ) {

		for(int j=0; j<2; j++) {
			int var = 7;
			if (j==0) {
				for (int i=0;i<4;i++) {
					counterPlayOff.put(easternConference[i].getName()+easternConference[i+var].getName(),new Match(new MatchTeam(easternConference[i],easternConference[i+var]),new MatchScore(),null,null,null));
					games.get(nbjourney).getGames().add(new Match(new MatchTeam(easternConference[i],easternConference[i+var]),new MatchScore(),easternConference[i].getLocation().getStadium().getName(),new MatchPlayers(),new MatchBudget()));
					games.get(nbjourney+1).getGames().add(new Match(new MatchTeam(easternConference[i],easternConference[i+var]),new MatchScore(),easternConference[i].getLocation().getStadium().getName(),new MatchPlayers(),new MatchBudget()));
					games.get(nbjourney+2).getGames().add(new Match(new MatchTeam(easternConference[i+var],easternConference[i]),new MatchScore(),easternConference[i+var].getLocation().getStadium().getName(),new MatchPlayers(),new MatchBudget()));
					games.get(nbjourney+3).getGames().add(new Match(new MatchTeam(easternConference[i+var],easternConference[i]),new MatchScore(),easternConference[i+var].getLocation().getStadium().getName(),new MatchPlayers(),new MatchBudget()));
					var=var-2;
				}
			}
			else {
				for (int k=0; k<4; k++) {
					counterPlayOff.put(westernConference[k].getName()+westernConference[k+var].getName(),new Match(new MatchTeam(westernConference[k],westernConference[k+var]),new MatchScore(),null,null,null));
					games.get(nbjourney).getGames().add(new Match(new MatchTeam(westernConference[k],westernConference[k+var]),new MatchScore(),westernConference[k].getLocation().getStadium().getName(), new MatchPlayers(),new MatchBudget()));
					games.get(nbjourney+1).getGames().add(new Match(new MatchTeam(westernConference[k],westernConference[k+var]),new MatchScore(),westernConference[k].getLocation().getStadium().getName(), new MatchPlayers(),new MatchBudget()));
					games.get(nbjourney+2).getGames().add(new Match(new MatchTeam(westernConference[k+var],westernConference[k]),new MatchScore(),westernConference[k+var].getLocation().getStadium().getName(), new MatchPlayers(),new MatchBudget()));
					games.get(nbjourney+3).getGames().add(new Match(new MatchTeam(westernConference[k+var],westernConference[k]),new MatchScore(),westernConference[k+var].getLocation().getStadium().getName(), new MatchPlayers(),new MatchBudget()));

					var=var-2;
				}
			}
		}	
	}
	
	/**
	 * Create matches for the play off if match teams don't reach the necessary point to pass.
	 * 
	 * @param Matches list, number of days, the home team, the away team, list of games won or lost in play off.
	 */
	
	public static void playOffThen(ArrayList <Date> games, int nbjourney, BasketballTeam homeTeam, BasketballTeam awayTeam, HashMap<String,Match> counterPlayOff ) {
		int i=0;
		for (Map.Entry<String, Match> j : counterPlayOff.entrySet()) {
			if (j.getKey().equals(homeTeam.getName()+awayTeam.getName())) {
				i = (j.getValue().getScore().getAwayTScore() + j.getValue().getScore().getHomeTScore());
			}
		}	
		if(i<6) 
			games.get(nbjourney).getGames().add(new Match(new MatchTeam(homeTeam,awayTeam),new MatchScore(),homeTeam.getLocation().getStadium().getName(),new MatchPlayers(),new MatchBudget()));	
		else 
			games.get(nbjourney).getGames().add(new Match(new MatchTeam(awayTeam,homeTeam),new MatchScore(),awayTeam.getLocation().getStadium().getName(),new MatchPlayers(),new MatchBudget()));	

	}
	
	/**
	 * Create matches for passing teams.
	 * 
	 * @param Matches list, number of days, qualified teams list, list of games won or lost in play off.
	 */
	
	public static void qualify(ArrayList <Date> games, int nbjourney, ArrayList<BasketballTeam> qualifiedTeams,HashMap<String,Match> counterPlayOff) {
		for(int i=0;i<qualifiedTeams.size();i=i+2) {
			counterPlayOff.put(qualifiedTeams.get(i).getName()+qualifiedTeams.get(i+1).getName(),new Match(new MatchTeam(qualifiedTeams.get(i),qualifiedTeams.get(i+1)),new MatchScore(),null,null,null));

			games.get(nbjourney).getGames().add(new Match(new MatchTeam(qualifiedTeams.get(i),
					qualifiedTeams.get(i+1)),new MatchScore(),qualifiedTeams.get(i).getLocation().getStadium().getName(),new MatchPlayers(),new MatchBudget()));
			games.get(nbjourney+1).getGames().add(new Match(new MatchTeam(qualifiedTeams.get(i),
					qualifiedTeams.get(i+1)),new MatchScore(),qualifiedTeams.get(i).getLocation().getStadium().getName(),new MatchPlayers(),new MatchBudget()));
			games.get(nbjourney+2).getGames().add(new Match(new MatchTeam(qualifiedTeams.get(i+1),
					qualifiedTeams.get(i)),new MatchScore(),qualifiedTeams.get(i+1).getLocation().getStadium().getName(),new MatchPlayers(),new MatchBudget()));
			games.get(nbjourney+3).getGames().add(new Match(new MatchTeam(qualifiedTeams.get(i+1),
					qualifiedTeams.get(i)),new MatchScore(),qualifiedTeams.get(i+1).getLocation().getStadium().getName(),new MatchPlayers(),new MatchBudget()));
		}
	}
	
	public static void triStats(Player tableau[]) {
		int longueur = tableau.length;
		Player tampon = null;
		boolean permut;
 
		do {
			permut = false;
			for (int i = 0; i < longueur - 1; i++) {
				float div=tableau[i].getOverallRating();
				float div2= tableau[i + 1].getOverallRating();			
				
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


