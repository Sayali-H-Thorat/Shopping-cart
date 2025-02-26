package com.configuration;

import java.sql.Connection;
import java.sql.SQLException;

public class CheckConnection
{
static Connection con;
	
	static
	{
		
			try 
			{
				con = ConnectionFactory.getMySqlConnection();
				System.out.println(con);
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				
				e.printStackTrace();
			}
	}
	

	public static void main(String[] args) 
	{
		

	}


}
