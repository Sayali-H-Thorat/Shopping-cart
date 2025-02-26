package com.modelclasses;

public class Orders 
{
	String order_id,cart_id,payment_status,order_status;

	public Orders() {}

	public Orders(String order_id, String cart_id, String payment_status, String order_status) {
		super();
		this.order_id = order_id;
		this.cart_id = cart_id;
		this.payment_status = payment_status;
		this.order_status = order_status;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getCart_id() {
		return cart_id;
	}

	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", cart_id=" + cart_id + ", payment_status=" + payment_status
				+ ", order_status=" + order_status + "]";
	}
	
	
	
	

}
