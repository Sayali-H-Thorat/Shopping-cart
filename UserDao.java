package com.dao;

import java.util.Set;

import com.modelclasses.Users;


public interface UserDao 
{
	public Users loginUser(String email,String pass);
	public void showVendors();
	public void showCustomers();
	public boolean registerCustomer(String cName, String cEmail, String cPass, String cAddress);

}
