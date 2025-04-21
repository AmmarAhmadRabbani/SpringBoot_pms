package com.te.springbootproject.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

//	@ExceptionHandler(MismatchIdFoundException.class)
//	public ResponseEntity<?> handleMismatchIdFoundException(MismatchIdFoundException exception) {
//		return new ResponseEntity<>(exception.getMessege(), HttpStatus.BAD_REQUEST);
//	}

}
