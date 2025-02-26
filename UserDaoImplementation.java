package com.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.configuration.ConnectionFactory;
import com.dao.UserDao;
import com.modelclasses.Users;

public class UserDaoImplementation implements UserDao {

	ConnectionFactory cf;
	
	public UserDaoImplementation()
	{
		cf = new ConnectionFactory();
	}

	@Override
	public Users loginUser(String email, String pass) 
	{
		
		Connection con = null;
		
		try {
			con = ConnectionFactory.getMySqlConnection();
			String sql = "select * from users where email = ? and pass = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return new Users(rs.getString("user_name"),rs.getString("email"),rs.getString("pass"),rs.getString("u_role"),rs.getString("address"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void showVendors() 
	{
		Connection con = null;
		
		try
		{
			con = cf.getMySqlConnection();
			String sql = "Select * from users where u_role = 'Vendor'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();
			while(rs.next())
			{
				String uName = rs.getString("user_name");
				String uEmail = rs.getString("email");
				String uPass = rs.getString("pass");
				String uAddress = rs.getString("address");
				System.out.println("Vendor Name:"+uName+"\tEmail:"+uEmail+"\tPassword:"+uPass+"\tAddress:"+uAddress);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void showCustomers() 
	{
		Connection con = null;
		
		try
		{
			con = cf.getMySqlConnection();
			String sql = "Select * from users where u_role = 'Customer'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();
			while(rs.next())
			{
				String uName = rs.getString("user_name");
				String uEmail = rs.getString("email");
				String uPass = rs.getString("pass");
				String uAddress = rs.getString("address");
				System.out.println("Customer Name:"+uName+"\tEmail:"+uEmail+"\tPassword:"+uPass+"\tAddress:"+uAddress);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	@Override
	public boolean registerCustomer(String cName,String cEmail,String cPass,String cAddress) 
	{
		Connection con;
		
		try
		{
			con=cf.getMySqlConnection();
			String chkSql = "select * from users where email = ?";
			PreparedStatement chkPs = con.prepareStatement(chkSql);
			chkPs.setString(1,cEmail);
			
			ResultSet rs = chkPs.executeQuery();
			if(rs.next())
			{
				System.out.println("Email already registered..Try with another Email");
			}
			
			String sql = "insert into users(user_name,email,pass,u_role,address) values(?,?,?,'Customer',?) ";
			PreparedStatement sqlPs = con.prepareStatement(sql);
			sqlPs.setString(1, cName);
			sqlPs.setString(2, cEmail);
			sqlPs.setString(3, cPass);
			sqlPs.setString(4, cAddress);
			sqlPs.executeUpdate();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

}
