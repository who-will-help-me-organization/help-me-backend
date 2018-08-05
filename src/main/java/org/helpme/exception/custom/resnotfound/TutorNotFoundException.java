package org.helpme.exception.custom.resnotfound;

public class TutorNotFoundException extends ResourceNotFoundException {
	private static final long serialVersionUID = -2377368443759465527L;

	public TutorNotFoundException(String msg) {
		super(msg);
	}
	
	public TutorNotFoundException() {
		super("Tutor could not be found in the database.");
	}
}
