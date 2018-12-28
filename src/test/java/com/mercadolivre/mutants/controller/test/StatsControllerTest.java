package com.mercadolivre.mutants.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;

import com.mercadolivre.mutants.controller.impl.StaticsControllerImpl;
import com.mercadolivre.mutants.model.Stats;
import com.mercadolivre.mutants.service.impl.StatsServiceImpl;

public class StatsControllerTest {

	private static final String URI = "/stats";
	
	private MockMvc mockMvc;

	@InjectMocks
	private StaticsControllerImpl controller;

	@Mock
	private StatsServiceImpl service;


	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.build();
	}
	
	@Test
	public void testInvocation() throws Exception {
		
		// GIVEN a stats
		Mockito.when(service.getStats()).thenReturn(new Stats(1, 10));

		// WHEN the mutant endpoint is called
		ResultActions resultActions = mockMvc.perform(get(URI));

		// THEN there is an JSON response and the status code is 200
		MvcResult result = resultActions.andExpect(status().isOk()).andReturn();
		String content = result.getResponse().getContentAsString();
		Assert.isTrue(!content.isEmpty(), "Response body should not be empty");

	}

}
