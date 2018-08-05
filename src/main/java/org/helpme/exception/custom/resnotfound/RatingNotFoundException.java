package org.helpme.exception.custom.resnotfound;

public class RatingNotFoundException extends ResourceNotFoundException {
	private static final long serialVersionUID = -2377368443759465527L;

	public RatingNotFoundException(String msg) {
		super(msg);
	}
	
	public RatingNotFoundException() {
		super("Rating could not be found in the database.");
	}
}
