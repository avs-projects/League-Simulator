package factory;

import dao.DAO;
import data.basketteam.BasketballTeam;
import data.player.Player;

public abstract class AbstractDAOFactory {
	
	public static final int DAO_FACTORY = 0;

	public abstract DAO<BasketballTeam> getTeamDAO();
   
 	public abstract DAO<Player> getPlayerDAO();
   
    public static AbstractDAOFactory getFactory(int type){
    	
 		switch(type){
 			case DAO_FACTORY:
 				return new DAOFactory();
 			default:
 				return null;
 		}
 	}
}