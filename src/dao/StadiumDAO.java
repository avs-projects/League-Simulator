package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.basketteam.TeamStadium;

public class StadiumDAO extends DAO<TeamStadium> {
	
	public StadiumDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean create(TeamStadium obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(TeamStadium obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TeamStadium obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TeamStadium find(int id) {
		TeamStadium stadium = new TeamStadium();     
	      
	    try {
	      ResultSet result = this.connect.createStatement(
	        ResultSet.TYPE_FORWARD_ONLY,
	        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM stadium WHERE team_id = " + id);
	      if(result.next())
	        stadium = new TeamStadium(id,
	        		result.getString("stadium"), 
	        		result.getInt("capacity"),
	        		result.getInt("seat"));
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    
	    return stadium;
	}
}
	




