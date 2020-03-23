package com.virtusa.interview.converter.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.virtusa.interview.converter.util.Utility;

@ExtendWith(MockitoExtension.class)
public class ConverterServiceImplTest {
	
	@Mock
	private Utility util;
	
	@InjectMocks
	private ConverterServiceImpl converterService;
	
	
	@Test
	public void convertTest() {
		Mockito.when(util.convertLessThanOneThousand(Mockito.anyLong())).thenReturn("One hundred thousand");
		String resp = converterService.convert(100000L);
		Assertions.assertNotNull(resp);
	}

}
