package process.league;

import java.util.ArrayList;
import java.util.HashMap;

import data.basketteam.BasketballTeam;
import data.basketteam.Commissioner;
import data.basketteam.TeamRanking;
import data.calendar.Date;
import data.match.Match;
import data.match.PlayOff;
import data.player.PlayerRank;

public interface LeagueInterface {
		
	ArrayList<Match> play();
	HashMap<String,String> getWinners();
	Commissioner getCommissioner();	
	PlayerRank getPlayersRank();
	int getNbJourney();
	ArrayList <Date> getGames();
	ArrayList<BasketballTeam> getTeamList();
	String getDate(int i);
	TeamRanking getTeamsRanking();
	int getCurrentSeason();
	PlayOff getPlayOff();
	String getStep();	
	BasketballTeam getTeam(String name);
	

}
