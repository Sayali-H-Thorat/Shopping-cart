package com.modelclasses;

public class Category 
{

	String cat_id,cat_name;

	public Category(){	}

	public Category(String cat_id, String cat_name) {
		super();
		this.cat_id = cat_id;
		this.cat_name = cat_name;
	}

	public String getCat_id() {
		return cat_id;
	}

	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	@Override
	public String toString() {
		return "Category [cat_id=" + cat_id + ", cat_name=" + cat_name + "]";
	}
	

}
