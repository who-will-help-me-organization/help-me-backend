package org.helpme.util.request;

public class UrlProvider {
	public static final String SERVER = "/helpmeapi";
	
	public static final String authentication = SERVER + "/authentication";
	
	// Top
	
	public static String server() {
		return "/helpmeapi";
	}
	
	// Middle
	
	public final static String authentication() {
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
