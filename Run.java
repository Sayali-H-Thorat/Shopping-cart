package com.client;

import java.util.Scanner;

import com.dao.UserDao;
import com.daoimplementation.UserDaoImplementation;
import com.menu.AdminMenu;
import com.menu.CustomerMenu;
import com.menu.VendorMenu;
import com.modelclasses.Users;

public class Run 
{
	public static void main(String[] args) 
	{

		Scanner sobj = new Scanner(System.in);
		UserDaoImplementation udao = new UserDaoImplementation();
		while(true)
		{
			System.out.println("------------------------Welcome to Shopping Cart----------------------");
			System.out.println("1:Login");
			System.out.println("2:Register as Customer");
			System.out.println("3.Exit");
			System.out.println("----------------------------------------------------------------------");
			System.out.println("Enter your choice:");
			int choice = sobj.nextInt();
			sobj.nextLine();		
			System.out.println("----------------------------------------------------------------------");
			switch(choice)
			{
			case 1:System.out.println("Enter email:");
					String email = sobj.nextLine();
					System.out.println("Enter password:");
					String pass= sobj.nextLine();
			
					Users user = udao.loginUser(email,pass);
					if(user == null)
					{
						System.out.println("User not Found!!!");
						continue;
					}
			
					switch(user.getU_role())
					{
					case "Admin":
								AdminMenu.showAdminMenu();
								break;
				
					case "Customer":
								CustomerMenu.showCustomerMenu();
								break;
				
					case "Vendor":
								VendorMenu.showVendorMenu();
								break;
					default:System.out.println("Unknown Role..");
					}
					break;
			case 2:System.out.println("\n-------- Register as Customer --------");
					System.out.println("Enter your name:");
					String cName = sobj.nextLine();
					System.out.println("Enter your email:");
					String cEmail = sobj.nextLine();
					System.out.println("Enter password:");
					String cPass=sobj.nextLine();
					System.out.println("Enter Address");
					String cAddress=sobj.nextLine();
					
					boolean isRegistered = udao.registerCustomer(cName,cEmail,cPass,cAddress);
					if(isRegistered)
					{
						System.out.println("Registration Successfull...");
					}
					else
					{
						System.out.println("Registration Failed..!!!");
					}
					break;
			case 3:System.out.println("Thank you for using Shopping Cart!!!");
					return;
			default:
					System.out.println("Invalid choice!!!");
			}
			
		}
	}

}
