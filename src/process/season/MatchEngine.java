package process.season;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import data.match.Match;

public class MatchEngine {
	
	public static void simulateMatch(Match match) {
		
		int point = 0;
		int scoreA = 0;
		int scoreB = 0;

		for (int i = 0; i<44; i++) {
			
			if (i%2==0) {
				
				int tmp = (int) (Math.random()* 40);
				int tmp2 = 0;
				
				if(tmp<5) tmp2 = 0;
				else if (tmp<10) tmp2 = 1;
				else if(tmp<15) tmp2 = 2;
				else if(tmp<25) tmp2 = 3;
				else tmp2 = 4;

				if (match.getPlayers().getHomePlayers().get(tmp2).getOverallRating()>
				match.getPlayers().getAwayPlayers().get((int) (Math.random()* match.getPlayers().getAwayPlayers().size())).getOverallRating()) {
					point = 6;
					scoreA = scoreA + point;
					
					match.getScore().getHomeStats().setThreePoint(match.getScore().getHomeStats().getThreePoint()+1);
					match.getScore().getHomeStats().setTwoPoint(match.getScore().getHomeStats().getTwoPoint()+1);
					match.getScore().getHomeStats().setFreeThrow(match.getScore().getHomeStats().getFreeThrow()+1);
					
					scorerMatch(match,1,0);
					scorerMatch(match,2,0);
					scorerMatch(match,3,0);
					
					for(int k=0; k<2; k++) {
						if((int) (Math.random()*10)>2) {
							assistMatch(match,0);
						}
					}
					
					match.getScore().setHomeTScore(scoreA);
				
					}
					
				else {
					point = (int) (Math.random()* 4)+2;
					scoreA = scoreA+point;
					
					match.getScore().setHomeTScore(scoreA);
					
					if(point==2) {
						if ((int) (Math.random()* 2)==0) {
							match.getScore().getHomeStats().setTwoPoint(match.getScore().getHomeStats().getTwoPoint()+1);
							scorerMatch(match,2,0);
							if((int)(Math.random()*10)>2) assistMatch(match,0);
						}
						else {
							match.getScore().getHomeStats().setFreeThrow(match.getScore().getHomeStats().getFreeThrow()+2);
							for(int j=0; j<2; j++) scorerMatch(match,1,0);
						}
					}
					else if(point==3) {
						if ((int) (Math.random()* 2)==0) {
							match.getScore().getHomeStats().setFreeThrow(match.getScore().getHomeStats().getFreeThrow()+1);
							match.getScore().getHomeStats().setTwoPoint(match.getScore().getHomeStats().getTwoPoint()+1);
							scorerMatch(match,1,0);
							scorerMatch(match,2,0);
							if((int)(Math.random()*10)>2) assistMatch(match,0);

						}
						else {
							match.getScore().getHomeStats().setThreePoint(match.getScore().getHomeStats().getThreePoint()+1);
							scorerMatch(match,3,0);
							if((int)(Math.random()*10)>2) assistMatch(match,0);
						}
					}
					else if(point==4) {
							match.getScore().getHomeStats().setTwoPoint(match.getScore().getHomeStats().getTwoPoint()+2);	
							for(int j=0; j<2; j++) {
								scorerMatch(match,2,0);
								if((int)(Math.random()*10)>2) assistMatch(match,0);
							
					}
					}
					else if(point==5) {
						if ((int) (Math.random()* 2)==0) {
							match.getScore().getHomeStats().setFreeThrow(match.getScore().getHomeStats().getFreeThrow()+1);
							match.getScore().getHomeStats().setTwoPoint(match.getScore().getHomeStats().getTwoPoint()+2);
							scorerMatch(match,1,0);
							for(int j=0; j<2; j++) {
								scorerMatch(match,2,0);
								if((int)(Math.random()*10)>2)
									assistMatch(match,0);

							}

						}
						else {
							match.getScore().getHomeStats().setFreeThrow(match.getScore().getHomeStats().getFreeThrow()+3);
							match.getScore().getHomeStats().setTwoPoint(match.getScore().getHomeStats().getTwoPoint()+1);
							for(int j=0; j<3; j++) scorerMatch(match,1,0);
							scorerMatch(match,2,0);
							if((int)(Math.random()*10)>2) assistMatch(match,0);

							}
					}
				}
				
				if(i<11) match.getScore().getQuarterTimeHome().setFirstQT(match.getScore().getQuarterTimeHome().getFirstQT()+point);
				if(i>=11 && i<22) match.getScore().getQuarterTimeHome().setSecondQT(match.getScore().getQuarterTimeHome().getSecondQT()+point);
				if(i>=22 && i<33) match.getScore().getQuarterTimeHome().setThirdQT(match.getScore().getQuarterTimeHome().getThirdQT()+point);
				if(i>=33 && i<44) match.getScore().getQuarterTimeHome().setFourthQT(match.getScore().getQuarterTimeHome().getFourthQT()+point);
				
			}
			else {
				
				int tmp = (int) (Math.random()* 40);
				int tmp2 = 0;
				
				if(tmp<5) tmp2 = 0;
				else if(tmp<10) tmp2 = 1;	
				else if(tmp<15) tmp2 = 2;
				else if(tmp<25) tmp2 = 3;
				else tmp2 = 4;
				
				if (match.getPlayers().getAwayPlayers().get(tmp2).getOverallRating()>
				match.getPlayers().getHomePlayers().get((int) (Math.random()* match.getPlayers().getHomePlayers().size())).getOverallRating()) {
					point = 6;
					scoreB = scoreB + point;
			
					match.getScore().getAwayStats().setThreePoint(match.getScore().getAwayStats().getThreePoint()+1);
					match.getScore().getAwayStats().setTwoPoint(match.getScore().getAwayStats().getTwoPoint()+1);
					match.getScore().getAwayStats().setFreeThrow(match.getScore().getAwayStats().getFreeThrow()+1);
					
					scorerMatch(match,1,1);
					scorerMatch(match,2,1);
					scorerMatch(match,3,1);
					
					for(int k=0; k<2; k++) {
						if((int)(Math.random()*10)>2) {
							assistMatch(match,1);
						}
					}
					
					match.getScore().setAwayTScore(scoreB);

					}
				
				else {
					
					point = (int) (Math.random()* 4)+2;
					scoreB = scoreB+point;
					
					match.getScore().setAwayTScore(scoreB);
					
					if(point==2) {
						if ((int) (Math.random()* 2)==0) {
							match.getScore().getAwayStats().setTwoPoint(match.getScore().getAwayStats().getTwoPoint()+1);
							scorerMatch(match,2,1);
							if((int)(Math.random()*10)>2) assistMatch(match,1);
						}
						else {
							match.getScore().getAwayStats().setFreeThrow(match.getScore().getAwayStats().getFreeThrow()+2);
							for(int j=0; j<2; j++) scorerMatch(match,1,1);
						}
					}
					else if(point==3) {
						if ((int) (Math.random()* 2)==0) {
							match.getScore().getAwayStats().setFreeThrow(match.getScore().getAwayStats().getFreeThrow()+1);
							match.getScore().getAwayStats().setTwoPoint(match.getScore().getAwayStats().getTwoPoint()+1);
							scorerMatch(match,1,1);
							scorerMatch(match,2,1);
							if((int)(Math.random()*10)>2) assistMatch(match,1);
						}
						else {
							match.getScore().getAwayStats().setThreePoint(match.getScore().getAwayStats().getThreePoint()+1);
							scorerMatch(match,3,1);
							if((int)(Math.random()*10)>2) assistMatch(match,1);
						}
					}
					else if(point==4) {
						
							match.getScore().getAwayStats().setTwoPoint(match.getScore().getAwayStats().getTwoPoint()+2);
							for(int j=0; j<2; j++) {
								scorerMatch(match,2,1);
								if((int)(Math.random()*10)>2) assistMatch(match,1);
							}
					}
					else if(point==5) {
						if ((int) (Math.random()* 2)==0) {
							match.getScore().getAwayStats().setFreeThrow(match.getScore().getAwayStats().getFreeThrow()+1);
							match.getScore().getAwayStats().setTwoPoint(match.getScore().getAwayStats().getTwoPoint()+2);
							scorerMatch(match,1,1);
							for(int j=0; j<2; j++) {
								scorerMatch(match,2,1);
								if((int)(Math.random()*10)>2) assistMatch(match,1);
							}
						}
						else {
							match.getScore().getAwayStats().setFreeThrow(match.getScore().getAwayStats().getFreeThrow()+3);
							match.getScore().getAwayStats().setTwoPoint(match.getScore().getAwayStats().getTwoPoint()+1);	
							for(int j=0; j<3; j++) scorerMatch(match,1,1);
							scorerMatch(match,2,1);
							if((int)(Math.random()*10)>2) assistMatch(match,1);

						}
					}
				}
				if(i<11) match.getScore().getQuarterTimeAway().setFirstQT(match.getScore().getQuarterTimeAway().getFirstQT()+point);
				if(i>=11 && i<22) match.getScore().getQuarterTimeAway().setSecondQT(match.getScore().getQuarterTimeAway().getSecondQT()+point);
				if(i>=22 && i<33) match.getScore().getQuarterTimeAway().setThirdQT(match.getScore().getQuarterTimeAway().getThirdQT()+point);
				if(i>=33 && i<44) match.getScore().getQuarterTimeAway().setFourthQT(match.getScore().getQuarterTimeAway().getFourthQT()+point);
			}
						
		}
		
		if(scoreA==scoreB) {
			int random = (int) (Math.random()* 1);
			if (random==0) {
				match.getScore().setAwayTScore(scoreB+1);
				match.getScore().getQuarterTimeAway().setFourthQT(match.getScore().getQuarterTimeAway().getFourthQT()+1);
				match.getScore().getAwayStats().setFreeThrow(match.getScore().getAwayStats().getFreeThrow()+1);
			}
			else {
				match.getScore().setHomeTScore(scoreA+1);
				match.getScore().getQuarterTimeHome().setFourthQT(match.getScore().getQuarterTimeHome().getFourthQT()+1);
				match.getScore().getAwayStats().setFreeThrow(match.getScore().getAwayStats().getFreeThrow()+1);

			}
		}
		
		for(int j=0;j<match.getPlayers().getHomePlayers().size();j++) {
			match.getPlayers().getHomePlayers().get(j).setGamesPlayed(match.getPlayers().getHomePlayers().get(j).getGamesPlayed()+1);
			match.getPlayers().getAwayPlayers().get(j).setGamesPlayed(match.getPlayers().getAwayPlayers().get(j).getGamesPlayed()+1);
			match.getPlayers().getHomeSubPlayers().get(j).setGamesPlayed(match.getPlayers().getHomeSubPlayers().get(j).getGamesPlayed()+1);
			match.getPlayers().getAwaySubPlayers().get(j).setGamesPlayed(match.getPlayers().getAwaySubPlayers().get(j).getGamesPlayed()+1);

		}

		
		}
	
	public static Match playRegularMatch (Match match) {
		simulateMatch(match);
	
		if (match.getScore().getHomeTScore()>match.getScore().getAwayTScore()) {
			match.getTeams().getHomeTeam().getRank().setVictory(match.getTeams().getHomeTeam().getRank().getVictory()+1);
			match.getTeams().getAwayTeam().getRank().setDefeat(match.getTeams().getAwayTeam().getRank().getDefeat()+1);
			
			match.getTeams().getHomeTeam().getRank().setForm(rotate(match.getTeams().getHomeTeam().getRank().getForm(),4));
			match.getTeams().getAwayTeam().getRank().setForm(rotate(match.getTeams().getAwayTeam().getRank().getForm(),4));
			match.getTeams().getHomeTeam().getRank().getForm().remove(4);
			match.getTeams().getHomeTeam().getRank().getForm().add("V");
			match.getTeams().getAwayTeam().getRank().getForm().remove(4);
			match.getTeams().getAwayTeam().getRank().getForm().add("D");
		
		}
		else {
			match.getTeams().getAwayTeam().getRank().setVictory(match.getTeams().getAwayTeam().getRank().getVictory()+1);
			match.getTeams().getHomeTeam().getRank().setDefeat(match.getTeams().getHomeTeam().getRank().getDefeat()+1);
			
			match.getTeams().getHomeTeam().getRank().setForm(rotate(match.getTeams().getHomeTeam().getRank().getForm(),4));
			match.getTeams().getAwayTeam().getRank().setForm(rotate(match.getTeams().getAwayTeam().getRank().getForm(),4));
			match.getTeams().getAwayTeam().getRank().getForm().remove(4);
			match.getTeams().getAwayTeam().getRank().getForm().add("V");
			match.getTeams().getHomeTeam().getRank().getForm().remove(4);
			match.getTeams().getHomeTeam().getRank().getForm().add("D");
			}
		double nbtotal = (match.getTeams().getHomeTeam().getRank().getVictory()+match.getTeams().getHomeTeam().getRank().getDefeat());
		double nbtotal2 = (match.getTeams().getAwayTeam().getRank().getVictory()+match.getTeams().getAwayTeam().getRank().getDefeat());

		match.getTeams().getHomeTeam().getRank().setPercentage((double)(match.getTeams().getHomeTeam().getRank().getVictory()/nbtotal));
		match.getTeams().getAwayTeam().getRank().setPercentage((double)(match.getTeams().getAwayTeam().getRank().getVictory()/nbtotal2));
		return match;
	}
	
	public static Match simulatePlayOff(Match match) {
		simulateMatch(match);	
		return match;
	}
	
	public static void counter(Match match, HashMap<String,Match> counterPlayOff, int nb, int regularSeason) {
		if (regularSeason==nb || regularSeason == nb+1 || regularSeason==nb+4 || regularSeason==nb+5) {
		if (match.getScore().getHomeTScore()>match.getScore().getAwayTScore()) 
			for (Map.Entry<String, Match> j : counterPlayOff.entrySet()) {
				if (j.getKey().equals(match.getTeams().getHomeTeam().getName()+match.getTeams().getAwayTeam().getName())) {
					j.getValue().getScore().setHomeTScore(j.getValue().getScore().getHomeTScore()+1);
				}
			}		
		else {
			for (Map.Entry<String, Match> j : counterPlayOff.entrySet()) {
				if (j.getKey().equals(match.getTeams().getHomeTeam().getName()+match.getTeams().getAwayTeam().getName())) {
					j.getValue().getScore().setAwayTScore(j.getValue().getScore().getAwayTScore()+1);
				}
			}	
		}
		}
		else {
			if (match.getScore().getHomeTScore()>match.getScore().getAwayTScore()) 
				for (Map.Entry<String, Match> j : counterPlayOff.entrySet()) {
					if (j.getKey().equals(match.getTeams().getAwayTeam().getName()+match.getTeams().getHomeTeam().getName())) {
						j.getValue().getScore().setAwayTScore(j.getValue().getScore().getAwayTScore()+1);
					}
				}		
			else {
				for (Map.Entry<String, Match> j : counterPlayOff.entrySet()) {
					if (j.getKey().equals(match.getTeams().getAwayTeam().getName()+match.getTeams().getHomeTeam().getName())) {
						j.getValue().getScore().setHomeTScore(j.getValue().getScore().getHomeTScore()+1);
					}
				}	
			}
			
		}
	}
	
	public static void scorerMatch (Match match, int point, int bool) {
		int index = 0;
		
		int scorer = (int) (Math.random()* (match.getPlayers().getHomePlayers().get(0).getOverallRating()+
				match.getPlayers().getHomePlayers().get(1).getOverallRating()+
				match.getPlayers().getHomePlayers().get(2).getOverallRating()+
				match.getPlayers().getHomePlayers().get(3).getOverallRating()+
				match.getPlayers().getHomePlayers().get(4).getOverallRating()+((
						match.getPlayers().getHomePlayers().get(4).getOverallRating()-
						match.getPlayers().getHomePlayers().get(0).getOverallRating())+(
								match.getPlayers().getHomePlayers().get(3).getOverallRating()-
								match.getPlayers().getHomePlayers().get(0).getOverallRating())+(
										match.getPlayers().getHomePlayers().get(2).getOverallRating()-
										match.getPlayers().getHomePlayers().get(0).getOverallRating())+(
												match.getPlayers().getHomePlayers().get(1).getOverallRating()-
												match.getPlayers().getHomePlayers().get(0).getOverallRating()))+140));
		int scorer1 = (int) (Math.random()* (match.getPlayers().getAwayPlayers().get(0).getOverallRating()+
				match.getPlayers().getAwayPlayers().get(1).getOverallRating()+
				match.getPlayers().getAwayPlayers().get(2).getOverallRating()+
				match.getPlayers().getAwayPlayers().get(3).getOverallRating()+
				match.getPlayers().getAwayPlayers().get(4).getOverallRating()+((
						match.getPlayers().getAwayPlayers().get(4).getOverallRating()-
						match.getPlayers().getAwayPlayers().get(0).getOverallRating())+(
								match.getPlayers().getAwayPlayers().get(3).getOverallRating()-
								match.getPlayers().getAwayPlayers().get(0).getOverallRating())+(
										match.getPlayers().getAwayPlayers().get(2).getOverallRating()-
										match.getPlayers().getAwayPlayers().get(0).getOverallRating())+(
												match.getPlayers().getAwayPlayers().get(1).getOverallRating()-
												match.getPlayers().getAwayPlayers().get(0).getOverallRating()))+140));
		int scorer2 = (int) (Math.random()* (match.getPlayers().getHomeSubPlayers().get(0).getOverallRating()+
				match.getPlayers().getHomeSubPlayers().get(1).getOverallRating()+
				match.getPlayers().getHomeSubPlayers().get(2).getOverallRating()+
				match.getPlayers().getHomeSubPlayers().get(3).getOverallRating()+
				match.getPlayers().getHomeSubPlayers().get(4).getOverallRating()));
		int scorer3 = (int) (Math.random()* (match.getPlayers().getAwaySubPlayers().get(0).getOverallRating()+
				match.getPlayers().getAwaySubPlayers().get(1).getOverallRating()+
				match.getPlayers().getAwaySubPlayers().get(2).getOverallRating()+
				match.getPlayers().getAwaySubPlayers().get(3).getOverallRating()+
				match.getPlayers().getAwaySubPlayers().get(4).getOverallRating()));
		
		
		if(bool==0) {
			if((int) (Math.random()*10)>1) {
			if(scorer<match.getPlayers().getHomePlayers().get(0).getOverallRating()) index = 0;
			else if(scorer<(match.getPlayers().getHomePlayers().get(0).getOverallRating()+
					match.getPlayers().getHomePlayers().get(1).getOverallRating())+(
							match.getPlayers().getHomePlayers().get(1).getOverallRating()-
							match.getPlayers().getHomePlayers().get(0).getOverallRating())+10) index = 1;
			else if(scorer<(match.getPlayers().getHomePlayers().get(0).getOverallRating()+
					match.getPlayers().getHomePlayers().get(1).getOverallRating()+
					match.getPlayers().getHomePlayers().get(2).getOverallRating())+(
							match.getPlayers().getHomePlayers().get(2).getOverallRating()-
							match.getPlayers().getHomePlayers().get(0).getOverallRating()+
							match.getPlayers().getHomePlayers().get(1).getOverallRating()-
							match.getPlayers().getHomePlayers().get(0).getOverallRating())+20) index = 2;
			else if(scorer<(match.getPlayers().getHomePlayers().get(0).getOverallRating()+
					match.getPlayers().getHomePlayers().get(1).getOverallRating()+
					match.getPlayers().getHomePlayers().get(2).getOverallRating()+
					match.getPlayers().getHomePlayers().get(3).getOverallRating())+(
							match.getPlayers().getHomePlayers().get(3).getOverallRating()-
							match.getPlayers().getHomePlayers().get(0).getOverallRating()+
							match.getPlayers().getHomePlayers().get(2).getOverallRating()-
							match.getPlayers().getHomePlayers().get(0).getOverallRating()+
							match.getPlayers().getHomePlayers().get(1).getOverallRating()-
							match.getPlayers().getHomePlayers().get(0).getOverallRating())+80) index = 3;
			else if(scorer<(match.getPlayers().getHomePlayers().get(0).getOverallRating()+
					match.getPlayers().getHomePlayers().get(1).getOverallRating()+
					match.getPlayers().getHomePlayers().get(2).getOverallRating()+
					match.getPlayers().getHomePlayers().get(3).getOverallRating()+
					match.getPlayers().getHomePlayers().get(4).getOverallRating())+(
							match.getPlayers().getHomePlayers().get(4).getOverallRating()-
							match.getPlayers().getHomePlayers().get(0).getOverallRating()+
							match.getPlayers().getHomePlayers().get(3).getOverallRating()-
							match.getPlayers().getHomePlayers().get(0).getOverallRating()+
							match.getPlayers().getHomePlayers().get(2).getOverallRating()-
							match.getPlayers().getHomePlayers().get(0).getOverallRating()+
							match.getPlayers().getHomePlayers().get(1).getOverallRating()-
							match.getPlayers().getHomePlayers().get(0).getOverallRating())+140) index = 4;
			
			match.getScore().getHomeScorers().put(match.getPlayers().getHomePlayers().get(index), match.getScore().getHomeScorers().get(match.getPlayers().getHomePlayers().get(index))+point);
			match.getPlayers().getHomePlayers().get(index).getPlayerStatistics().setBasketScored(match.getPlayers().getHomePlayers().get(index).getPlayerStatistics().getBasketScored()+point);
			}
			else {
				if(scorer2<match.getPlayers().getHomeSubPlayers().get(0).getOverallRating()) index = 0;
				else if(scorer2<(match.getPlayers().getHomeSubPlayers().get(0).getOverallRating()+
						match.getPlayers().getHomeSubPlayers().get(1).getOverallRating())) index = 1;
				else if(scorer2<(match.getPlayers().getHomeSubPlayers().get(0).getOverallRating()+
						match.getPlayers().getHomeSubPlayers().get(1).getOverallRating()+
						match.getPlayers().getHomeSubPlayers().get(2).getOverallRating())) index = 2;
				else if(scorer2<(match.getPlayers().getHomeSubPlayers().get(0).getOverallRating()+
						match.getPlayers().getHomeSubPlayers().get(1).getOverallRating()+
						match.getPlayers().getHomeSubPlayers().get(2).getOverallRating()+
						match.getPlayers().getHomeSubPlayers().get(3).getOverallRating())-(
						match.getPlayers().getHomeSubPlayers().get(3).getOverallRating()-
						match.getPlayers().getHomeSubPlayers().get(2).getOverallRating())) index = 3;
				else if(scorer2<(match.getPlayers().getHomeSubPlayers().get(0).getOverallRating()+
						match.getPlayers().getHomeSubPlayers().get(1).getOverallRating()+
						match.getPlayers().getHomeSubPlayers().get(2).getOverallRating()+
						match.getPlayers().getHomeSubPlayers().get(3).getOverallRating()+
						match.getPlayers().getHomeSubPlayers().get(4).getOverallRating())-(
						match.getPlayers().getHomeSubPlayers().get(4).getOverallRating()-
						match.getPlayers().getHomeSubPlayers().get(3).getOverallRating())) index = 4;
				
				match.getScore().getHomeScorers().put(match.getPlayers().getHomeSubPlayers().get(index), match.getScore().getHomeScorers().get(match.getPlayers().getHomeSubPlayers().get(index))+point);
				match.getPlayers().getHomeSubPlayers().get(index).getPlayerStatistics().setBasketScored(match.getPlayers().getHomeSubPlayers().get(index).getPlayerStatistics().getBasketScored()+point);
			}

			
		}
		else  {
			if((int) (Math.random()*10)>1) {
			if(scorer1<match.getPlayers().getAwayPlayers().get(0).getOverallRating()) index = 0;
			else if(scorer1<match.getPlayers().getAwayPlayers().get(0).getOverallRating()+
					match.getPlayers().getAwayPlayers().get(1).getOverallRating()+(
							match.getPlayers().getAwayPlayers().get(1).getOverallRating()-
							match.getPlayers().getAwayPlayers().get(0).getOverallRating())+(
									match.getPlayers().getAwayPlayers().get(1).getOverallRating()-
									match.getPlayers().getAwayPlayers().get(0).getOverallRating())+10) index = 1;
			else if(scorer1<match.getPlayers().getAwayPlayers().get(0).getOverallRating()+
					match.getPlayers().getAwayPlayers().get(1).getOverallRating()+
					match.getPlayers().getAwayPlayers().get(2).getOverallRating()+(
							match.getPlayers().getAwayPlayers().get(2).getOverallRating()-
							match.getPlayers().getAwayPlayers().get(0).getOverallRating()+(
									match.getPlayers().getAwayPlayers().get(1).getOverallRating()-
									match.getPlayers().getAwayPlayers().get(0).getOverallRating()))+20) index = 2;
			else if(scorer1<match.getPlayers().getAwayPlayers().get(0).getOverallRating()+
					match.getPlayers().getAwayPlayers().get(1).getOverallRating()+
					match.getPlayers().getAwayPlayers().get(2).getOverallRating()+
					match.getPlayers().getAwayPlayers().get(3).getOverallRating()+(
							match.getPlayers().getAwayPlayers().get(3).getOverallRating()-
							match.getPlayers().getAwayPlayers().get(0).getOverallRating()+(
									match.getPlayers().getAwayPlayers().get(2).getOverallRating()-
									match.getPlayers().getAwayPlayers().get(0).getOverallRating())+(
											match.getPlayers().getAwayPlayers().get(1).getOverallRating()-
											match.getPlayers().getAwayPlayers().get(0).getOverallRating()))+80)index = 3;
			else if(scorer1<match.getPlayers().getAwayPlayers().get(0).getOverallRating()+
					match.getPlayers().getAwayPlayers().get(1).getOverallRating()+
					match.getPlayers().getAwayPlayers().get(2).getOverallRating()+
					match.getPlayers().getAwayPlayers().get(3).getOverallRating()+
					match.getPlayers().getAwayPlayers().get(4).getOverallRating()+(
							match.getPlayers().getAwayPlayers().get(4).getOverallRating()-
							match.getPlayers().getAwayPlayers().get(0).getOverallRating()+(
									match.getPlayers().getAwayPlayers().get(3).getOverallRating()-
									match.getPlayers().getAwayPlayers().get(0).getOverallRating())+(
											match.getPlayers().getAwayPlayers().get(2).getOverallRating()-
											match.getPlayers().getAwayPlayers().get(0).getOverallRating())+(
													match.getPlayers().getAwayPlayers().get(1).getOverallRating()-
													match.getPlayers().getAwayPlayers().get(0).getOverallRating()))+140) index = 4;
			match.getScore().getAwayScorers().put(match.getPlayers().getAwayPlayers().get(index), match.getScore().getAwayScorers().get(match.getPlayers().getAwayPlayers().get(index))+point);
			match.getPlayers().getAwayPlayers().get(index).getPlayerStatistics().setBasketScored(match.getPlayers().getAwayPlayers().get(index).getPlayerStatistics().getBasketScored()+point);
		}
		else {
			if(scorer3<match.getPlayers().getAwaySubPlayers().get(0).getOverallRating()) index = 0;
			else if(scorer3<(match.getPlayers().getAwaySubPlayers().get(0).getOverallRating()+
					match.getPlayers().getAwaySubPlayers().get(1).getOverallRating())) index = 1;
			else if(scorer3<(match.getPlayers().getAwaySubPlayers().get(0).getOverallRating()+
					match.getPlayers().getAwaySubPlayers().get(1).getOverallRating()+
					match.getPlayers().getAwaySubPlayers().get(2).getOverallRating())) index = 2;
			else if(scorer3<(match.getPlayers().getAwaySubPlayers().get(0).getOverallRating()+
					match.getPlayers().getAwaySubPlayers().get(1).getOverallRating()+
					match.getPlayers().getAwaySubPlayers().get(2).getOverallRating()+
					match.getPlayers().getAwaySubPlayers().get(3).getOverallRating())) index = 3;
			else if(scorer3<(match.getPlayers().getAwaySubPlayers().get(0).getOverallRating()+
					match.getPlayers().getAwaySubPlayers().get(1).getOverallRating()+
					match.getPlayers().getAwaySubPlayers().get(2).getOverallRating()+
					match.getPlayers().getAwaySubPlayers().get(3).getOverallRating()+
					match.getPlayers().getAwaySubPlayers().get(4).getOverallRating())) index = 4;
			
			match.getScore().getAwayScorers().put(match.getPlayers().getAwaySubPlayers().get(index), match.getScore().getAwayScorers().get(match.getPlayers().getAwaySubPlayers().get(index))+point);
			match.getPlayers().getAwaySubPlayers().get(index).getPlayerStatistics().setBasketScored(match.getPlayers().getAwaySubPlayers().get(index).getPlayerStatistics().getBasketScored()+point);
		
		}
		}
	}
	
	public static void assistMatch(Match match, int bool) {
		
		int index = 0;

		int assist = (int) (Math.random()* (match.getPlayers().getHomePlayers().get(0).getOverallRating()+
				match.getPlayers().getHomePlayers().get(1).getOverallRating()+
				match.getPlayers().getHomePlayers().get(2).getOverallRating()+
				match.getPlayers().getHomePlayers().get(3).getOverallRating()+
				match.getPlayers().getHomePlayers().get(4).getOverallRating()+((
						match.getPlayers().getHomePlayers().get(4).getOverallRating()-
						match.getPlayers().getHomePlayers().get(0).getOverallRating())+(
								match.getPlayers().getHomePlayers().get(3).getOverallRating()-
								match.getPlayers().getHomePlayers().get(0).getOverallRating())+(
										match.getPlayers().getHomePlayers().get(2).getOverallRating()-
										match.getPlayers().getHomePlayers().get(0).getOverallRating())+(
												match.getPlayers().getHomePlayers().get(1).getOverallRating()-
												match.getPlayers().getHomePlayers().get(0).getOverallRating()))+200));
		int assist1 = (int) (Math.random()* (match.getPlayers().getAwayPlayers().get(0).getOverallRating()+
				match.getPlayers().getAwayPlayers().get(1).getOverallRating()+
				match.getPlayers().getAwayPlayers().get(2).getOverallRating()+
				match.getPlayers().getAwayPlayers().get(3).getOverallRating()+
				match.getPlayers().getAwayPlayers().get(4).getOverallRating()+((
						match.getPlayers().getAwayPlayers().get(4).getOverallRating()-
						match.getPlayers().getAwayPlayers().get(0).getOverallRating())+(
								match.getPlayers().getAwayPlayers().get(3).getOverallRating()-
								match.getPlayers().getAwayPlayers().get(0).getOverallRating())+(
										match.getPlayers().getAwayPlayers().get(2).getOverallRating()-
										match.getPlayers().getAwayPlayers().get(0).getOverallRating())+(
												match.getPlayers().getAwayPlayers().get(1).getOverallRating()-
												match.getPlayers().getAwayPlayers().get(0).getOverallRating()))+200));
		int assist2 = (int) (Math.random()* (match.getPlayers().getHomeSubPlayers().get(0).getOverallRating()+
				match.getPlayers().getHomeSubPlayers().get(1).getOverallRating()+
				match.getPlayers().getHomeSubPlayers().get(2).getOverallRating()+
				match.getPlayers().getHomeSubPlayers().get(3).getOverallRating()+
				match.getPlayers().getHomeSubPlayers().get(4).getOverallRating()));
		int assist3 = (int) (Math.random()* (match.getPlayers().getAwaySubPlayers().get(0).getOverallRating()+
				match.getPlayers().getAwaySubPlayers().get(1).getOverallRating()+
				match.getPlayers().getAwaySubPlayers().get(2).getOverallRating()+
				match.getPlayers().getAwaySubPlayers().get(3).getOverallRating()+
				match.getPlayers().getAwaySubPlayers().get(4).getOverallRating()));
		
		if(bool==0) {
			if((int) (Math.random()*20)>1) {
			if(assist<match.getPlayers().getHomePlayers().get(0).getOverallRating()) index = 0;
			else if(assist<(match.getPlayers().getHomePlayers().get(0).getOverallRating()+
					match.getPlayers().getHomePlayers().get(1).getOverallRating())+(
							match.getPlayers().getHomePlayers().get(1).getOverallRating()-
							match.getPlayers().getHomePlayers().get(0).getOverallRating())+10) index = 1;
			else if(assist<(match.getPlayers().getHomePlayers().get(0).getOverallRating()+
					match.getPlayers().getHomePlayers().get(1).getOverallRating()+
					match.getPlayers().getHomePlayers().get(2).getOverallRating())+(
							match.getPlayers().getHomePlayers().get(2).getOverallRating()-
							match.getPlayers().getHomePlayers().get(0).getOverallRating()+
							match.getPlayers().getHomePlayers().get(1).getOverallRating()-
							match.getPlayers().getHomePlayers().get(0).getOverallRating())+15) index = 2;
			else if(assist<(match.getPlayers().getHomePlayers().get(0).getOverallRating()+
					match.getPlayers().getHomePlayers().get(1).getOverallRating()+
					match.getPlayers().getHomePlayers().get(2).getOverallRating()+
					match.getPlayers().getHomePlayers().get(3).getOverallRating())+(
							match.getPlayers().getHomePlayers().get(3).getOverallRating()-
							match.getPlayers().getHomePlayers().get(0).getOverallRating()+
							match.getPlayers().getHomePlayers().get(2).getOverallRating()-
							match.getPlayers().getHomePlayers().get(0).getOverallRating()+
							match.getPlayers().getHomePlayers().get(1).getOverallRating()-
							match.getPlayers().getHomePlayers().get(0).getOverallRating())+100) index = 3;
			else if(assist<(match.getPlayers().getHomePlayers().get(0).getOverallRating()+
					match.getPlayers().getHomePlayers().get(1).getOverallRating()+
					match.getPlayers().getHomePlayers().get(2).getOverallRating()+
					match.getPlayers().getHomePlayers().get(3).getOverallRating()+
					match.getPlayers().getHomePlayers().get(4).getOverallRating())+(
							match.getPlayers().getHomePlayers().get(4).getOverallRating()-
							match.getPlayers().getHomePlayers().get(0).getOverallRating()+
							match.getPlayers().getHomePlayers().get(3).getOverallRating()-
							match.getPlayers().getHomePlayers().get(0).getOverallRating()+
							match.getPlayers().getHomePlayers().get(2).getOverallRating()-
							match.getPlayers().getHomePlayers().get(0).getOverallRating()+
							match.getPlayers().getHomePlayers().get(1).getOverallRating()-
							match.getPlayers().getHomePlayers().get(0).getOverallRating())+200) index = 4;
			
			match.getScore().getHomeAssists().put(match.getPlayers().getHomePlayers().get(index), match.getScore().getHomeAssists().get(match.getPlayers().getHomePlayers().get(index))+1);
			match.getPlayers().getHomePlayers().get(index).getPlayerStatistics().setAssists(match.getPlayers().getHomePlayers().get(index).getPlayerStatistics().getAssists()+1);
			}
			else {
				if(assist2<match.getPlayers().getHomeSubPlayers().get(0).getOverallRating()) index = 0;
				else if(assist2<(match.getPlayers().getHomeSubPlayers().get(0).getOverallRating()+
						match.getPlayers().getHomeSubPlayers().get(1).getOverallRating())) index = 1;
				else if(assist2<(match.getPlayers().getHomeSubPlayers().get(0).getOverallRating()+
						match.getPlayers().getHomeSubPlayers().get(1).getOverallRating()+
						match.getPlayers().getHomeSubPlayers().get(2).getOverallRating())) index = 2;
				else if(assist2<(match.getPlayers().getHomeSubPlayers().get(0).getOverallRating()+
						match.getPlayers().getHomeSubPlayers().get(1).getOverallRating()+
						match.getPlayers().getHomeSubPlayers().get(2).getOverallRating()+
						match.getPlayers().getHomeSubPlayers().get(3).getOverallRating())-(
						match.getPlayers().getHomeSubPlayers().get(3).getOverallRating()-
						match.getPlayers().getHomeSubPlayers().get(2).getOverallRating())) index = 3;
				else if(assist2<(match.getPlayers().getHomeSubPlayers().get(0).getOverallRating()+
						match.getPlayers().getHomeSubPlayers().get(1).getOverallRating()+
						match.getPlayers().getHomeSubPlayers().get(2).getOverallRating()+
						match.getPlayers().getHomeSubPlayers().get(3).getOverallRating()+
						match.getPlayers().getHomeSubPlayers().get(4).getOverallRating())-(
						match.getPlayers().getHomeSubPlayers().get(4).getOverallRating()-
						match.getPlayers().getHomeSubPlayers().get(3).getOverallRating())) index = 4;
				
				match.getScore().getHomeAssists().put(match.getPlayers().getHomeSubPlayers().get(index), match.getScore().getHomeAssists().get(match.getPlayers().getHomeSubPlayers().get(index))+1);
				match.getPlayers().getHomeSubPlayers().get(index).getPlayerStatistics().setAssists(match.getPlayers().getHomeSubPlayers().get(index).getPlayerStatistics().getAssists()+1);
			}

			
		}
		else  {
			if((int) (Math.random()*20)>1) {
			if(assist1<match.getPlayers().getAwayPlayers().get(0).getOverallRating()) index = 0;
			else if(assist1<match.getPlayers().getAwayPlayers().get(0).getOverallRating()+
					match.getPlayers().getAwayPlayers().get(1).getOverallRating()+(
							match.getPlayers().getAwayPlayers().get(1).getOverallRating()-
							match.getPlayers().getAwayPlayers().get(0).getOverallRating())+(
									match.getPlayers().getAwayPlayers().get(1).getOverallRating()-
									match.getPlayers().getAwayPlayers().get(0).getOverallRating())+10) index = 1;
			else if(assist1<match.getPlayers().getAwayPlayers().get(0).getOverallRating()+
					match.getPlayers().getAwayPlayers().get(1).getOverallRating()+
					match.getPlayers().getAwayPlayers().get(2).getOverallRating()+(
							match.getPlayers().getAwayPlayers().get(2).getOverallRating()-
							match.getPlayers().getAwayPlayers().get(0).getOverallRating()+(
									match.getPlayers().getAwayPlayers().get(1).getOverallRating()-
									match.getPlayers().getAwayPlayers().get(0).getOverallRating()))+15) index = 2;
			else if(assist1<match.getPlayers().getAwayPlayers().get(0).getOverallRating()+
					match.getPlayers().getAwayPlayers().get(1).getOverallRating()+
					match.getPlayers().getAwayPlayers().get(2).getOverallRating()+
					match.getPlayers().getAwayPlayers().get(3).getOverallRating()+(
							match.getPlayers().getAwayPlayers().get(3).getOverallRating()-
							match.getPlayers().getAwayPlayers().get(0).getOverallRating()+(
									match.getPlayers().getAwayPlayers().get(2).getOverallRating()-
									match.getPlayers().getAwayPlayers().get(0).getOverallRating())+(
											match.getPlayers().getAwayPlayers().get(1).getOverallRating()-
											match.getPlayers().getAwayPlayers().get(0).getOverallRating()))+100)index = 3;
			else if(assist1<match.getPlayers().getAwayPlayers().get(0).getOverallRating()+
					match.getPlayers().getAwayPlayers().get(1).getOverallRating()+
					match.getPlayers().getAwayPlayers().get(2).getOverallRating()+
					match.getPlayers().getAwayPlayers().get(3).getOverallRating()+
					match.getPlayers().getAwayPlayers().get(4).getOverallRating()+(
							match.getPlayers().getAwayPlayers().get(4).getOverallRating()-
							match.getPlayers().getAwayPlayers().get(0).getOverallRating()+(
									match.getPlayers().getAwayPlayers().get(3).getOverallRating()-
									match.getPlayers().getAwayPlayers().get(0).getOverallRating())+(
											match.getPlayers().getAwayPlayers().get(2).getOverallRating()-
											match.getPlayers().getAwayPlayers().get(0).getOverallRating())+(
													match.getPlayers().getAwayPlayers().get(1).getOverallRating()-
													match.getPlayers().getAwayPlayers().get(0).getOverallRating()))+200) index = 4;
			
			match.getScore().getAwayAssists().put(match.getPlayers().getAwayPlayers().get(index), match.getScore().getAwayAssists().get(match.getPlayers().getAwayPlayers().get(index))+1);
			match.getPlayers().getAwayPlayers().get(index).getPlayerStatistics().setAssists(match.getPlayers().getAwayPlayers().get(index).getPlayerStatistics().getAssists()+1);
		}
		else {
			if(assist3<match.getPlayers().getAwaySubPlayers().get(0).getOverallRating()) index = 0;
			else if(assist3<(match.getPlayers().getAwaySubPlayers().get(0).getOverallRating()+
					match.getPlayers().getAwaySubPlayers().get(1).getOverallRating())) index = 1;
			else if(assist3<(match.getPlayers().getAwaySubPlayers().get(0).getOverallRating()+
					match.getPlayers().getAwaySubPlayers().get(1).getOverallRating()+
					match.getPlayers().getAwaySubPlayers().get(2).getOverallRating())) index = 2;
			else if(assist3<(match.getPlayers().getAwaySubPlayers().get(0).getOverallRating()+
					match.getPlayers().getAwaySubPlayers().get(1).getOverallRating()+
					match.getPlayers().getAwaySubPlayers().get(2).getOverallRating()+
					match.getPlayers().getAwaySubPlayers().get(3).getOverallRating())) index = 3;
			else if(assist3<(match.getPlayers().getAwaySubPlayers().get(0).getOverallRating()+
					match.getPlayers().getAwaySubPlayers().get(1).getOverallRating()+
					match.getPlayers().getAwaySubPlayers().get(2).getOverallRating()+
					match.getPlayers().getAwaySubPlayers().get(3).getOverallRating()+
					match.getPlayers().getAwaySubPlayers().get(4).getOverallRating())) index = 4;
			
			match.getScore().getAwayAssists().put(match.getPlayers().getAwaySubPlayers().get(index), match.getScore().getAwayAssists().get(match.getPlayers().getAwaySubPlayers().get(index))+1);
			match.getPlayers().getAwaySubPlayers().get(index).getPlayerStatistics().setAssists(match.getPlayers().getAwaySubPlayers().get(index).getPlayerStatistics().getAssists()+1);
		
		}
		}
	}
	public static ArrayList<String> rotate(ArrayList<String> aL, int shift){
		 
		 String element = "N";
		 
		 for(int i = 0; i < shift; i++) {
		        // remove last element, add it to front of the ArrayList
		        element = aL.remove( aL.size() - 1 );
		        aL.add(0, element);
		    }

		    return aL;

	}
}


