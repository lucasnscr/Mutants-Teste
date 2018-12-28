package com.mercadolivre.mutants.service;

import com.mercadolivre.mutants.exception.InputValidationException;
import com.mercadolivre.mutants.exception.ServiceException;

public interface MutantesService {
	
	public boolean isMutant(String[] dna) throws ServiceException, InputValidationException;

}
