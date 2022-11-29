package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.player.Player;
import data.player.PlayerStatistics;

public class PlayerDAO extends DAO<Player>{
	
	public PlayerDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Player obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Player obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Player obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Player find(int id) {
		Player player = new Player();      
	      
	    try {
	      ResultSet result = this.connect.createStatement(
	    		  ResultSet.TYPE_FORWARD_ONLY,
	        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM districts WHERE Player_id = " + id);
	      if(result.next())
	        player = new Player(id,
	        		result.getString("Player_Name"), 
	        		result.getInt("Player_Age"),
	        		result.getInt("Player_Rating"),
	      			result.getString("Player_Position"),
	      			new PlayerStatistics(),
	      			0,
	      			0);
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    
	    return player;
	}

}
