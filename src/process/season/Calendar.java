package process.season;

import java.util.ArrayList;

import data.calendar.Date;
import data.match.Match;

public class Calendar {
	
	private static ArrayList <Date> annee = new ArrayList <Date>();

	private static String [] days = new String [] {
			
			"Lundi" , "Mardi" , "Mercredi" , "Jeudi",
			
			"Vendredi" , "Samedi" ,"Dimanche"
			
		};
		
	private static String [] month = new String [] {
				
			"Octobre","Novembre", "Decembre","Janvier",
			
			"Fevrier","Mars","Avril","Mai",
			
			
		};
		
	private static int[] nbdays = {
				 
				31, 30, 31, 31,    
	 
	            28, 31, 30, 31,
	 
	    };
		
	public Calendar () {
		
	}
	
	/**
	 * Create a calendar which will contains every match.
	 * 
	 */
	
	public static ArrayList<Date> createCalendar() {
		
		int rand = (int) (Math.random()* days.length);
		for(int year=2020; year<2026; year++) {
			for (int i = 0; i < month.length; i++) {
				int nbjour = nbdays [i];
				for (int j = 0 ; j < nbjour; j++) {
					if (i==0 && j==0) {
						j = (int) (Math.random()* nbdays[0]); 
					}
					Date journee = new Date(j+1, days[rand], month[i], year, new ArrayList <Match>());
					annee.add(journee);
					rand++;
					if (rand>6) {
						rand=0;
					}
				}	
			}
		}
		return annee;		
	}
	
}
