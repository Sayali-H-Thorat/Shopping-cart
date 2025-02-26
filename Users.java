package com.modelclasses;

public class Users 
{
	String user_name,email,pass,u_role,address;
	
	public Users() {}

	public Users(String user_name, String email, String pass, String u_role, String address) {
		super();
		this.user_name = user_name;
		this.email = email;
		this.pass = pass;
		this.u_role = u_role;
		this.address = address;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getU_role() {
		return u_role;
	}

	public void setU_role(String u_role) {
		this.u_role = u_role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Users [user_name=" + user_name + ", email=" + email + ", pass=" + pass + ", u_role=" + u_role
				+ ", address=" + address + "]";
	}
	
	
}
