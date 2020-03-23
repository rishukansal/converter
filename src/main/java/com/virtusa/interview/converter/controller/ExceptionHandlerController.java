package com.virtusa.interview.converter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * The Class ExceptionHandlerController.
 */
@ControllerAdvice
public class ExceptionHandlerController {
	
	/**
	 * Bad input.
	 *
	 * @return the response entity
	 */
	@ExceptionHandler({NumberFormatException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> badInput(){
		return new ResponseEntity<>("Bad input",HttpStatus.BAD_REQUEST);
	}

}
