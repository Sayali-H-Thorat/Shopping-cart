package com.menu;

import java.util.Scanner;

import com.daoimplementation.AdminDaoImplementation;
import com.daoimplementation.CategoryDaoImplementation;
import com.daoimplementation.UserDaoImplementation;

public class AdminMenu 
{
	public static void showAdminMenu()
	{
		AdminDaoImplementation adao = new AdminDaoImplementation();
		CategoryDaoImplementation cdao = new CategoryDaoImplementation();
		UserDaoImplementation udao = new UserDaoImplementation();
		
		while(true)
		{
			System.out.println("---------------------------------Welcome Admin---------------------------");
			System.out.println("Please select option from below:");
			System.out.println("1:Add Vendor");
			System.out.println("2:Add Category");
			System.out.println("3:View Categories");
			System.out.println("4:Show All Vendors");
			System.out.println("5:Delete Vendor");
			System.out.println("6:Show All Customers");
			System.out.println("7:Logout");			
			System.out.println("----------------------------------------------------------------------");
			Scanner sobj = new Scanner(System.in);
			System.out.println("Enter your choice");
			int choice =sobj.nextInt();
			sobj.nextLine();
			System.out.println("----------------------------------------------------------------------");
			switch(choice)
			{
			case 1:
				System.out.println("Enter vendor name:");
				String name = sobj.nextLine();
				System.out.println("Enter Vendor email:");
				String email = sobj.nextLine();
				System.out.println("Enter vendor pass:");
				String pass = sobj.nextLine();
				System.out.println("Enter vendor address:");
				String add = sobj.nextLine();
				adao.addVendor(name, email, pass, add);
				break;
			case 2:
				System.out.println("Enter category id:");
				String catId = sobj.nextLine();
				System.out.println("Enter category Name:");
				String catName = sobj.nextLine();
				adao.addCategory(catId, catName);
				break;
			case 3:
				cdao.view_categories();
				break;
			case 4:
				udao.showVendors();
				break;
			case 5:
				System.out.println("Enter vendor email to delete..");
				String vemail = sobj.nextLine();
				adao.deleteVendor(vemail);
				break;
			case 6:
				udao.showCustomers();
				break;
			case 7:System.out.println("Thank you for using shopping cart....!!!");
					return;
			default:System.out.println("Please select correct option..");	
			}
			
		}
		
		
	}

}
