package org.helpme.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
	@Id
	private String id;
	
	private String usercode;
	private String password;
	
	private int courseCode;
	private String email;
	private String name;
	private String phoneNumber;
	
	public User(String id, String usercode, String password, int courseCode, String email, String name,
			String phoneNumber) {
		this.id = id;
		this.usercode = usercode;
		this.password = password;
		this.courseCode = courseCode;
		this.email = email;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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
	
	public int getCourseCode() {
		return courseCode;
	}
	
	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
