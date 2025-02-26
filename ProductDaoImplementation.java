package com.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.configuration.ConnectionFactory;
import com.dao.ProductDao;
import com.modelclasses.Product;

public class ProductDaoImplementation implements ProductDao
{
	ConnectionFactory cf;
	
	public ProductDaoImplementation()
	{
		cf = new ConnectionFactory();
	}

	@Override
	public void viewProducts() 
	{
		Connection con = null;
		
		try
		{
			con = cf.getMySqlConnection();
			String sql = "select * from product";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next())
			{
				String pId = rs.getString("product_id");
				String  pName = rs.getString("p_name");
				String catId = rs.getString("cat_id");
				Double pPrice = rs.getDouble("price");
				Integer pQuantity = rs.getInt("quantity");
				System.out.println("Product Id:"+pId+"\tProduct Name:"+pName+"\tCategory Id:"+catId+"\tPrice:"+pPrice+"\tQuantity"+pQuantity);
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Product> view_products() 
	{
		Connection con=null;
		ArrayList<Product> pList = new ArrayList<>();
		
		try
		{
			con=cf.getMySqlConnection();
			String sql = "select * from product";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
//			System.out.println("---------------Product are--------------");
			while(rs.next())
			{
				String pId = rs.getString("product_id");
				String pName = rs.getString("p_name");
				String catId = rs.getString("cat_id");
				Double pPrice = rs.getDouble("price");
				Integer pQuantity = rs.getInt("quantity");
				String email = rs.getString("email");
				
				Product product = new Product(pId,pName,catId,pPrice,pQuantity,email);
				pList.add(product);
			}	
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return pList;
	}

}
