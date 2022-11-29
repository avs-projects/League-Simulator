package factory;

import java.sql.Connection;

import dao.DAO;
import dao.PlayerDAO;
import dao.SdzConnection;
import dao.TeamDAO;
import data.basketteam.BasketballTeam;
import data.player.Player;

public class DAOFactory extends AbstractDAOFactory {
	
	protected static final Connection conn = SdzConnection.getInstance();

	@Override
	public DAO<BasketballTeam> getTeamDAO() {
		// TODO Auto-generated method stub
		return new TeamDAO(conn);
	}

	@Override
	public DAO<Player> getPlayerDAO() {
		// TODO Auto-generated method stub
		return new PlayerDAO(conn);
	}   

}


