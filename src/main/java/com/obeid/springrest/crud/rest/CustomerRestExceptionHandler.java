package com.obeid.springrest.crud.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {
	
	// methods for excepion_ handling
	
	// customer not found exception
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFounfException e){
		// create Error response
		CustomerErrorResponse error = 
				new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(), 
										 e.getMessage(),
										 System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	// bad request exception (global exception)
		@ExceptionHandler
		public ResponseEntity<CustomerErrorResponse> handleException(Exception e){
			// create Error response
			CustomerErrorResponse error = 
					new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(), 
											 "chech your request! some entries are invalid",
											 System.currentTimeMillis());
			return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		}
	
	

}
