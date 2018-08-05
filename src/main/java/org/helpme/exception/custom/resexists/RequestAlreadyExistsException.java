package org.helpme.exception.custom.resexists;

public class RequestAlreadyExistsException extends ResourceAlreadyExistsException {
	private static final long serialVersionUID = -5449088115048847334L;

	public RequestAlreadyExistsException(String msg) {
		super(msg);
	}
	
	public RequestAlreadyExistsException() {
		super("Request already exists in the database.");
	}
}
