package org.helpme.exception.custom.incomserv;

import org.helpme.exception.custom.TopLevelException;

public class NotResquestOwnerException extends TopLevelException {
	private static final long serialVersionUID = 7987462802271116843L;

	public NotResquestOwnerException(String msg) {
		super(msg);
	}
	
	public NotResquestOwnerException() {
		super("The requester is not the owner of the request.");
	}
}
