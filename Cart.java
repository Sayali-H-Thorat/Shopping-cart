package com.modelclasses;

public class Cart 
{
	String cart_id,email;
	
	public Cart() {}

	public Cart(String cart_id, String email) {
		super();
		this.cart_id = cart_id;
		this.email = email;
	}

	public String getCart_id() {
		return cart_id;
	}

	public void setCart_id(String cart_id) {
		this.cart_id = cart_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", email=" + email + "]";
	}
	
	

}
