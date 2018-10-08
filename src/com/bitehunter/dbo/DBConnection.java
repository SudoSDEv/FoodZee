package com.bitehunter.dbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getSQLConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdevdb","root","mysql");
		return connection;
	}
	
	public static void closeConnection(Connection c)
	{
		if(c!=null)
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void closeResultSet(ResultSet c)
	{
		if(c!=null)
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void closePreparedConnection(PreparedStatement c)
	{
		if(c!=null)
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
