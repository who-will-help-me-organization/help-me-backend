package org.helpme.exception.custom.resexists;

public class RatingAlreadyExistsException extends ResourceAlreadyExistsException {
	private static final long serialVersionUID = -5449088115048847334L;

	public RatingAlreadyExistsException(String msg) {
		super(msg);
	}
	
	public RatingAlreadyExistsException() {
		super("This request was already rated.");
	}
}
