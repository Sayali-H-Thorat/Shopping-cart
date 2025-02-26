package com.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.configuration.ConnectionFactory;
import com.dao.CategoryDao;

public class CategoryDaoImplementation implements CategoryDao
{

	ConnectionFactory cf;
	@Override
	public void view_categories() 
	{
		Connection con = null;
		try
		{
			con = cf.getMySqlConnection();
			String sql = "select cat_id,cat_name from category";
			PreparedStatement ps =con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String catId = rs.getString("cat_id");
				String catName = rs.getString("cat_name");
				System.out.println("Category id:"+catId+"\tCategory Name:"+catName);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		
	}

}
