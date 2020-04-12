package com.luv2code.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRESTExceptionHandler {

	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException studentNotFoundException) {
		
		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
		studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		studentErrorResponse.setMessage(studentNotFoundException.getMessage());
		studentErrorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(studentErrorResponse, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exception) {
		
		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
		studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		studentErrorResponse.setMessage(exception.getMessage());
		studentErrorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(studentErrorResponse, HttpStatus.BAD_REQUEST);
	}
	
}
