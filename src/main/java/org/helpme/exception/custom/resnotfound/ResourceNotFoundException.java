package org.helpme.exception.custom.resnotfound;

import org.helpme.exception.custom.TopLevelException;

public class ResourceNotFoundException extends TopLevelException {
	private static final long serialVersionUID = 4517411393340105176L;

	public ResourceNotFoundException(String msg) {
		super(msg);
	}
	
	public ResourceNotFoundException() {
		super("Resource could not be found in the database.");
	}
}
