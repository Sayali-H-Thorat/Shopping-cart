package com.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.configuration.ConnectionFactory;
import com.dao.VendorDao;

public class VendorDaoImplementation implements VendorDao
{
	ConnectionFactory cf;
	
	public VendorDaoImplementation()
	{
		cf = new ConnectionFactory();
	}

	@Override
	public void add_product(String product_id, String p_name, String cat_id, double price, int quantity, String email) 
	{
		Connection con = null;
		
		try
		{
			con = cf.getMySqlConnection();
			String sql = "insert into product(product_id,p_name,cat_id,price,quantity,email) values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product_id);
			ps.setString(2, p_name);
			ps.setString(3, cat_id);
			ps.setDouble(4, price);
			ps.setInt(5, quantity);
			ps.setString(6, email);			
			int rows = ps.executeUpdate();
			if(rows>0)
			{
				System.out.println("Your product added successfully...");
			}
			else
			{
				System.out.println("Failed to add product..");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void view_products(String email) 
	{
		Connection con = null;
		
		try
		{
			con = cf.getMySqlConnection();
			String sql ="select * from product where email = ?";
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			System.out.println("-------------Your Products are-------");
			while(rs.next())
			{
				String pId = rs.getString("product_id");
				String pName = rs.getString("p_name");
				String catId = rs.getString("cat_id");
				Double price = rs.getDouble("price");
				int quantity =rs.getInt("quantity");
				System.out.println("Product Id:"+pId+"\tProduct Name:"+pName+"\tCategory Id:"+catId+"\tPrice:"+price+"\tQuantity"+quantity);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	
}
