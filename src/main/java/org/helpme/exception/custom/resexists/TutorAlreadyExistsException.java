package org.helpme.exception.custom.resexists;

public class TutorAlreadyExistsException extends ResourceAlreadyExistsException {
	private static final long serialVersionUID = -5449088115048847334L;

	public TutorAlreadyExistsException(String msg) {
		super(msg);
	}
	
	public TutorAlreadyExistsException() {
		super("Tutor already exists in the database.");
	}
}
