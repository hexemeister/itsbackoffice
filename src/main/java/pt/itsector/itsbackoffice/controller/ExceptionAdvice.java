package pt.itsector.itsbackoffice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<List> validationErrorHandling(ConstraintViolationException e) {
		List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
		e.getConstraintViolations().forEach(constraintViolation -> {
			errors.add(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
		});
		return new ResponseEntity<List>(errors, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handeNotFoundException(ResourceNotFoundException ex) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), ex.getClass().getName());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CannotChangeUsernameException.class)
	public ResponseEntity<ErrorDetails> handleCannotChangeUsernameException(CannotChangeUsernameException ex) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), ex.getClass().getName());
		return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), ex.getClass().getName());
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
