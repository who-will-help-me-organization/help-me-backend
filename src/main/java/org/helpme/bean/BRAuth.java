package org.helpme.bean;

import org.helpme.model.User;

public class BRAuth {
	private String token;
	private User user;
	
	public BRAuth(String token, User user) {
		this.token = token;
		this.user = user;
	}
	
	public BRAuth() {
		
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
