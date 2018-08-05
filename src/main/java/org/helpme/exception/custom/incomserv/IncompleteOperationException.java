package org.helpme.exception.custom.incomserv;

import org.helpme.exception.custom.TopLevelException;

public class IncompleteOperationException extends TopLevelException {
	private static final long serialVersionUID = 7987462802271116843L;

	public IncompleteOperationException(String msg) {
		super(msg);
	}
	
	public IncompleteOperationException() {
		super("Service is incomplete.");
	}
}
