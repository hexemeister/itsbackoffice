package pt.itsector.itsbackoffice.controller;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorDetails {
	private Date timestamp = new Date();
	private String message;
	private String details;

	public ErrorDetails(String message, String details) {
		super();
		this.message = message;
		this.details = details;
	}
}