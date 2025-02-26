package com.modelclasses;

public class Cart_Details 
{
	String cart_id;
	double total_amt;
	String product_id;
	int orderd_Quantity;
	
	public Cart_Details() {}
	public Cart_Details(String cart_id, double total_amt, String product_id, int orderd_Quantity) {
		super();
		this.cart_id = cart_id;
		this.total_amt = total_amt;
		this.product_id = product_id;
		this.orderd_Quantity = orderd_Quantity;
	}
	public String getCart_id() {
		return cart_id;
	}
	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}
	public double getTotal_amt() {
		return total_amt;
	}
	public void setTotal_amt(double total_amt) {
		this.total_amt = total_amt;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public int getOrderd_Quantity() {
		return orderd_Quantity;
	}
	public void setOrderd_Quantity(int orderd_Quantity) {
		this.orderd_Quantity = orderd_Quantity;
	}
	@Override
	public String toString() {
		return "Cart_Details [cart_id=" + cart_id + ", total_amt=" + total_amt + ", product_id=" + product_id
				+ ", orderd_Quantity=" + orderd_Quantity + "]";
	}
	
	

}
