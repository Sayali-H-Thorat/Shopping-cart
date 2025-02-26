package com.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.configuration.ConnectionFactory;
import com.dao.CustomerDao;
import com.modelclasses.Product;

public class CustomerDaoImplementation implements CustomerDao
{
	ConnectionFactory cf;
	
	public CustomerDaoImplementation()
	{
		cf = new ConnectionFactory();
	}

	@Override
	public void createCart(String cart_id, String email)
	{
		Connection con = null;
		
		try 
		{
			con = cf.getMySqlConnection();
			String sql = "insert into cart(cart_id,email) values(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cart_id);
			ps.setString(2, email);
			
			int rows=ps.executeUpdate();
			if(rows>0)
			{
				System.out.println("Cart created successfully...");
			}
			else
			{
				System.out.println("Failed to create cart...");
			}
			
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void add_productTo_yourCart(String cart_id, String product_id, int ordered_quantity) 
	{
		ProductDaoImplementation pdao = new ProductDaoImplementation();
		Connection con = null;
		try 
		{
			con = cf.getMySqlConnection();
			ArrayList<Product> products =pdao.view_products();
			double price = 0;
			for (Product p : products) 
			{
				if (p.getProduct_id().equals(product_id)) 
				{
					price = p.getPrice();
				}
			}
			
			
			double total_amt = price*ordered_quantity;
			
			String sql = "insert into cart_details(cart_id,product_id,orderd_quantity,total_amt) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cart_id);
			ps.setString(2, product_id);
			ps.setInt(3,ordered_quantity);
			ps.setDouble(4, total_amt);			
			int rows = ps.executeUpdate();
			if(rows>0)
			{
				System.out.println("Product added to cart successfully...");
			}
			else
			{
				System.out.println("Failed to add product to your cart...");
			}
			
			
			double cartTotal=0;
			String cartSql = "select sum(total_amt) as cartTotal from cart_details where cart_id =?";
			PreparedStatement cartst = con.prepareStatement(cartSql);
			cartst.setString(1, cart_id);
			ResultSet rs =cartst.executeQuery();			
			if(rs.next())
			{
				cartTotal = rs.getDouble("cartTotal");
				
			}
			
			
			String updateCartSql = "update cart set cart_total_amt=? where cart_id=?";
			PreparedStatement updatePs = con.prepareStatement(updateCartSql);
			updatePs.setDouble(1,cartTotal);
			updatePs.setString(2,cart_id);
			updatePs.executeUpdate();			
			System.out.println("Cart total updated.....");
			
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}		
	}

	@Override
	public void view_your_cart(String email) 
	{
		Connection con = null;
		
		try
		{
			con = cf.getMySqlConnection();
			String sql ="select * from cart where email = ?";
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			System.out.println("-------------Your cart is-------");
			while(rs.next())
			{
				String cartId = rs.getString("cart_id");
				String cEmail = rs.getString("email");
				Double cTotal = rs.getDouble("cart_total_amt");
				System.out.println("Cart id:"+cartId + "\tEmail:" + cEmail + "Cart Total:" + cTotal);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	

	@Override
	public void placeOrder(String cart_id, String delivered_address) 
	{
		Connection con=null;
		try
		{
			con = cf.getMySqlConnection();
			String cehckCart = "select * from cart_details where cart_id=?";
			PreparedStatement pstmt = con.prepareStatement(cehckCart);
			pstmt.setString(1, cart_id);
			ResultSet rs = pstmt.executeQuery();

			Double grandTotal = 0.0;
			boolean isCartEmpty = true;

			while (rs.next()) {
				isCartEmpty = false;
				String product_id = rs.getString("product_id");
				int ordered_quantity = rs.getInt("orderd_quantity");
				double total_amt = rs.getDouble("total_amt");
				grandTotal += total_amt;

				System.out.println(
						"Product ID: " + product_id + " | Quantity: " + ordered_quantity + " | Total: ₹" + total_amt);
			}

			if (isCartEmpty) {
				System.out.println("Your cart is empty..!! Add product to cart to place order");
				return;
			}

			System.out.println("--------------------------");
			System.out.println("Grand Total: " + grandTotal);

			Scanner scanner = new Scanner(System.in);
			System.out.print("Do you want to place an order? (yes/no): ");
			String choice = scanner.nextLine();

			if (choice.equals("yes")) {
				String order_id = "OId_" + System.currentTimeMillis();

				String insertOrder = "insert into orders(order_id,cart_id,payment_status,order_status) values(?,?,?,?)";
				PreparedStatement pstmt1 = con.prepareStatement(insertOrder);
				pstmt1.setString(1, order_id);
				pstmt1.setString(2, cart_id);
				pstmt1.setString(3, "Pending");
				pstmt1.setString(4, "Processing");
				pstmt1.executeUpdate();

				String insertDetails = "insert into order_details(order_id,delivered_address) values(?,?)";
				PreparedStatement pstmt3 = con.prepareStatement(insertDetails);
				pstmt3.setString(1, order_id);
				pstmt3.setString(2, delivered_address);
				pstmt3.executeUpdate();

				String clearCart = "delete from  cart_details where cart_id=?";
				PreparedStatement pstmt2 = con.prepareStatement(clearCart);
				pstmt2.setString(1, cart_id);
				pstmt2.executeUpdate();

				System.out.println("Order placed successfully....!!! Your Order Id: " + order_id);
			} else {
				System.out.println("Order not placed..!!");
				return;
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void view_your_products(String cart_id) 
	{
		Connection con = null;
		try
		{
			con = cf.getMySqlConnection();
			String sql = "select * from cart_details where cart_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cart_id);
			ResultSet rs = ps.executeQuery();
			System.out.println("------------Your Cart----------");
			
			boolean flag = true;
			Double grandTotal= 0.0;
			
			while(rs.next())
			{
				flag=false;
				String cart_id1 = rs.getString("cart_id");
				Double total_amt = rs.getDouble("total_amt");
				String product_id = rs.getString("product_id");
				int orderedQuantity = rs.getInt("ordered_Quantity");
				grandTotal = grandTotal+total_amt;
				System.out.println("Product Id: " + product_id + "| Ordered Quantity: " + orderedQuantity + "| Total:" + total_amt);
				
			}
			if(flag)
			{
				System.out.println("Your cart is Empty..!!! Add products to your cart..!!");
				return;
			}
			System.out.println("----------------------------------------------------------");
			System.out.println("Total price:"+grandTotal);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	@Override
	public void view_order(String cart_Id) 
	{
		Connection con = null;
		try
		{
			con = cf.getMySqlConnection();
			String sql = "select * from orders where cart_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cart_Id);
			ResultSet rs = ps.executeQuery();
			System.out.println("-----------Order details are------------------");
			while(rs.next())
			{
				String oId = rs.getString("order_id");
				String cartId =rs.getString("cart_id");
				String pStatus = rs.getString("payment_status");
				String orderSts = rs.getString("order_status");
				System.out.println("Order Id:"+oId+"\tCart Id:"+cartId+"\tPayment Status:"+pStatus+"\tOrder Status:"+orderSts);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}


}
