package pt.itsector.itsbackoffice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import pt.itsector.itsbackoffice.service.CannotChangeUsernameException;

@ControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler({ConstraintViolationException.class})
	public ResponseEntity<List> validationErrorHandling(ConstraintViolationException e) {
		List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
		e.getConstraintViolations().forEach(constraintViolation -> {
			errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
		});
		
		return new ResponseEntity<List>(errors, HttpStatus.BAD_REQUEST);
	}
	
}
