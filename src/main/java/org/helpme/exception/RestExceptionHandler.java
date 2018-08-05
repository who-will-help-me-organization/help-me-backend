package org.helpme.exception;

import java.util.Date;

import org.helpme.exception.custom.incomserv.IncompleteOperationException;
import org.helpme.exception.custom.resexists.ResourceAlreadyExistsException;
import org.helpme.exception.custom.resnotfound.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {ResourceNotFoundException.class})
	protected ResponseEntity<Object> handleResouceNotFound(ResourceNotFoundException e, WebRequest request) {
		ApiError error = new ApiError("Resource not found",
				  					  e.getMessage(),
				  					  new Date());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {ResourceAlreadyExistsException.class})
	protected ResponseEntity<Object> handleResouceAlreadyExists(ResourceAlreadyExistsException e, WebRequest request) {
		ApiError error = new ApiError("Resource already exists",
									  e.getMessage(),
									  new Date());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {IncompleteOperationException.class})
	protected ResponseEntity<Object> handleIncompleteOperation(IncompleteOperationException e, WebRequest request) {
		ApiError error = new ApiError("Could not complete operation",
									  e.getMessage(),
									  new Date());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		BindingResult result = ex.getBindingResult();
		
		String message = "A validation error has occured in the following fields: ";
		
		for (FieldError fError : result.getFieldErrors()) {
			message += fError.getField() + " - " + fError.getRejectedValue() + " - " + fError.getDefaultMessage() + " | ";
		}
		
	    ApiError error = new ApiError("Validation Error",
	        message, new Date());
	    
	    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	} 
}
