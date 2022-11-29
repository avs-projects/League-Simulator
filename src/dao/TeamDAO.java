package dao;

import java.sql.Connection;
import java.sql.ResultSet;

import data.basketteam.BasketballTeam;
import data.basketteam.TeamCoach;
import data.basketteam.TeamLocation;
import data.budget.Budget;

public class TeamDAO extends DAO<BasketballTeam> {
	
	public TeamDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(BasketballTeam obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(BasketballTeam obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(BasketballTeam obj) {
		// TODO Auto-generated method stub 
		return false;
	}

	@Override
	public BasketballTeam find(int id) {
		BasketballTeam basketTeam = new BasketballTeam();
		TeamLocation location = new TeamLocation();
		try {
			 ResultSet result = this.connect.createStatement(
				        ResultSet.TYPE_FORWARD_ONLY, 
				        ResultSet.CONCUR_READ_ONLY
				      ).executeQuery("SELECT * FROM data_team WHERE bsteam_id = " + id); 
			 ResultSet result2 = this.connect.createStatement(
				        ResultSet.TYPE_FORWARD_ONLY, 
				        ResultSet.CONCUR_READ_ONLY
				      ).executeQuery("SELECT * FROM data_team WHERE bsteam_id = " + id); 
			 
			 if(result.next()) {
				 location = new TeamLocation(result.getString("Location"),result.getString("Conference"),result.getString("Division"),null);
				 basketTeam = new BasketballTeam(id, result.getString("Team"), location ,null, result.getString("abr"),new Budget(),new TeamCoach());
				 PlayerDAO plyDao = new PlayerDAO(this.connect);
				 StadiumDAO stdDao = new StadiumDAO(this.connect);
				
				 result = this.connect.createStatement().executeQuery(
			                "SELECT * FROM districts " +
			                "INNER JOIN data_team ON Team_id = bsteam_id AND bsteam_id = " + id
			        );
				 result2 = this.connect.createStatement().executeQuery(
			                "SELECT * FROM stadium " +
			                "INNER JOIN data_team ON Team_id = bsteam_id AND bsteam_id = " + id
			        );
			        while(result.next())  {       
					          basketTeam.add(plyDao.find(result.getInt("Player_id")));
			        		
			        }
			        while(result2.next()) {
			        		basketTeam.getLocation().setStadium(stdDao.find(result2.getInt("team_id")));
			        }

			
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return basketTeam;
	}

}
