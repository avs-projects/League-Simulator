package dao;

import java.sql.*;

public class ConnectTest {
	  public static void main (String[] args) {
	Connection co = null;
	
	try {
		Class.forName("org.sqlite.JDBC");
		System.out.println("Driver O.K.");
		
		String url = "jdbc:sqlite:./src/league";
		co = DriverManager.getConnection(url);
		
		Statement state = (Statement) co.createStatement();
	      //L'objet ResultSet contient le résultat de la requête SQL
	      ResultSet result = state.executeQuery("SELECT * FROM stadium;");
	      //On récupère les MetaData
	      ResultSetMetaData resultMeta = (ResultSetMetaData) result.getMetaData();
	         
	      System.out.println("\n************");
	      //On affiche le nom des colonnes
	      for(int i = 1; i <= resultMeta.getColumnCount(); i++)
	        System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
	         
	      System.out.println("\n************");
	         
	      while(result.next()){         
	        for(int i = 1; i <= resultMeta.getColumnCount(); i++)
	          System.out.print("\t" + result.getObject(i).toString() + "\t |");
	            
	        System.out.println("\n---------------------------------");

	      }
	} catch (Exception e) {
		// TODO: handle exception
	}

	  }
}