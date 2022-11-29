package process.season;

import java.util.ArrayList;
import java.util.Collections;

import data.basketteam.BasketballTeam;
import data.basketteam.TeamRank;
import data.calendar.Date;
import data.match.Match;
import data.match.MatchBudget;
import data.match.MatchPlayers;
import data.match.MatchScore;
import data.match.MatchTeam;
import data.player.Player;
import data.player.PlayerRank;
import data.player.PlayerStatistics;

public class SeasonBuilder {
	
	private static String [] mois = new String [] {
			
			"Octobre","Novembre", "Decembre","Janvier",
			
			"Fevrier","Mars","Avril","Mai"
			
		};
	
	public SeasonBuilder() {
		
	}
	
	/**
	 * Create matches for the regular season.
	 * 
	 * @param Number of days, number of teams, matches list, teams list.
	 */
	
	public static void setupNewSeason (int nbjourney, int nmb, ArrayList <Date> games, ArrayList <BasketballTeam> teams) {
		
		int t = nbjourney;
		int days = (nmb % 2 == 0) ? nmb -1 : nmb; 
		for (int i=0; i<days; i++) {
			for (int j=0; j<nmb/2; j++) {
				int t1 = (j+i) % (nmb) + 1;
				int t2 = ((nmb - j -1) + i) % nmb + 1;
				
				if(j==0 || j==1 || j==2) {
					if((games.get(j+t*3).getMonth().equals("Decembre")&& games.get(j+ t*3).getNumber()==25) ||
							(games.get(j+(t+days)*3).getMonth().equals("Fevrier")&& games.get(j+(t+days)*3).getNumber()==18)) {
						if(j==0 || j==1) {
							games.get((j+1)+ t*3).getGames().add(new Match(new MatchTeam(teams.get(t1-1),teams.get(t2-1)),new MatchScore(),
									teams.get(t1-1).getLocation().getStadium().getName(), new MatchPlayers(),new MatchBudget()));
							games.get((j+1)+(t+days)*3).getGames().add(new Match(new MatchTeam(teams.get(t2-1),teams.get(t1-1)),new MatchScore(),
									teams.get(t2-1).getLocation().getStadium().getName(), new MatchPlayers(),new MatchBudget()));
						}
						else {
							games.get((j-1)+ t*3).getGames().add(new Match(new MatchTeam(teams.get(t1-1),teams.get(t2-1)),new MatchScore(),
									teams.get(t1-1).getLocation().getStadium().getName(), new MatchPlayers(),new MatchBudget()));
							games.get((j-1)+(t+days)*3).getGames().add(new Match(new MatchTeam(teams.get(t2-1),teams.get(t1-1)),new MatchScore(),
									teams.get(t2-1).getLocation().getStadium().getName(), new MatchPlayers(),new MatchBudget()));
						}
					}
					else {
						games.get(j+ t*3).getGames().add(new Match(new MatchTeam(teams.get(t1-1),teams.get(t2-1)),new MatchScore(),
							teams.get(t1-1).getLocation().getStadium().getName(), new MatchPlayers(),new MatchBudget()));
						games.get(j+(t+days)*3).getGames().add(new Match(new MatchTeam(teams.get(t2-1),teams.get(t1-1)),new MatchScore(),
							teams.get(t2-1).getLocation().getStadium().getName(), new MatchPlayers(),new MatchBudget()));
					}
				}
				else {
					int random = (int) (Math.random() * 3);
					int tmp = random;
					
				while (random==tmp && games.get(random+t*3).getGames().size()>9 ) {
					random = (int) (Math.random() * 3);
				}
				
				while((games.get(random+t*3).getMonth().equals("Decembre")&&(games.get(random+t*3).getNumber()==25)) ||
						(games.get(random+(t+days)*3).getMonth().equals("Fevrier")&&(games.get(random+(t+days)*3).getNumber()==18))) {
					random = (int) (Math.random() * 3);
					tmp = random;
					while (random==tmp && games.get(random+t*3).getGames().size()>9 ) {
						random = (int) (Math.random() * 3);
					}
				}
				games.get(random+ t*3).getGames().add(new Match(new MatchTeam(teams.get(t1-1),teams.get(t2-1)),new MatchScore(),
						teams.get(t1-1).getLocation().getStadium().getName(), new MatchPlayers(),new MatchBudget()));
				games.get(random+(t+days)*3).getGames().add(new Match(new MatchTeam(teams.get(t2-1),teams.get(t1-1)),new MatchScore(),
						teams.get(t2-1).getLocation().getStadium().getName(), new MatchPlayers(),new MatchBudget()));
				
				}
			}
			t++;
		}
	}
	
	/**
	 * Initiates teams ranking.
	 * 
	 * @param Teams list, eastern conference ranking, western conference ranking.
	 */
	
	public static void initRanking (ArrayList<BasketballTeam> teams, BasketballTeam easternConference[], BasketballTeam westernConference[]) {
		
		int counter = 0;
		int counter2 = 0;
		for (int i=0;i<30;i++) {
			if (teams.get(i).getLocation().getConference().equals("Eastern Conference")) {
				easternConference [counter] = teams.get(i);
				easternConference[counter].setRank(new TeamRank(0,0,0,counter+1,0,new ArrayList<String>()));
				for(int j=0; j<5; j++)
					easternConference[counter].getRank().getForm().add("N");
				counter++;
			}
			else {
				westernConference [counter2] = teams.get(i);
				westernConference[counter2].setRank(new TeamRank(0,0,0,counter2+1,0,new ArrayList<String>()));
				for(int j=0; j<5; j++)
					westernConference[counter2].getRank().getForm().add("N");
				counter2++;
			}
		}
	}
	
	/**
	 * Initiates the budget for all teams.
	 * 
	 * @param Teams list.
	 */
	
	public static void initBudget(ArrayList<BasketballTeam> teams) {
		
		for(int year=2020; year<2026; year++) {
			for(int j=0;j<mois.length;j++) {
				for (int i=0; i<30; i++) {
					teams.get(i).getBudget().initBudget(mois[j]+year);
				}
			}
		}
	}
	
	public static void triBulleDecroissant(BasketballTeam tableau[]) {
		int longueur = tableau.length;
		BasketballTeam tampon = null;
		boolean permut;
		
		for (int i = 0; i < longueur; i++) {
			tableau[i].getRank().setPreviousRank(i+1);
		}
 
		do {
			permut = false;
			for (int i = 0; i < longueur - 1; i++) {
				if (tableau[i].getRank().getVictory() < tableau[i + 1].getRank().getVictory()) {
					tampon = tableau[i];
					tableau[i] = tableau[i + 1];
					tableau[i + 1] = tampon;
					permut = true;
				}
			}
		} while (permut);
		
		for (int i = 0; i < longueur; i++) {
			tableau[i].getRank().setRank(i+1);
		}
	}
	
	/**
	 * Initiates the salary for all players.
	 * 
	 * @param Teams list.
	 */
	
	public static void initSalary(ArrayList<BasketballTeam> teams) {
		
		for (int i=0; i<30; i++) {
						
			for(int j=0; j<teams.get(i).getSquad().size();j++) {
				if(teams.get(i).getSquad().get(j).getOverallRating()>=95) {
					int salary = (((int) (Math.random() * 5))+20)*100000;
					teams.get(i).getSquad().get(j).setSalary(1500000+salary);
				}
				else if(teams.get(i).getSquad().get(j).getOverallRating()>=88) {
					int salary = (((int) (Math.random() * 5))+15)*100000;
					teams.get(i).getSquad().get(j).setSalary(1000000+salary);
				}
				else if(teams.get(i).getSquad().get(j).getOverallRating()>=80) {
					int salary = (((int) (Math.random() * 5))+5)*100000;
					teams.get(i).getSquad().get(j).setSalary(500000+salary);
				}
				else if(teams.get(i).getSquad().get(j).getOverallRating()>=70) {
					int salary = (((int) (Math.random() * 5))+5)*100000;
					teams.get(i).getSquad().get(j).setSalary(100000+salary);
				}
				else {
					int salary = (((int) (Math.random() * 5))+1)*100000;
					teams.get(i).getSquad().get(j).setSalary(salary);
				}
			}
						
			int salary = (((int) (Math.random() * (teams.get(i).getCoach().getStat()-60))+50)*10000);
			teams.get(i).getCoach().setSalary(salary);
			
		}
	}
	
	/**
	 * Initiates the players ranking for points and assists.
	 * 
	 * @param Teams list.
	 */
	
	public static void initPlayersRanking(ArrayList<BasketballTeam> teams, PlayerRank playersRank) {
		for(int i=0;i <teams.size(); i++) {
			for(int j=0; j<teams.get(i).getSquad().size();j++) {
				playersRank.getPlayersPoints()[i*10+j] = teams.get(i).getSquad().get(j);
			}
		}
		
		for(int i=0;i <teams.size(); i++) {
			for(int j=0; j<teams.get(i).getSquad().size();j++) {
				playersRank.getPlayersAssists()[i*10+j] = teams.get(i).getSquad().get(j);
			}
		}
	}
	
	/**
	 * Initiates statistics for players and coaches.
	 * 
	 * @param Teams list.
	 */
	
	public static void initStat (ArrayList<BasketballTeam> teams) {
		
		for (int i=0; i<30; i++) {
			teams.get(i).calculateStat();
			teams.get(i).getCoach().setStat(teams.get(i).getStat());
		}	
	}
	
	/**
	 * Creates player depending on teams ranking
	 * 
	 * @param Teams list.
	 */
	
	public static void draft(ArrayList<BasketballTeam> league) {
		
		String pos[] = new String[] {"C","G","G","F","F"};
		String name[] = new String[] {"Howard","Smith","Johnson","Thomas","Hernandez","Anderson","Wilson","García"
				,"Davis","Thompson","Lopez","Blanc","Clark","Robinson","Walker","Young","Scott"};
		String surname[] = new String[] {"Alexander","James","Michael","Jacob","Hernandez","Mason ","Bruce","Ryan"
				,"Jayden","Nicholas","Jonathan","Aden","William","Noah","Walker","Ethan","Aaron"};
		BasketballTeam teams[] = new BasketballTeam[30];
		
		Player draft [] = new Player[30];	
		
		for(int i=0;i<league.size();i++) {
				Collections.sort(league.get(i).getSquad());
			
		}
		
		for(int i=0;i<league.size();i++) {
			for(int j=0;j<league.get(i).getSquad().size();j++) {
				if(league.get(i).getSquad().get(j).getAge()<20) {
					league.get(i).getSquad().get(j).setOverallRating(league.get(i).getSquad().get(j).getOverallRating()+(int)(Math.random()*3)+1);
				}
				
			}
		
		}
		
		for(int i=0;i<league.size();i++) {
			draft[i]=new Player(301,surname[(int)(Math.random()*17)]+" "+name[(int)(Math.random()*17)],(int)(Math.random()*2)+18,(int)(Math.random()*15)+70,pos[(int)(Math.random()*5)],new PlayerStatistics(),0,0);
		}
				
		for(int i=0;i<league.size();i++) {
			teams[i] = league.get(i);	
		}
		
		tri(teams);
		tri2(draft);
		
		for(int i=0;i<teams.length;i++) {
			if(draft[i].getOverallRating()>teams[29-i].getSquad().get(0).getOverallRating()) {
				draft[i].setSalary((int)(Math.random()*30)*10000+100000);
				teams[29-i].getSquad().remove(0);
				teams[29-i].add(draft[i]);
			}
			Collections.sort(league.get(i).getSquad());
		}

	}
	
	public static void tri(BasketballTeam tableau[]) {
		int longueur = tableau.length;
		BasketballTeam tampon = null;
		boolean permut;
 
		do {
			permut = false;
			for (int i = 0; i < longueur - 1; i++) {
				float div=tableau[i].getRank().getVictory();
				float div2= tableau[i + 1].getRank().getVictory();
	
				if (div<div2) {
					tampon = tableau[i];
					tableau[i] = tableau[i + 1];
					tableau[i + 1] = tampon;
					permut = true;
				}
			}
		} while (permut);
	}
	
	public static void tri2(Player tableau[]) {
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
