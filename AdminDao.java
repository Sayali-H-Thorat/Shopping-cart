package com.dao;

public interface AdminDao 
{
	public void addVendor(String username, String email,String pass, String address);
	public void addCategory(String catId,String catName);
	public void deleteVendor(String email);
	

}
