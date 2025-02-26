package com.modelclasses;

public class Product 
{
	String product_id,p_name,cat_id;
	double price;
	int quantity;
	String email;
	
	public Product() {}

	public Product(String product_id, String p_name, String cat_id, double price, int quantity,String email) {
		super();
		this.product_id = product_id;
		this.p_name = p_name;
		this.cat_id = cat_id;
		this.price = price;
		this.quantity = quantity;
		this.email = email;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getCat_id() {
		return cat_id;
	}

	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", p_name=" + p_name + ", cat_id=" + cat_id + ", price=" + price
				+ ", quantity=" + quantity + ", email=" + email + "]";
	}

	
	
}
