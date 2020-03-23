package com.virtusa.interview.converter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.interview.converter.constant.Constants;
import com.virtusa.interview.converter.util.Utility;


/**
 * The Class ConverterServiceImpl.
 */
@Service
public class ConverterServiceImpl implements ConverterService {
	
	/** The util. */
	@Autowired
	private Utility util;

	/**
	 * Convert.
	 *
	 * @param number the number
	 * @return the string
	 */
	@Override
	public String convert(Long number) {
        if (number == 0) { return "zero"; }
        
        String prefix = "";
        
        if (number < 0) {
            number = -number;
            prefix = "negative";
        }
        
        String current = "";
        int place = 0;
        
        do {
            long n = number % 1000;
            if (n != 0){
                String s = util.convertLessThanOneThousand(n);
                current = s + Constants.SPL_NAMES[place] + current;
            }
            place++;
            number /= 1000;
        } while (number > 0);
        
        return (prefix + current).trim();
	}

}
