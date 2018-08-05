package org.helpme.exception.custom.resexists;

import org.helpme.exception.custom.TopLevelException;

public class ResourceAlreadyExistsException extends TopLevelException {
	private static final long serialVersionUID = -5449088115048847334L;

	public ResourceAlreadyExistsException(String msg) {
		super(msg);
	}
	
	public ResourceAlreadyExistsException() {
		super("Resource already exists in the database.");
	}
}
