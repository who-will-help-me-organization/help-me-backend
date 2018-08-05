package org.helpme.exception.custom;

public class TopLevelException extends RuntimeException {
	private static final long serialVersionUID = -3754747924046854912L;

	public TopLevelException(String msg) {
		super(msg);
	}
	
	public TopLevelException() {
		super("An exception has ocurred.");
	}
}
