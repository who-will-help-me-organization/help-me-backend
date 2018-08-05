package org.helpme.exception.custom.resexists;

public class UserAlreadyExists extends ResourceAlreadyExists {
	private static final long serialVersionUID = -5449088115048847334L;

	public UserAlreadyExists(String msg) {
		super(msg);
	}
	
	public UserAlreadyExists() {
		super("User already exists in the database.");
	}
}
