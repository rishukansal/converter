package com.virtusa.interview.converter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.interview.converter.service.ConverterService;


/**
 * The Class ConverterController.
 */
@RestController
public class ConverterController {
	
	
	/** The converter service. */
	@Autowired
	private ConverterService converterService;
	
	
	/**
	 * Converter number.
	 *
	 * @param number the number
	 * @return the response entity
	 */
	@GetMapping(value="/numberconverter/{number}")
	public ResponseEntity<String> converterNumber(@PathVariable Long number) {
		String resp = converterService.convert(number);
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}

}
