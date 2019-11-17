package pt.itsector.itsbackoffice.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "Cannot change username")
public class CannotChangeUsernameException extends RuntimeException{

	String msg = "";
	
	public CannotChangeUsernameException() {
		super("Cannot change username");
	}
	
	public CannotChangeUsernameException(String msg) {
		super("Cannot change username: " + msg);
	}
	
}
