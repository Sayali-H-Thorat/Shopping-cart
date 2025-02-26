package com.menu;

import java.util.ArrayList;
import java.util.Scanner;

import com.daoimplementation.CustomerDaoImplementation;
import com.daoimplementation.ProductDaoImplementation;
import com.modelclasses.Product;

public class CustomerMenu
{
	public static void showCustomerMenu()
	{
		ProductDaoImplementation pdao = new ProductDaoImplementation();
		CustomerDaoImplementation cdao = new CustomerDaoImplementation();
		
		while(true)
		{
			System.out.println("------------------------Welcome Customer-----------------------------");
			System.out.println("Please select option from below:");
			System.out.println("1:View Products");
			System.out.println("2:Create your cart");
			System.out.println("3:Add product to your cart");
			System.out.println("4:View your cart");
			System.out.println("5:Place Order");
			System.out.println("6:View your Order");
			System.out.println("7:Logout");
			System.out.println("----------------------------------------------------------------------");
			Scanner sobj = new Scanner(System.in);
			System.out.println("Enter your choice");
			int choice =sobj.nextInt();
			sobj.nextLine();
//			System.out.println("----------------------------------------------------------------------");
			switch(choice)
			{
			case 1:System.out.println("---------------------------Products are------------------------");
//					pdao.viewProducts();
					ArrayList<Product>pList=pdao.view_products();
					for(Product p:pList)
					{
						System.out.println(p);
					}	
					break;
			case 2:System.out.println("-----------------Create your cart----------------------");
					System.out.println("Enter cart id:");
					String cartId = sobj.nextLine();
					System.out.println("Enter email Id:");
					String eMail = sobj.nextLine();
					cdao.createCart(cartId, eMail);
					break;	
			case 3:System.out.println("-------------------- Add Product ---------------------");
					System.out.println("Enter your cart id:");
					String cart_Id = sobj.nextLine();
					System.out.println("Enter product Id you want to buy:");
					String product_Id = sobj.nextLine();
					System.out.println("Enter the quantity of product...");
					int p_Quantity = sobj.nextInt();
					sobj.nextLine();
					cdao.add_productTo_yourCart(cart_Id, product_Id, p_Quantity);
					break;
			case 4:System.out.println("\n----------------------------------------------------------");
					System.out.println("Enter your email to view your cart:");
					String email = sobj.nextLine();	
					cdao.view_your_cart(email);
					break;
			case 5:System.out.println("-------------Place Order------");
					System.out.println("Enter your cart Id:");
					String cId = sobj.nextLine();
					System.out.println("Enter your address:");					
					String address = sobj.nextLine();
					cdao.placeOrder(cId, address);
					break;
			case 6:System.out.println("-----------------Your Order details are-----------------------");
					System.out.println("Enter your cart Id to Check Status of your order:");
					String vCartId = sobj.nextLine();
					cdao.view_order(vCartId);
					break;
			case 7:System.out.println("Thank you for using shopping cart....!!!");
					return;
			default:System.out.println("Please select correct option..");	
				
			}
		}
	}
	

}
