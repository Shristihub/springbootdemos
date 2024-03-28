package com.insuranceapp.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiErrors {

	private LocalDateTime timestamp;
	private int statusCode;
	private String error;
	private HttpStatus status;
	public ApiErrors(LocalDateTime timestamp, int statusCode, String error, HttpStatus status) {
		super();
		this.timestamp = timestamp;
		this.statusCode = statusCode;
		this.error = error;
		this.status = status;
	}
	
	
	
}
