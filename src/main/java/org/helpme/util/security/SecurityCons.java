package org.helpme.util.security;

import org.helpme.util.request.UrlProvider;

public class SecurityCons {
	public static final String SECRET = "javaisthebest";
	
	public static final String ISSUER = "http:/" + UrlProvider.SERVER;
	public static final String HEADER = "Authorization";
	public static final String TOKEN_PRE = "Bearer ";
	
}
