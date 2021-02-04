package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class AppUser {
	String username;
	@Id
	int userid;
	String password;
	String authority;
	
	
	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AppUser(String username, int userid, String password, String authority) {
		super();
		this.username = username;
		this.userid = userid;
		this.password = password;
		this.authority = authority;
	}

	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AppUser [username=" + username + ", userid=" + userid + ", password=" + password + "]";
	}

}
