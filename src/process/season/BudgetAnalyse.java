package process.season;

import java.util.ArrayList;
import java.util.Map;

import data.basketteam.BasketballTeam;
import data.basketteam.Commissioner;
import data.calendar.Date;
import data.match.Match;

public class BudgetAnalyse {
	
	/**
	 * Share the earnings from TVRight for each team.
	 * 
	 * @param List of teams, the League commissioner, List of western conference teams, List of eastern conference Team.
	 */
	
	public static void payment(ArrayList<BasketballTeam> teams, Commissioner commissioner, BasketballTeam westernConference[], BasketballTeam easternConference[]) {
		long tvRight = commissioner.getTvRight()/2;
		commissioner.setTvRight(commissioner.getTvRight()/2);
		
		double equalShare = tvRight*0.40;
		double facilityFees = tvRight*0.30;
		double meritPayment = tvRight*0.30;
		
		BasketballTeam Viewers[] = new BasketballTeam[30];
		
		for(int i=0; i<teams.size();i++) {
			Viewers[i] = teams.get(i);
		}
		
		tri(Viewers);
		
		for(int i=0; i<teams.size();i++) {
			teams.get(i).getBudget().getEarnings().getTvRight().setEqualShare((long)(equalShare/30));
			teams.get(i).getBudget().getEarnings().getTvRight().setTvRight(teams.get(i).getBudget().getEarnings().getTvRight().getTvRight()+(int)(equalShare/30));
			teams.get(i).getBudget().setBudget(teams.get(i).getBudget().getBudget()+(int)(equalShare/30));
		}
		
		double a = 0.02;
		
		double tmpfacilityFees = tvRight*0.30;
		double tmpmeritPayment = (tvRight*0.30)/2;
		
		for(int i=29;(i+1)!=0;i--) {
			Viewers[i].getBudget().getEarnings().getTvRight().setFacilityFees((long)(facilityFees*a));
			Viewers[i].getBudget().getEarnings().getTvRight().setTvRight(Viewers[i].getBudget().getEarnings().getTvRight().getTvRight()+(int)(facilityFees*a));	
			Viewers[i].getBudget().setBudget(Viewers[i].getBudget().getBudget()+(int)(facilityFees*a));
			tmpfacilityFees = tmpfacilityFees - facilityFees*a;
			a=a+0.000925;
		}
		
		Viewers[0].getBudget().getEarnings().getTvRight().setFacilityFees((long)(Viewers[0].getBudget().getEarnings().getTvRight().getFacilityFees()+tmpfacilityFees));
		Viewers[0].getBudget().getEarnings().getTvRight().setTvRight(Viewers[0].getBudget().getEarnings().getTvRight().getTvRight()+(int)tmpfacilityFees);	
		Viewers[0].getBudget().setBudget(Viewers[0].getBudget().getBudget()+(int)tmpfacilityFees);

		a = 0.015;
		for(int i=14;(i+1)!=0;i--) {
			westernConference[i].getBudget().getEarnings().getTvRight().setMeritPayment((long)(meritPayment*a));
			westernConference[i].getBudget().getEarnings().getTvRight().setTvRight(westernConference[i].getBudget().getEarnings().getTvRight().getTvRight()+(int)(meritPayment*a));	
			westernConference[i].getBudget().setBudget(westernConference[i].getBudget().getBudget()+(int)(meritPayment*a));
			tmpmeritPayment = tmpmeritPayment - meritPayment*a;
			a=a+0.00262;
		}	
		westernConference[0].getBudget().getEarnings().getTvRight().setMeritPayment((long)(westernConference[0].getBudget().getEarnings().getTvRight().getMeritPayment()+tmpmeritPayment));
		westernConference[0].getBudget().getEarnings().getTvRight().setTvRight(westernConference[0].getBudget().getEarnings().getTvRight().getTvRight()+(int)(tmpmeritPayment));	
		westernConference[0].getBudget().setBudget(westernConference[0].getBudget().getBudget()+(int)(tmpmeritPayment));
		
		tmpmeritPayment = (tvRight*0.30)/2;
		
		a = 0.015;
		for(int i=14;(i+1)!=0;i--) {
			easternConference[i].getBudget().getEarnings().getTvRight().setMeritPayment((long)(meritPayment*a));
			easternConference[i].getBudget().getEarnings().getTvRight().setTvRight(easternConference[i].getBudget().getEarnings().getTvRight().getTvRight()+(int)(meritPayment*a));	
			easternConference[i].getBudget().setBudget(easternConference[i].getBudget().getBudget()+(int)(meritPayment*a));
			tmpmeritPayment = tmpmeritPayment - meritPayment*a;

			a=a+0.00262;
		}	
		
		easternConference[0].getBudget().getEarnings().getTvRight().setMeritPayment((long)(easternConference[0].getBudget().getEarnings().getTvRight().getMeritPayment()+tmpmeritPayment));
		easternConference[0].getBudget().getEarnings().getTvRight().setTvRight(easternConference[0].getBudget().getEarnings().getTvRight().getTvRight()+(int)(tmpmeritPayment));	
		easternConference[0].getBudget().setBudget(easternConference[0].getBudget().getBudget()+(int)(tmpmeritPayment));
	}
	
	/**
	 * Describes how many tickets the home team will sell.
	 * 
	 * @param number of days, unplayed match, List of matchs, the commissioner.
	 */
	
	public static void seatSellingEvent (int nbjourney, Match match, ArrayList <Date> games, String step,Commissioner commissioner) {
		int gains = 0;
		int basicTicketPrice = match.getTeams().getHomeTeam().getLocation().getStadium().getSeatPrice();
		int ticketPrice = match.getTeams().getHomeTeam().getLocation().getStadium().getSeatPrice()*(((int) Math.random()*10)+5);
		
		if(!step.equals("AllStarGame")) {
			match.getTeams().getHomeTeam().getLocation().getStadium().setSeatPrice(ticketPrice);
			gains = (int) (match.getTeams().getHomeTeam().getLocation().getStadium().getCapacity()*match.getTeams().getHomeTeam().getLocation().getStadium().getSeatPrice());
			match.getTeams().getHomeTeam().getBudget().getEarnings().getTicketSales().setTicketSales(match.getTeams().getHomeTeam().getBudget().getEarnings().getTicketSales().getTicketSales()+gains);
		
			match.getBudget().getEarnings().setTicketSelling((int)(match.getTeams().getHomeTeam().getLocation().getStadium().getCapacity()));
			match.getBudget().getEarnings().setTicketEarnings(gains);
			
			match.getTeams().getHomeTeam().getBudget().add(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear(), (match.getTeams().getHomeTeam().getBudget().getEarnings().getEarningsPerMonth().getSeatSellingPerMonth()
					.get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).get(match.getTeams().getHomeTeam().getBudget().getEarnings().getEarningsPerMonth().getSeatSellingPerMonth().get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).size()-1)+gains),
					match.getTeams().getHomeTeam().getBudget().getEarnings().getEarningsPerMonth().getSeatSellingPerMonth());
		
			match.getTeams().getHomeTeam().getLocation().getStadium().setSeatPrice(basicTicketPrice);
			match.getTeams().getHomeTeam().getBudget().setBudget(match.getTeams().getHomeTeam().getBudget().getBudget()+gains);
		}
		else {
			match.getBudget().getEarnings().setTicketSelling((int)(match.getTeams().getHomeTeam().getLocation().getStadium().getCapacity()));
			match.getBudget().getEarnings().setTicketEarnings(gains);
			commissioner.setBudget(commissioner.getBudget()+gains);
		}
	}
	
	/**
	 * Describes how many teams will spend for the stadium rent and the travel.
	 * 
	 * @param number of days, unplayed match, List of matchs, which event will take place.
	 */
	
	public static void expensesEvent(int nbjourney, Match match, ArrayList <Date> games, String step) {
		
		int travel, travel2 = 0;
		
		int rent = match.getTeams().getHomeTeam().getLocation().getStadium().getCapacity()*(8 + ((int) (Math.random() * 6))+(int)(Math.random()*5)+2);
		match.getBudget().getExpenses().setStadiumRent((int)(rent));
		
			match.getTeams().getHomeTeam().getBudget().add(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear(),
					(match.getTeams().getHomeTeam().getBudget().getExpenses().getExpensesPerMonth().getLogisticPerMonth().get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).get(match.getTeams().getHomeTeam().getBudget().
							getExpenses().getExpensesPerMonth().getLogisticPerMonth().get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).size()-1)+rent),
					match.getTeams().getHomeTeam().getBudget().getExpenses().getExpensesPerMonth().getLogisticPerMonth());
			match.getTeams().getHomeTeam().getBudget().getExpenses().setLogistic(match.getTeams().getHomeTeam().getBudget().getExpenses().getLogistic()+rent);
			
			match.getTeams().getHomeTeam().getBudget().setBudget(match.getTeams().getHomeTeam().getBudget().getBudget()-rent);
		
		
		for (Map.Entry<String, Integer> i : match.getTeams().getHomeTeam().getBudget().getExpenses().getExpensesPerMonth().getLpm().getStadiumRent().entrySet()) {
			if (i.getKey().equals(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear())) {
				i.setValue(i.getValue()+rent);
			}
		}

		if(match.getTeams().getAwayTeam().getLocation().getConference().equals(match.getTeams().getHomeTeam().getLocation().getConference())) {
			if(match.getTeams().getAwayTeam().getLocation().getDivision().equals(match.getTeams().getHomeTeam().getLocation().getDivision())) {
				travel = 10000+((int) (Math.random() * 60)*100);
				travel2 = 20000+((int) (Math.random() * 20)*100);

			}
			
			else {
				travel = 10000+((int) (Math.random() * 60)*100);
				travel2 = 40000+((int) (Math.random() * 20)*1000);

			}
		}
		
		else {
			travel = 10000+((int) (Math.random() * 60)*100);
			travel2 = 50000+((int) (Math.random() * 50)*1000);

		}
		
		match.getTeams().getHomeTeam().getBudget().getExpenses().setLogistic(match.getTeams().getHomeTeam().getBudget().getExpenses().getLogistic()+travel);
		match.getBudget().getExpenses().setTravelHome(travel);
		match.getTeams().getAwayTeam().getBudget().getExpenses().setLogistic(match.getTeams().getAwayTeam().getBudget().getExpenses().getLogistic()+travel2);
		match.getBudget().getExpenses().setTravelAway(travel2);
		
		match.getTeams().getHomeTeam().getBudget().setBudget(match.getTeams().getHomeTeam().getBudget().getBudget()-travel);
		match.getTeams().getAwayTeam().getBudget().setBudget(match.getTeams().getAwayTeam().getBudget().getBudget()-travel2);


		match.getTeams().getHomeTeam().getBudget().add(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear(),
				(match.getTeams().getHomeTeam().getBudget().getExpenses().getExpensesPerMonth().getLogisticPerMonth().get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).get(match.getTeams().getHomeTeam().getBudget().
						getExpenses().getExpensesPerMonth().getLogisticPerMonth().get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).size()-1)+travel),
				match.getTeams().getHomeTeam().getBudget().getExpenses().getExpensesPerMonth().getLogisticPerMonth());
		match.getTeams().getAwayTeam().getBudget().add(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear(),
				(match.getTeams().getAwayTeam().getBudget().getExpenses().getExpensesPerMonth().getLogisticPerMonth().get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).get(match.getTeams().getAwayTeam().getBudget().
						getExpenses().getExpensesPerMonth().getLogisticPerMonth().get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).size()-1)+travel2),
				match.getTeams().getAwayTeam().getBudget().getExpenses().getExpensesPerMonth().getLogisticPerMonth());
		
		for (Map.Entry<String, Integer> i : match.getTeams().getHomeTeam().getBudget().getExpenses().getExpensesPerMonth().getLpm().getTravel().entrySet()) {
			if (i.getKey().equals(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear())) {
				i.setValue(i.getValue()+travel);
			}
		}
		for (Map.Entry<String, Integer> j : match.getTeams().getAwayTeam().getBudget().getExpenses().getExpensesPerMonth().getLpm().getTravel().entrySet()) {
			if (j.getKey().equals(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear())) {
				j.setValue(j.getValue()+travel2);
			}
		}
	}
	
	/**
	 * Describes how many teams will earn from TVRight and how many viewers they had.
	 * 
	 * @param which event take place, number of days, unplayed match, matches list, the commissioner.
	 */
	
	public static void tvRightEvent(String step, int nbjourney, Match match, ArrayList <Date> games, Commissioner commissioner) {
		Integer gains = 0;
		Integer Viewers = 0;
		
		if(step.equals("FirstRound") || step.equals("Christmas") || step.equals("AllStarGame")) {
			Viewers = (500000+(((int) (Math.random() * 50))+70)*100000);
			if(match.getTeams().getHomeTeam().getLocation().getDivision().equals(match.getTeams().getAwayTeam().getLocation().getDivision())) {
				Viewers =  (int)(Viewers*1.5);
			}
			gains = Viewers*2;
		}
		else if (step.equals("Semi") || step.equals("FinaleConference")) {
			Viewers = (500000+(((int) (Math.random() * 50))+120)*100000);
			if(match.getTeams().getHomeTeam().getLocation().getDivision().equals(match.getTeams().getAwayTeam().getLocation().getDivision())) {
				gains = (int)(Viewers*1.5);
			}
			gains = Viewers*2;
		}
		
		if(step.equals("FinaleNBA")) {
			Viewers = (500000+(((int) (Math.random() * 50))+220)*100000);
			if(match.getTeams().getHomeTeam().getLocation().getDivision().equals(match.getTeams().getAwayTeam().getLocation().getDivision())) {
				gains =  (int)(Viewers*1.5);
			}
			gains = Viewers*2;
		}
		
		if(!step.equals("AllStarGame")) {
		
		commissioner.setTvRight(commissioner.getTvRight()+(int)(gains*0.75));
		commissioner.setBudget(commissioner.getBudget()+(int) (gains*0.75));
		
		}
		
		else {
			commissioner.setTvRight(commissioner.getTvRight()+gains);
			commissioner.setBudget(commissioner.getBudget()+gains);
		}
		
		match.getTeams().getHomeTeam().getBudget().setBudget(match.getTeams().getHomeTeam().getBudget().getBudget()+(int)(gains*0.125));
		match.getTeams().getAwayTeam().getBudget().setBudget(match.getTeams().getAwayTeam().getBudget().getBudget()+(int)(gains*0.125));
		
		match.getBudget().getEarnings().setViewers(Viewers);
		
		match.getTeams().getHomeTeam().getBudget().getEarnings().getTvRight().setTvRight(match.getTeams().getHomeTeam().getBudget().getEarnings().getTvRight().getTvRight()+(int)(gains*0.125));
		match.getTeams().getAwayTeam().getBudget().getEarnings().getTvRight().setTvRight(match.getTeams().getAwayTeam().getBudget().getEarnings().getTvRight().getTvRight()+(int)(gains*0.125));
		
		match.getTeams().getHomeTeam().getBudget().getEarnings().getTvRight().setViewers(match.getTeams().getHomeTeam().getBudget().getEarnings().getTvRight().getViewers()+Viewers);
		match.getTeams().getAwayTeam().getBudget().getEarnings().getTvRight().setViewers(match.getTeams().getAwayTeam().getBudget().getEarnings().getTvRight().getViewers()+Viewers);

		match.getTeams().getHomeTeam().getBudget().add(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear(), 
			(match.getTeams().getHomeTeam().getBudget().getEarnings().getEarningsPerMonth().getTvRightPerMonth().get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).
			get(match.getTeams().getHomeTeam().getBudget().getEarnings().getEarningsPerMonth().getTvRightPerMonth().get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).size()-1)+(int)(gains*0.125)),
			match.getTeams().getHomeTeam().getBudget().getEarnings().getEarningsPerMonth().getTvRightPerMonth());
	
		match.getTeams().getAwayTeam().getBudget().add(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear(), 
			(match.getTeams().getAwayTeam().getBudget().getEarnings().getEarningsPerMonth().getTvRightPerMonth().get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).
			get(match.getTeams().getAwayTeam().getBudget().getEarnings().getEarningsPerMonth().getTvRightPerMonth().get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).size()-1)+(int)(gains*0.125)),
			match.getTeams().getAwayTeam().getBudget().getEarnings().getEarningsPerMonth().getTvRightPerMonth());
		
		
	}
	
	public static void seatSelling (int nbjourney, Match match, ArrayList <Date> games) {
		
		int gains = 0;
		double per = 0 ;
		if (nbjourney < 5) {
			per = ((Math.random() * 11)*0.01)+0.9;
		}
		else if (nbjourney >= 5) {
			
			if (match.getTeams().getHomeTeam().getRank().getRank()<=5) {
				per = ((Math.random() * 11)*0.01)+0.9;
			}
			else if (match.getTeams().getHomeTeam().getRank().getRank()>5 && match.getTeams().getHomeTeam().getRank().getRank()<10) {
				per = ((5+(Math.random() * 16))*0.005)+0.9;
				
			}
			else if (match.getTeams().getHomeTeam().getRank().getRank()>=10 && match.getTeams().getHomeTeam().getRank().getRank()<=15) {
				per = 0.9 + ((int) (Math.random() * 21))*0.005;
		
			}
		}
		
		gains = ((int) (match.getTeams().getHomeTeam().getLocation().getStadium().getCapacity()*per)*match.getTeams().getHomeTeam().getLocation().getStadium().getSeatPrice());
		match.getTeams().getHomeTeam().getBudget().getEarnings().getTicketSales().setTicketSales(match.getTeams().getHomeTeam().getBudget().getEarnings().getTicketSales().getTicketSales()+gains);
		match.getTeams().getHomeTeam().getBudget().setBudget(match.getTeams().getHomeTeam().getBudget().getBudget()+gains);
		
		match.getBudget().getEarnings().setTicketSelling((int)(match.getTeams().getHomeTeam().getLocation().getStadium().getCapacity()*per));
		match.getBudget().getEarnings().setTicketEarnings(gains);

		match.getTeams().getHomeTeam().getBudget().add(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear(), (match.getTeams().getHomeTeam().getBudget().getEarnings().getEarningsPerMonth().getSeatSellingPerMonth()
				.get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).get(match.getTeams().getHomeTeam().getBudget().getEarnings().getEarningsPerMonth().getSeatSellingPerMonth().get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).size()-1)+gains),
				match.getTeams().getHomeTeam().getBudget().getEarnings().getEarningsPerMonth().getSeatSellingPerMonth());
		
	}
	
	public static void expenses(int nbjourney, Match match, ArrayList <Date> games, String step) {
		
		int travel, travel2 = 0;
		int rent = match.getTeams().getHomeTeam().getLocation().getStadium().getCapacity()*(8 + ((int) (Math.random() * 6)));

		match.getBudget().getExpenses().setStadiumRent((int)(rent));
		
			match.getTeams().getHomeTeam().getBudget().add(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear(),
					(match.getTeams().getHomeTeam().getBudget().getExpenses().getExpensesPerMonth().getLogisticPerMonth().get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).get(match.getTeams().getHomeTeam().getBudget().
							getExpenses().getExpensesPerMonth().getLogisticPerMonth().get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).size()-1)+rent),
					match.getTeams().getHomeTeam().getBudget().getExpenses().getExpensesPerMonth().getLogisticPerMonth());
			match.getTeams().getHomeTeam().getBudget().getExpenses().setLogistic(match.getTeams().getHomeTeam().getBudget().getExpenses().getLogistic()+rent);

			match.getTeams().getHomeTeam().getBudget().setBudget(match.getTeams().getHomeTeam().getBudget().getBudget()-rent);

		
		
		for (Map.Entry<String, Integer> i : match.getTeams().getHomeTeam().getBudget().getExpenses().getExpensesPerMonth().getLpm().getStadiumRent().entrySet()) {
			if (i.getKey().equals(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear())) {
				i.setValue(i.getValue()+rent);
			}
		}

		if(match.getTeams().getAwayTeam().getLocation().getConference().equals(match.getTeams().getHomeTeam().getLocation().getConference())) {
			if(match.getTeams().getAwayTeam().getLocation().getDivision().equals(match.getTeams().getHomeTeam().getLocation().getDivision())) {
				travel = 10000+((int) (Math.random() * 60)*100);
				travel2 = 20000+((int) (Math.random() * 20)*100);

			}
			
			else {
				travel = 10000+((int) (Math.random() * 60)*100);
				travel2 = 40000+((int) (Math.random() * 20)*1000);

			}
		}
		
		else {
			travel = 10000+((int) (Math.random() * 60)*100);
			travel2 = 50000+((int) (Math.random() * 50)*1000);

		}
		
		match.getTeams().getHomeTeam().getBudget().getExpenses().setLogistic(match.getTeams().getHomeTeam().getBudget().getExpenses().getLogistic()+travel);
		match.getBudget().getExpenses().setTravelHome(travel);
		match.getTeams().getAwayTeam().getBudget().getExpenses().setLogistic(match.getTeams().getAwayTeam().getBudget().getExpenses().getLogistic()+travel2);
		match.getBudget().getExpenses().setTravelAway(travel2);
		
		match.getTeams().getHomeTeam().getBudget().setBudget(match.getTeams().getHomeTeam().getBudget().getBudget()-travel);
		match.getTeams().getAwayTeam().getBudget().setBudget(match.getTeams().getAwayTeam().getBudget().getBudget()-travel2);


		match.getTeams().getHomeTeam().getBudget().add(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear(),
				(match.getTeams().getHomeTeam().getBudget().getExpenses().getExpensesPerMonth().getLogisticPerMonth().get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).get(match.getTeams().getHomeTeam().getBudget().
						getExpenses().getExpensesPerMonth().getLogisticPerMonth().get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).size()-1)+travel),
				match.getTeams().getHomeTeam().getBudget().getExpenses().getExpensesPerMonth().getLogisticPerMonth());
		match.getTeams().getAwayTeam().getBudget().add(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear(),
				(match.getTeams().getAwayTeam().getBudget().getExpenses().getExpensesPerMonth().getLogisticPerMonth().get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).get(match.getTeams().getAwayTeam().getBudget().
						getExpenses().getExpensesPerMonth().getLogisticPerMonth().get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).size()-1)+travel2),
				match.getTeams().getAwayTeam().getBudget().getExpenses().getExpensesPerMonth().getLogisticPerMonth());
		
		for (Map.Entry<String, Integer> i : match.getTeams().getHomeTeam().getBudget().getExpenses().getExpensesPerMonth().getLpm().getTravel().entrySet()) {
			if (i.getKey().equals(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear())) {
				i.setValue(i.getValue()+travel);
			}
		}
		for (Map.Entry<String, Integer> j : match.getTeams().getAwayTeam().getBudget().getExpenses().getExpensesPerMonth().getLpm().getTravel().entrySet()) {
			if (j.getKey().equals(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear())) {
				j.setValue(j.getValue()+travel2);
			}
		}
	}
	
	public static void tvRight(int nbjourney, Match match, ArrayList <Date> games, Commissioner commissioner) {
		Integer gains = 0;
		Integer Viewers = 0;
		if (nbjourney < 5) {
			Viewers = (800000+(((int) (Math.random() * 50))+100)*10000);
			gains = (int) (Viewers*2.25); 
			
		}
		else if (nbjourney > 5) {
			if (match.getTeams().getHomeTeam().getRank().getRank()<=5) {
				Viewers = (500000+(((int) (Math.random() * 50))+100)*10000);
				gains = Viewers*2;
			}
			else if (match.getTeams().getHomeTeam().getRank().getRank()>5 && match.getTeams().getHomeTeam().getRank().getRank()<10) {
				Viewers = (500000+(((int) (Math.random() * 50))+80)*10000);
				gains = Viewers*2;		
			}
			else if (match.getTeams().getHomeTeam().getRank().getRank()>=10 && match.getTeams().getHomeTeam().getRank().getRank()<=15) {
				Viewers = (500000+(((int) (Math.random() * 50))+60)*10000);
				gains = Viewers*2;
			}
			if (match.getTeams().getAwayTeam().getRank().getRank()<=5) {
				Viewers = (int) (Viewers*2.5);
				gains = gains+Viewers;
			}
			else if (match.getTeams().getAwayTeam().getRank().getRank()>5 && match.getTeams().getAwayTeam().getRank().getRank()<10) {
				Viewers = (int) (Viewers*2);
				gains = gains+Viewers;
			}
			else if (match.getTeams().getAwayTeam().getRank().getRank()>=10 && match.getTeams().getAwayTeam().getRank().getRank()<=15) {
				Viewers = (int) (Viewers*1.75);
				gains = gains+Viewers;
				
				}
			
			if(match.getTeams().getAwayTeam().getLocation().getDivision().equals(match.getTeams().getHomeTeam().getLocation().getDivision())) {
				Viewers = (int) (Viewers*(Math.random()*3)+2);
				gains = gains+Viewers;
			}
		}
		
		commissioner.setTvRight(commissioner.getTvRight()+((int) (gains*0.75)));
		commissioner.setBudget(commissioner.getBudget()+((int) (gains*0.75)));
		
		match.getTeams().getHomeTeam().getBudget().setBudget(match.getTeams().getHomeTeam().getBudget().getBudget()+((int)(gains*0.125)));
		match.getTeams().getAwayTeam().getBudget().setBudget(match.getTeams().getAwayTeam().getBudget().getBudget()+((int)(gains*0.125)));
		
		match.getBudget().getEarnings().setViewers(Viewers);
		
		match.getTeams().getHomeTeam().getBudget().getEarnings().getTvRight().setTvRight(match.getTeams().getHomeTeam().getBudget().getEarnings().getTvRight().getTvRight()+((int)(gains*0.125)));
		match.getTeams().getAwayTeam().getBudget().getEarnings().getTvRight().setTvRight(match.getTeams().getAwayTeam().getBudget().getEarnings().getTvRight().getTvRight()+((int)(gains*0.125)));
		
		match.getTeams().getHomeTeam().getBudget().getEarnings().getTvRight().setViewers(match.getTeams().getHomeTeam().getBudget().getEarnings().getTvRight().getViewers()+Viewers);
		match.getTeams().getAwayTeam().getBudget().getEarnings().getTvRight().setViewers(match.getTeams().getAwayTeam().getBudget().getEarnings().getTvRight().getViewers()+Viewers);

		match.getTeams().getHomeTeam().getBudget().add(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear(), 
			(match.getTeams().getHomeTeam().getBudget().getEarnings().getEarningsPerMonth().getTvRightPerMonth().get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).
			get(match.getTeams().getHomeTeam().getBudget().getEarnings().getEarningsPerMonth().getTvRightPerMonth().get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).size()-1)+(int)(gains*0.125)),
			match.getTeams().getHomeTeam().getBudget().getEarnings().getEarningsPerMonth().getTvRightPerMonth());
	
		match.getTeams().getAwayTeam().getBudget().add(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear(), 
			(match.getTeams().getAwayTeam().getBudget().getEarnings().getEarningsPerMonth().getTvRightPerMonth().get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).
			get(match.getTeams().getAwayTeam().getBudget().getEarnings().getEarningsPerMonth().getTvRightPerMonth().get(games.get(nbjourney).getMonth()+games.get(nbjourney).getYear()).size()-1)+(int)(gains*0.125)),
			match.getTeams().getAwayTeam().getBudget().getEarnings().getEarningsPerMonth().getTvRightPerMonth());

	}
	
	/**
	 * Describes how many players and coaches will earn for the pay day.
	 * 
	 * @param Teams list, number of days, matches list, the luxury tax, the commissioner, which teams will pay the tax.
	 */
	
	public static void payday (ArrayList<BasketballTeam> teams, int nbjourney, ArrayList <Date> year, int luxuryTax, Commissioner commissioner, ArrayList<BasketballTeam> teamLuxuryTax) {
		int salary = 0;
			
		for (int i=0; i<30; i++) {
			salary = 0;
								
			for(int j=0; j<teams.get(i).getSquad().size();j++) {
				salary = salary + teams.get(i).getSquad().get(j).getSalary();
			}
			
			for (Map.Entry<String, Integer> j : teams.get(i).getBudget().getExpenses().getExpensesPerMonth().getSpm().getPlayersSalary().entrySet()) {
				if (j.getKey().equals(year.get(nbjourney).getMonth()+year.get(nbjourney).getYear())) {
					j.setValue(j.getValue()+salary);
				}
			}
				
			for (Map.Entry<String, Integer> k : teams.get(i).getBudget().getExpenses().getExpensesPerMonth().getSpm().getCoachSalary().entrySet()) {
				if (k.getKey().equals(year.get(nbjourney).getMonth()+year.get(nbjourney).getYear())) {
					k.setValue(k.getValue()+teams.get(i).getCoach().getSalary());
				}
			}
								
			teams.get(i).getBudget().setBudget(teams.get(i).getBudget().getBudget()-salary-teams.get(i).getCoach().getSalary());
								
			teams.get(i).getBudget().add(year.get(nbjourney).getMonth()+year.get(nbjourney).getYear(), 
					salary+teams.get(i).getCoach().getSalary(), teams.get(i).getBudget().getExpenses().getExpensesPerMonth().getSalaryPerMonth());
								
			teams.get(i).getBudget().getExpenses().setSalary((teams.get(i).getBudget().getExpenses().getSalary()+salary+teams.get(i).getCoach().getSalary()));

			if(salary*8>luxuryTax) {
				teamLuxuryTax.add(teams.get(i));
				if((salary*8-luxuryTax)>20000000) {
					commissioner.setLuxuryTax(commissioner.getLuxuryTax()+3.75*(salary*8-luxuryTax));
				}
				else if((salary*8-luxuryTax)>15000000) {
					commissioner.setLuxuryTax(commissioner.getLuxuryTax()+3.25*(salary*8-luxuryTax));
				}
				else if((salary*8-luxuryTax)>10000000) {
					commissioner.setLuxuryTax(commissioner.getLuxuryTax()+2.5*(salary*8-luxuryTax));
				}
				else if((salary*8-luxuryTax)>5000000) {
					commissioner.setLuxuryTax(commissioner.getLuxuryTax()+1.75*(salary*8-luxuryTax));
				}
				else {
					commissioner.setLuxuryTax(commissioner.getLuxuryTax()+1.5*(salary*8-luxuryTax));
				}
			}		
		}
	}

	
	public static void tri(BasketballTeam tableau[]) {
		int longueur = tableau.length;
		BasketballTeam tampon = null;
		boolean permut;
 
		do {
			permut = false;
			for (int i = 0; i < longueur - 1; i++) {
				float div=tableau[i].getBudget().getEarnings().getTvRight().getViewers();
				float div2= tableau[i + 1].getBudget().getEarnings().getTvRight().getViewers();		
				
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
