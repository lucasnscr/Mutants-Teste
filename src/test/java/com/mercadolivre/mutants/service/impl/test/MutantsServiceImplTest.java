package com.mercadolivre.mutants.service.impl.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.mercadolivre.mutants.dao.impl.DBServiceDAOImpl;
import com.mercadolivre.mutants.exception.DatabaseException;
import com.mercadolivre.mutants.exception.InputValidationException;
import com.mercadolivre.mutants.exception.ServiceException;
import com.mercadolivre.mutants.model.Humano;
import com.mercadolivre.mutants.model.Mutante;
import com.mercadolivre.mutants.service.impl.MutantesServiceImpl;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class MutantsServiceImplTest {
	
	private String[] dnaMutant1 =  new String[] { 
			  "ATGCGA", 
			  "CAGTGC", 
			  "TTATGG", 
			  "AGAAGG", 
			  "CCCCTA", 
			  "TCGCTG"};
	
	private String[] dnaMutant2 =  new String[] { 
			  "GTGCGA", 
			  "CACTGC", 
			  "TCATGG", 
			  "CGATAG", 
			  "CCCTTA", 
			  "TCCCCG"};
	
	private String[] dnaHuman1 =  new String[] { 
			  "GTGCGA", 
			  "CACTAC", 
			  "TCCTGG", 
			  "CGAAAG", 
			  "CCCGTA", 
			  "TCGCTG"};
	
	private String[] dnaHuman2 =  new String[] { 
			  "GTGCGA", 
			  "CACTGC", 
			  "TCATGG", 
			  "CGAAAG", 
			  "CCCGTA", 
			  "TCGCTG"};

	@InjectMocks
	private MutantesServiceImpl service;
	
	@Mock
	private DBServiceDAOImpl dao;	
	
	@Test
	public void testIsMutant_Success_Mutant1() throws DatabaseException, ServiceException, InputValidationException {

		// GIVEN a dna of a mutant subject
		String[] dna = dnaMutant1;
		Mutante mutante = new Mutante(dna);
		Mockito.doNothing().when(dao).insert(Mockito.eq(mutante));

		// WHEN is mutant service is executed
		boolean result = service.isMutant(dna);

		// THEN the return is true
		TestCase.assertTrue(result);
	}
	
	@Test
	public void testIsMutant_Success_Mutant2() throws DatabaseException, ServiceException, InputValidationException {
		
		String[] dna = dnaMutant2;
		Mutante mutante = new Mutante(dna);
		Mockito.doNothing().when(dao).insert(Mockito.eq(mutante));

		boolean result = service.isMutant(dna);

		TestCase.assertTrue(result);
	}
	
	@Test
	public void testIsMutant_Error_Human1() throws DatabaseException, ServiceException, InputValidationException {
		String[] dna = dnaHuman1;
		Humano h = new Humano(dna);
		Mockito.doNothing().when(dao).insert(Mockito.eq(h));

		boolean result = service.isMutant(dna);

		TestCase.assertFalse(result);
	}
	
	@Test
	public void testIsMutant_Error_Human2() throws DatabaseException, ServiceException, InputValidationException {
		String[] dna = dnaHuman2;
		Humano h = new Humano(dna);
		Mockito.doNothing().when(dao).insert(Mockito.eq(h));

		boolean result = service.isMutant(dna);

		TestCase.assertFalse(result);
	}
	
}