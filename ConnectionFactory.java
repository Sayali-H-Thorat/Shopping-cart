package com.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory 
{
	public static Connection getMySqlConnection() throws ClassNotFoundException, SQLException
	{
		Connection con = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"shopping_cartdb?autoReconnect=true&SSL=false","root","root");
		return con;
		
	}
}


