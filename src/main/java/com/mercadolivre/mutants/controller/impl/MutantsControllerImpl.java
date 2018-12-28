package com.mercadolivre.mutants.controller.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolivre.mutants.controller.MutantsControllerr;
import com.mercadolivre.mutants.exception.InputValidationException;
import com.mercadolivre.mutants.exception.ServiceException;
import com.mercadolivre.mutants.model.DNASequence;
import com.mercadolivre.mutants.service.MutantesService;

@RestController
public class MutantsControllerImpl implements MutantsControllerr {
	
	@Autowired
	private MutantesService mutantesService;
	
	private static Logger logger =  Logger.getGlobal();
	
	public ResponseEntity<String> analizeMutantCandidate(@RequestBody DNASequence dna) {
		
		ResponseEntity<String> responseEntity = null;
		boolean isMutant;	

		try {
			isMutant = mutantesService.isMutant(dna.getDna());
			
			if(isMutant) {
				responseEntity = new ResponseEntity<>(HttpStatus.OK);
			} else {
				responseEntity = new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}
			
		} catch (ServiceException ex) {
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			logger.log(Level.ALL, ex.getMessage());		
		} catch (InputValidationException ex) {
			responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			logger.log(Level.ALL, ex.getMessage());
		}
	
		return responseEntity;
	}
}
