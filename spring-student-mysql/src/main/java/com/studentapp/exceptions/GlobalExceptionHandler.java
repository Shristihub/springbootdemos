package com.studentapp.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.studentapp.model.ApiErrors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Method anot supported");
		LocalDateTime dateTime = LocalDateTime.now();
		ApiErrors errors = new ApiErrors(message, details, dateTime, status);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("media not supported");
		LocalDateTime dateTime = LocalDateTime.now();
		ApiErrors errors = new ApiErrors(message, details, dateTime, status);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Path variable is missing");
		LocalDateTime dateTime = LocalDateTime.now();
		ApiErrors errors = new ApiErrors(message, details, dateTime, status);
		return ResponseEntity.status(status).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Request Param is missing");
		LocalDateTime dateTime = LocalDateTime.now();
		ApiErrors errors = new ApiErrors(message, details, dateTime, status);
		return ResponseEntity.status(status).body(errors);	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("type mismatch");
		LocalDateTime dateTime = LocalDateTime.now();
		ApiErrors errors = new ApiErrors(message, details, dateTime, status);
		return ResponseEntity.status(status).body(errors);
	}
	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<Object> handleCourseNotFoundException(CourseNotFoundException ex) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("id not found");
		LocalDateTime dateTime = LocalDateTime.now();
		ApiErrors errors = new ApiErrors(message, details, dateTime, HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException ex) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Student not found");
		LocalDateTime dateTime = LocalDateTime.now(); 
		ApiErrors errors = new ApiErrors(message, details, dateTime, HttpStatus.NOT_ACCEPTABLE);
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errors);
	}
	@ExceptionHandler(GadgetsNotFoundException.class)
	public ResponseEntity<Object> handleGadgetsNotFoundException(GadgetsNotFoundException ex) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Gadgets not found");
		LocalDateTime dateTime = LocalDateTime.now();
		ApiErrors errors = new ApiErrors(message, details, dateTime, HttpStatus.NOT_ACCEPTABLE);
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errors);
	}
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object> handleIdNotFoundException(IdNotFoundException ex) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("course not found");
		LocalDateTime dateTime = LocalDateTime.now();
		ApiErrors errors = new ApiErrors(message, details, dateTime, HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	
}
