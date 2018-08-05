package org.helpme.exception.custom.incomserv;

import org.helpme.exception.custom.TopLevelException;

public class NoTutorAvailableException extends TopLevelException {
	private static final long serialVersionUID = 7987462802271116843L;

	public NoTutorAvailableException(String msg) {
		super(msg);
	}
	
	public NoTutorAvailableException() {
		super("No tutors available for this request.");
	}
}
