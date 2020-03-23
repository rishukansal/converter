package com.virtusa.interview.converter.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.virtusa.interview.converter.service.ConverterService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ConverterController.class)
public class ConverterControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ConverterService converterService;

	@Test
	public void converterNumberTest() throws Exception {
		Mockito.when(converterService.convert(Mockito.anyLong())).thenReturn("One hundred thousand");
		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/numberconverter/100000").accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		Assertions.assertEquals(200, status);
	}
	
	
	
	@Test
	public void converterNumberBadRequestTest() throws Exception {
		Mockito.when(converterService.convert(Mockito.anyLong())).thenReturn("One hundred thousand");
		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/numberconverter/abc").accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		Assertions.assertEquals(400, status);
	}

}
