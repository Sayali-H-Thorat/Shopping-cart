package com.modelclasses;

import java.util.Date;

public class Order_Details 
{
	String order_id;
	Date delivered_date;
	String delivered_address;

	public Order_Details() {}

	public Order_Details(String order_id, Date delivered_date, String delivered_address) {
		super();
		this.order_id = order_id;
		this.delivered_date = delivered_date;
		this.delivered_address = delivered_address;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public Date getDelivered_date() {
		return delivered_date;
	}

	public void setDelivered_date(Date delivered_date) {
		this.delivered_date = delivered_date;
	}

	public String getDelivered_address() {
		return delivered_address;
	}

	public void setDelivered_address(String delivered_address) {
		this.delivered_address = delivered_address;
	}

	@Override
	public String toString() {
		return "Order_Details [order_id=" + order_id + ", delivered_date=" + delivered_date + ", delivered_address="
				+ delivered_address + "]";
	}

	
}
