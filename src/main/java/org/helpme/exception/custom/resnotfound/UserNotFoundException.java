package org.helpme.exception.custom.resnotfound;

public class UserNotFoundException extends ResourceNotFoundException {
	private static final long serialVersionUID = -2377368443759465527L;

	public UserNotFoundException(String msg) {
		super(msg);
	}
	
	public UserNotFoundException() {
		super("User could not be found in the database.");
	}
}
