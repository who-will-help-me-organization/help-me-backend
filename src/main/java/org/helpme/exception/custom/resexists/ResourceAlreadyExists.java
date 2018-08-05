package org.helpme.exception.custom.resexists;

import org.helpme.exception.custom.TopLevelException;

public class ResourceAlreadyExists extends TopLevelException {
	private static final long serialVersionUID = -5449088115048847334L;

	public ResourceAlreadyExists(String msg) {
		super(msg);
	}
	
	public ResourceAlreadyExists() {
		super("Resource already exists in the database.");
	}
}
