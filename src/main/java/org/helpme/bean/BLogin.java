package org.helpme.bean;

public class BLogin {
	private String usercode;
	private String password;
	
	public BLogin(String usercode, String password) {
		this.usercode = usercode;
		this.password = password;
	}
	
	public BLogin() {
		
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
