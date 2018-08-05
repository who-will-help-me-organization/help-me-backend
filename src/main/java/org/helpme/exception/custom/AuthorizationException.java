package org.helpme.exception.custom;

public class AuthorizationException extends TopLevelException {
	private static final long serialVersionUID = 7987462802271116843L;

	public AuthorizationException(String msg) {
		super(msg);
	}
	
	public AuthorizationException() {
		super("Authorization failed.");
	}
}
