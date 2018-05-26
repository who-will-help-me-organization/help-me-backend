package org.helpme.util.request;

public class UrlProvider {
	
	// Top
	
	public static String server() {
		return "/helpmeapi";
	}
	
	// Middle
	
	public static String authentication() {
		return server() + "/authentication";
	}
	
	public static String user() {
		return server() + "/user";
	}
	
	// Endpoints
	
	public static String login() {
		
		return authentication() + "/login"; 
	}
	
	public static String signup() {
		return user() + ""; 
	}
}
