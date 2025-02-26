package com.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.configuration.ConnectionFactory;
import com.dao.AdminDao;

public class AdminDaoImplementation implements AdminDao
{

	ConnectionFactory cf;
	public AdminDaoImplementation()
	{
		cf = new ConnectionFactory();
		
	}
	
	@Override
	public void addVendor(String username, String email, String pass, String address) 
	{
		Connection con = null;
		
		try 
		{
			con = cf.getMySqlConnection();
			String sql = "insert into users(user_name,email,pass,u_role,address) values(?,?,?,'Vendor',?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, email);
			ps.setString(3, pass);
			ps.setString(4,address);
			ps.executeUpdate();
			System.out.println("Vendor added successfully...");
			System.out.println("----------------------------------------------------------------------");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void addCategory(String catId, String catName) 
	{
		Connection con = null;
		
		try
		{
			con = cf.getMySqlConnection();
			String sql = "insert into category(cat_id,cat_name) values(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, catId);
			ps.setString(2, catName);
			
			int rows = ps.executeUpdate();
			if(rows>0)
			{
				System.out.println("Category added successfully...");
			}
			else
			{
				System.out.println("Failed to add category..");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void deleteVendor(String email) 
	{
		Connection con = null;
		
		try
		{
			con = cf.getMySqlConnection();
			String sql = "delete from users where email = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			int rows = ps.executeUpdate();
			if(rows>0)
			{
				System.out.println("Vendor with "+email+" gets deleted successfully..");
			}
			else
			{
				System.out.println("Vendor not found...");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}


}
