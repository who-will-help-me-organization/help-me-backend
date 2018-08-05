package org.helpme.exception.custom.resexists;

public class UserAlreadyExistsException extends ResourceAlreadyExistsException {
	private static final long serialVersionUID = -5449088115048847334L;

	public UserAlreadyExistsException(String msg) {
		super(msg);
	}
	
	public UserAlreadyExistsException() {
		super("User already exists in the database.");
	}
}
