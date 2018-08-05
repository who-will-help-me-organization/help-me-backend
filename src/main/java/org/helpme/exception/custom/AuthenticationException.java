package org.helpme.exception.custom;

public class AuthenticationException extends TopLevelException {
	private static final long serialVersionUID = -1416572331802941132L;
	
	public AuthenticationException(String msg) {
		super(msg);
	}
	
	public AuthenticationException() {
		super("Authentication failed.");
	}
}
