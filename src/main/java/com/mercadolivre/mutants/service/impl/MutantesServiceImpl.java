package com.mercadolivre.mutants.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolivre.mutants.dao.DBServiceDAO;
import com.mercadolivre.mutants.detector.MutantDetector;
import com.mercadolivre.mutants.detector.impl.MutantDetectorDNABased;
import com.mercadolivre.mutants.exception.DatabaseException;
import com.mercadolivre.mutants.exception.InputValidationException;
import com.mercadolivre.mutants.exception.ServiceException;
import com.mercadolivre.mutants.model.Humano;
import com.mercadolivre.mutants.model.Mutante;
import com.mercadolivre.mutants.service.MutantesService;

@Service
public class MutantesServiceImpl implements MutantesService {
	
	@Autowired	
	private DBServiceDAO dbServiceDAO;
	
	@Override
	public boolean isMutant(String[] dna) throws ServiceException, InputValidationException{
		
		MutantDetector mutantDetector = new MutantDetectorDNABased();
		boolean isMutante = false;
		
		try {
		
			isMutante = mutantDetector.isMutant(dna);
			 
			if(isMutante) {
				Mutante mutant = new Mutante(dna);
				dbServiceDAO.insert(mutant);
			} else {
				Humano humano = new Humano(dna);
				dbServiceDAO.insert(humano);
			}
		} catch (DatabaseException ex) {
			throw new ServiceException(ex.getMessage());
		}
		
		return isMutante;
	}

}
