package pt.itsector.itsbackoffice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class CannotChangeUsernameException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CannotChangeUsernameException(String message) {
		super(message);
	}
	
}
