package process.season;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import data.match.Match;
import data.player.Player;

public class MatchBuilder {
	
	public static void getPlayersMatch (Match match) {
		
		ArrayList<Player> playersHome = new ArrayList<>();
		ArrayList<Player> playersAway = new ArrayList<>();
		
		String a[] = new String[] {"C","G","G","F","F"};
		
	    ArrayList<String> arlist = new ArrayList<String>(Arrays.asList(a));

	    int min,min2 = 0;
		Player max,max2 = new Player();
		
		@SuppressWarnings("unchecked")
		ArrayList<Player> tmpPlayers = (ArrayList<Player>)match.getTeams().getHomeTeam().getSquad().clone();
		@SuppressWarnings("unchecked")
		ArrayList<Player> tmpPlayers2 = (ArrayList<Player>)match.getTeams().getAwayTeam().getSquad().clone();
		
		for (int i = 0; i < arlist.size(); i++) {
			min = 0;
			max = null;

			for (Player players : tmpPlayers) {
				if (players.getOverallRating()>min && players.getPosition().contains(arlist.get(i))){
					max = players;
					min = players.getOverallRating();
					}
				if (max==null) {
					max = tmpPlayers.get((int) (Math.random() * tmpPlayers.size()));
				}
			}
			playersHome.add(max);
			tmpPlayers.remove(max);
			}
		
		for (int i = 0; i<arlist.size(); i++) {
			min2 = 0;
			max2 = null;
			for (Player players : tmpPlayers2) {
				if (players.getOverallRating()>min2 && players.getPosition().contains(arlist.get(i))){
					max2 = players;
					min2 = players.getOverallRating();
					}
				}
				if (max2==null) {
					max2 = tmpPlayers2.get((int) (Math.random() * tmpPlayers2.size()));
				}
			playersAway.add(max2);
			tmpPlayers2.remove(max2);
		}
		
		Collections.sort(playersHome);
		Collections.sort(playersAway);
		Collections.sort(tmpPlayers);
		Collections.sort(tmpPlayers2);
		
		for(int i=0; i<playersHome.size(); i++) {
			match.getScore().getHomeScorers().put(playersHome.get(i),0);
			match.getScore().getHomeAssists().put(playersHome.get(i),0);
		}
		for(int i=0; i<playersAway.size(); i++) {
			match.getScore().getAwayScorers().put(playersAway.get(i),0);
			match.getScore().getAwayAssists().put(playersAway.get(i),0);
		}
		for(int i=0; i<tmpPlayers.size(); i++) {
			match.getScore().getHomeScorers().put(tmpPlayers.get(i),0);
			match.getScore().getHomeAssists().put(tmpPlayers.get(i),0);

		}
		for(int i=0; i<tmpPlayers2.size(); i++) {
			match.getScore().getAwayScorers().put(tmpPlayers2.get(i),0);
			match.getScore().getAwayAssists().put(tmpPlayers2.get(i),0);
		}

		match.getPlayers().setHomePlayers(playersHome);
		match.getPlayers().setAwayPlayers(playersAway);
		match.getPlayers().setHomeSubPlayers(tmpPlayers);
		match.getPlayers().setAwaySubPlayers(tmpPlayers2);
		
	}	
}
