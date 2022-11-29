package process.season;

import data.match.Match;

public class AllStarEngine {
	
	/**
	 * Simulate a match with its scorers.
	 * 
	 * @param Unplayed match.
	 * @return Match played.
	 */
	
	public static Match simulateMatch(Match match) {
		
		int point = 0;
		int scoreA = 0;
		int scoreB = 0;

		for (int i = 0; i<60; i++) {
			
			if (i%2==0) {
				
				int tmp = (int) (Math.random()* 40);
				int tmp2 = 0;
				
				if(tmp<5) tmp2 = 0;
				else if (tmp<10) tmp2 = 1;
				else if(tmp<20) tmp2 = 2;
				else if(tmp<30) tmp2 = 3;
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
				
				if(i<15) match.getScore().getQuarterTimeHome().setFirstQT(match.getScore().getQuarterTimeHome().getFirstQT()+point);
				if(i>=15 && i<30) match.getScore().getQuarterTimeHome().setSecondQT(match.getScore().getQuarterTimeHome().getSecondQT()+point);
				if(i>=30 && i<45) match.getScore().getQuarterTimeHome().setThirdQT(match.getScore().getQuarterTimeHome().getThirdQT()+point);
				if(i>=45 && i<60) match.getScore().getQuarterTimeHome().setFourthQT(match.getScore().getQuarterTimeHome().getFourthQT()+point);
				
			}
			else {
				
				int tmp = (int) (Math.random()* 40);
				int tmp2 = 0;
				
				if(tmp<5) tmp2 = 0;
				else if(tmp<10) tmp2 = 1;	
				else if(tmp<20) tmp2 = 2;
				else if(tmp<30) tmp2 = 3;
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
				if(i<15) match.getScore().getQuarterTimeAway().setFirstQT(match.getScore().getQuarterTimeAway().getFirstQT()+point);
				if(i>=15 && i<30) match.getScore().getQuarterTimeAway().setSecondQT(match.getScore().getQuarterTimeAway().getSecondQT()+point);
				if(i>=30 && i<45) match.getScore().getQuarterTimeAway().setThirdQT(match.getScore().getQuarterTimeAway().getThirdQT()+point);
				if(i>=45 && i<60) match.getScore().getQuarterTimeAway().setFourthQT(match.getScore().getQuarterTimeAway().getFourthQT()+point);
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
				match.getScore().getHomeStats().setFreeThrow(match.getScore().getHomeStats().getFreeThrow()+1);

			}
		}
		
		return match;
		
		}
	
	/**
	 * Choose which player will score.
	 * 
	 * @param Unplayed match, number of points the player will score, with which team he will score .
	 */

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
											match.getPlayers().getHomePlayers().get(0).getOverallRating()))));
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
											match.getPlayers().getAwayPlayers().get(0).getOverallRating()))));
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
		if((int) (Math.random()*10)>4) {
		if(scorer<match.getPlayers().getHomePlayers().get(0).getOverallRating()) index = 0;
		else if(scorer<(match.getPlayers().getHomePlayers().get(0).getOverallRating()+
				match.getPlayers().getHomePlayers().get(1).getOverallRating())+(
						match.getPlayers().getHomePlayers().get(1).getOverallRating()-
						match.getPlayers().getHomePlayers().get(0).getOverallRating())) index = 1;
		else if(scorer<(match.getPlayers().getHomePlayers().get(0).getOverallRating()+
				match.getPlayers().getHomePlayers().get(1).getOverallRating()+
				match.getPlayers().getHomePlayers().get(2).getOverallRating())+(
						match.getPlayers().getHomePlayers().get(2).getOverallRating()-
						match.getPlayers().getHomePlayers().get(0).getOverallRating()+
						match.getPlayers().getHomePlayers().get(1).getOverallRating()-
						match.getPlayers().getHomePlayers().get(0).getOverallRating())) index = 2;
		else if(scorer<(match.getPlayers().getHomePlayers().get(0).getOverallRating()+
				match.getPlayers().getHomePlayers().get(1).getOverallRating()+
				match.getPlayers().getHomePlayers().get(2).getOverallRating()+
				match.getPlayers().getHomePlayers().get(3).getOverallRating())+(
						match.getPlayers().getHomePlayers().get(3).getOverallRating()-
						match.getPlayers().getHomePlayers().get(0).getOverallRating()+
						match.getPlayers().getHomePlayers().get(2).getOverallRating()-
						match.getPlayers().getHomePlayers().get(0).getOverallRating()+
						match.getPlayers().getHomePlayers().get(1).getOverallRating()-
						match.getPlayers().getHomePlayers().get(0).getOverallRating())) index = 3;
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
						match.getPlayers().getHomePlayers().get(0).getOverallRating())) index = 4;
		
		match.getScore().getHomeScorers().put(match.getPlayers().getHomePlayers().get(index), match.getScore().getHomeScorers().get(match.getPlayers().getHomePlayers().get(index))+point);
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
			}

		
		}
		else  {
		if((int) (Math.random()*10)>4) {
			if(scorer1<match.getPlayers().getAwayPlayers().get(0).getOverallRating()) index = 0;
			else if(scorer1<match.getPlayers().getAwayPlayers().get(0).getOverallRating()+
				match.getPlayers().getAwayPlayers().get(1).getOverallRating()+(
						match.getPlayers().getAwayPlayers().get(1).getOverallRating()-
						match.getPlayers().getAwayPlayers().get(0).getOverallRating())+(
								match.getPlayers().getAwayPlayers().get(1).getOverallRating()-
								match.getPlayers().getAwayPlayers().get(0).getOverallRating())) index = 1;
			else if(scorer1<match.getPlayers().getAwayPlayers().get(0).getOverallRating()+
				match.getPlayers().getAwayPlayers().get(1).getOverallRating()+
				match.getPlayers().getAwayPlayers().get(2).getOverallRating()+(
						match.getPlayers().getAwayPlayers().get(2).getOverallRating()-
						match.getPlayers().getAwayPlayers().get(0).getOverallRating()+(
								match.getPlayers().getAwayPlayers().get(1).getOverallRating()-
								match.getPlayers().getAwayPlayers().get(0).getOverallRating()))) index = 2;
			else if(scorer1<match.getPlayers().getAwayPlayers().get(0).getOverallRating()+
				match.getPlayers().getAwayPlayers().get(1).getOverallRating()+
				match.getPlayers().getAwayPlayers().get(2).getOverallRating()+
				match.getPlayers().getAwayPlayers().get(3).getOverallRating()+(
						match.getPlayers().getAwayPlayers().get(3).getOverallRating()-
						match.getPlayers().getAwayPlayers().get(0).getOverallRating()+(
								match.getPlayers().getAwayPlayers().get(2).getOverallRating()-
								match.getPlayers().getAwayPlayers().get(0).getOverallRating())+(
										match.getPlayers().getAwayPlayers().get(1).getOverallRating()-
										match.getPlayers().getAwayPlayers().get(0).getOverallRating())))index = 3;
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
												match.getPlayers().getAwayPlayers().get(0).getOverallRating()))) index = 4;
			match.getScore().getAwayScorers().put(match.getPlayers().getAwayPlayers().get(index), match.getScore().getAwayScorers().get(match.getPlayers().getAwayPlayers().get(index))+point);
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
	
			}
		}
	}
	
	/**
	 * Choose which player will have the assist.
	 * 
	 * @param Unplayed match, with which team he will score .
	 */

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
											match.getPlayers().getHomePlayers().get(0).getOverallRating()))));
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
											match.getPlayers().getAwayPlayers().get(0).getOverallRating()))));
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
		if((int) (Math.random()*20)>8) {
		if(assist<match.getPlayers().getHomePlayers().get(0).getOverallRating()) index = 0;
		else if(assist<(match.getPlayers().getHomePlayers().get(0).getOverallRating()+
				match.getPlayers().getHomePlayers().get(1).getOverallRating())+(
						match.getPlayers().getHomePlayers().get(1).getOverallRating()-
						match.getPlayers().getHomePlayers().get(0).getOverallRating())) index = 1;
		else if(assist<(match.getPlayers().getHomePlayers().get(0).getOverallRating()+
				match.getPlayers().getHomePlayers().get(1).getOverallRating()+
				match.getPlayers().getHomePlayers().get(2).getOverallRating())+(
						match.getPlayers().getHomePlayers().get(2).getOverallRating()-
						match.getPlayers().getHomePlayers().get(0).getOverallRating()+
						match.getPlayers().getHomePlayers().get(1).getOverallRating()-
						match.getPlayers().getHomePlayers().get(0).getOverallRating())) index = 2;
		else if(assist<(match.getPlayers().getHomePlayers().get(0).getOverallRating()+
				match.getPlayers().getHomePlayers().get(1).getOverallRating()+
				match.getPlayers().getHomePlayers().get(2).getOverallRating()+
				match.getPlayers().getHomePlayers().get(3).getOverallRating())+(
						match.getPlayers().getHomePlayers().get(3).getOverallRating()-
						match.getPlayers().getHomePlayers().get(0).getOverallRating()+
						match.getPlayers().getHomePlayers().get(2).getOverallRating()-
						match.getPlayers().getHomePlayers().get(0).getOverallRating()+
						match.getPlayers().getHomePlayers().get(1).getOverallRating()-
						match.getPlayers().getHomePlayers().get(0).getOverallRating())) index = 3;
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
						match.getPlayers().getHomePlayers().get(0).getOverallRating())) index = 4;
		
		match.getScore().getHomeAssists().put(match.getPlayers().getHomePlayers().get(index), match.getScore().getHomeAssists().get(match.getPlayers().getHomePlayers().get(index))+1);
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
		}

		
	}
	else  {
		if((int) (Math.random()*20)>8) {
		if(assist1<match.getPlayers().getAwayPlayers().get(0).getOverallRating()) index = 0;
		else if(assist1<match.getPlayers().getAwayPlayers().get(0).getOverallRating()+
				match.getPlayers().getAwayPlayers().get(1).getOverallRating()+(
						match.getPlayers().getAwayPlayers().get(1).getOverallRating()-
						match.getPlayers().getAwayPlayers().get(0).getOverallRating())+(
								match.getPlayers().getAwayPlayers().get(1).getOverallRating()-
								match.getPlayers().getAwayPlayers().get(0).getOverallRating())) index = 1;
		else if(assist1<match.getPlayers().getAwayPlayers().get(0).getOverallRating()+
				match.getPlayers().getAwayPlayers().get(1).getOverallRating()+
				match.getPlayers().getAwayPlayers().get(2).getOverallRating()+(
						match.getPlayers().getAwayPlayers().get(2).getOverallRating()-
						match.getPlayers().getAwayPlayers().get(0).getOverallRating()+(
								match.getPlayers().getAwayPlayers().get(1).getOverallRating()-
								match.getPlayers().getAwayPlayers().get(0).getOverallRating()))) index = 2;
		else if(assist1<match.getPlayers().getAwayPlayers().get(0).getOverallRating()+
				match.getPlayers().getAwayPlayers().get(1).getOverallRating()+
				match.getPlayers().getAwayPlayers().get(2).getOverallRating()+
				match.getPlayers().getAwayPlayers().get(3).getOverallRating()+(
						match.getPlayers().getAwayPlayers().get(3).getOverallRating()-
						match.getPlayers().getAwayPlayers().get(0).getOverallRating()+(
								match.getPlayers().getAwayPlayers().get(2).getOverallRating()-
								match.getPlayers().getAwayPlayers().get(0).getOverallRating())+(
										match.getPlayers().getAwayPlayers().get(1).getOverallRating()-
										match.getPlayers().getAwayPlayers().get(0).getOverallRating())))index = 3;
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
												match.getPlayers().getAwayPlayers().get(0).getOverallRating()))) index = 4;
		
		match.getScore().getAwayAssists().put(match.getPlayers().getAwayPlayers().get(index), match.getScore().getAwayAssists().get(match.getPlayers().getAwayPlayers().get(index))+1);

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
	
	}
	}
}

}
