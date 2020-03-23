package com.virtusa.interview.converter.util;

import org.springframework.stereotype.Component;

import com.virtusa.interview.converter.contant.Constants;


/**
 * The Class Utility.
 */
@Component
public class Utility {
	
	
	   /**
   	 * Convert less than one thousand.
   	 *
   	 * @param number the number
   	 * @return the string
   	 */
   	public String convertLessThanOneThousand(Integer number) {
	        String current;
	        
	        if (number % 100 < 20){
	            current = Constants.NUM_NAMES[number % 100];
	            number /= 100;
	        }
	        else {
	            current = Constants.NUM_NAMES[number % 10];
	            number /= 10;
	            
	            current = Constants.TENS_NAMES[number % 10] + current;
	            number /= 10;
	        }
	        if (number == 0) return current;
	        return Constants.NUM_NAMES[number] + " hundred" + current;
	    }

}
