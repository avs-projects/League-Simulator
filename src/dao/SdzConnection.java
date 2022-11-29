package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SdzConnection{

	private String url = "jdbc:sqlite:./src/league";
	private static Connection connect;
 
	private SdzConnection(){
		try {
			connect = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
 
	public static Connection getInstance(){
		if(connect == null){
			new SdzConnection();
		}
		return connect;   
	}   
}