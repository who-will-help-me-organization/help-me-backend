package org.helpme.exception.custom.resnotfound;

public class RequestNotFoundException extends ResourceNotFoundException {
	private static final long serialVersionUID = -2377368443759465527L;

	public RequestNotFoundException(String msg) {
		super(msg);
	}
	
	public RequestNotFoundException() {
		super("Request could not be found in the database.");
	}
}
