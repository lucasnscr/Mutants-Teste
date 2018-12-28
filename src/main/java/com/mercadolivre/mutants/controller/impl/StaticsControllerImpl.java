package com.mercadolivre.mutants.controller.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.dynamodbv2.model.InternalServerErrorException;
import com.mercadolivre.mutants.controller.StaticsController;
import com.mercadolivre.mutants.exception.ServiceException;
import com.mercadolivre.mutants.model.Stats;
import com.mercadolivre.mutants.service.StatsService;

@RestController
public class StaticsControllerImpl implements StaticsController {
	
	@Autowired
	private StatsService statsService;
	
	private static Logger logger =  Logger.getGlobal();
	
	public Stats getStatics()  {
		
		Stats stats;
		
		try {
			stats = statsService.getStats();
		} catch (ServiceException e) {
			logger.log(Level.ALL, e.getMessage());
			throw new InternalServerErrorException(e.getMessage());
		}
		
		return stats;
	}
}
