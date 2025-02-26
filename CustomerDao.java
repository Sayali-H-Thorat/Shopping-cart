package com.dao;

public interface CustomerDao 
{
	public void createCart(String cart_id, String email);
	public void view_your_cart(String email);
	public void add_productTo_yourCart(String cart_id, String product_id, int ordered_quantity);
	public void placeOrder(String cart_id, String delivered_address);
	public void view_your_products(String cart_id);
	public void view_order(String cart_Id);
}
