/**
 * 
 */
package com.advanz.advanz101assignment.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Mayank
 *
 */
public class ConnectionUtility {

	public static Statement getConnection() {
		Connection conection = null;
		Statement statement = null;
		try {
			Class.forName("org.postgresql.Driver");
			conection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/advanz", "postgres", "admin");
			if(conection != null)
				statement = conection.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return statement;
		
	}
}
