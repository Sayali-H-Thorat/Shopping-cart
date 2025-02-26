package com.dao;

public interface VendorDao
{
	public void add_product(String product_id,String p_name,String cat_id,double price,int quantity,String email);
	public void view_products(String email);
	

}
