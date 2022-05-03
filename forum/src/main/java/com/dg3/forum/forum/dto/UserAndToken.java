package com.dg3.forum.forum.dto;


import com.dg3.forum.forum.entity.Users;

public class UserAndToken {
	Users user;
	String token;

	public UserAndToken() {

	}

	public UserAndToken(Users user, String token) {
		this.user = user;
		this.token = token;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
