package com.menu;

import java.util.ArrayList;
import java.util.Scanner;

import com.daoimplementation.CategoryDaoImplementation;
import com.daoimplementation.CustomerDaoImplementation;
import com.daoimplementation.ProductDaoImplementation;
import com.daoimplementation.VendorDaoImplementation;
import com.modelclasses.Product;

public class VendorMenu 
{
	public static void showVendorMenu()
	{
		CategoryDaoImplementation cdao = new CategoryDaoImplementation();
		VendorDaoImplementation vdao = new VendorDaoImplementation();
		ProductDaoImplementation pdao = new ProductDaoImplementation();
		
		while(true)
		{
			System.out.println("------------------------Welcome Vendor-----------------------------");
			System.out.println("Please select option from below:");
			System.out.println("1:View Categories");
			System.out.println("2:View All Products");
			System.out.println("3:Add products");
			System.out.println("4:View your Products");
			System.out.println("5:Logout");
			System.out.println("----------------------------------------------------------------------");
			Scanner sobj = new Scanner(System.in);
			System.out.println("Enter your choice");
			int choice =sobj.nextInt();
			sobj.nextLine();
			switch(choice)
			{
			case 1:System.out.println("--------------------------------------------");
					cdao.view_categories();
					break;
			case 2:System.out.println("-----------------------------------------------");
					ArrayList<Product>pList=pdao.view_products();
					for(Product p:pList)
					{
						System.out.println(p);
					}	
					break;
			case 3:System.out.println("----------------------------------------------");
					System.out.println("Enter your product Id:");
					String pId = sobj.nextLine();
					System.out.println("Enter product Name:");
					String pName = sobj.nextLine();
					System.out.println("Enter category id");
					String catId = sobj.nextLine();
					System.out.println("Enter the price:");
					Double price = sobj.nextDouble();
					System.out.println("Enter the quantity of product:");
					int quantity = sobj.nextInt();
					System.out.println("Enter your email:");
					String email = sobj.nextLine();
					sobj.nextLine();
					vdao.add_product(pId,pName, catId, price,quantity,email);
					break;
			case 4:System.out.println("--------------------------------------------------");
					System.out.println("Enter your email Id to check your products:");
					String vEmail = sobj.nextLine();
					vdao.view_products(vEmail);
					break;					
			case 5:System.out.println("Thank you for using shopping cart....!!!");
			return;
			default:System.out.println("Please select correct option..");	
			}
		}
	}
	

}
