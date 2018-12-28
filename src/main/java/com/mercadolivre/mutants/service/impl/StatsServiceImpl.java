package com.mercadolivre.mutants.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolivre.mutants.dao.DBServiceDAO;
import com.mercadolivre.mutants.exception.DatabaseException;
import com.mercadolivre.mutants.exception.ServiceException;
import com.mercadolivre.mutants.model.Stats;
import com.mercadolivre.mutants.service.StatsService;

@Service
public class StatsServiceImpl implements StatsService {
	
	@Autowired
	private DBServiceDAO dbServiceDAO;
	
	@Override
	public Stats getStats() throws ServiceException{
		
		Stats stats;
		
		try {
			stats = new Stats(dbServiceDAO.getMutantsCount(), dbServiceDAO.getHumansCount());
		} catch (DatabaseException ex) {
			throw new ServiceException(ex.getMessage());
		}
		
		return stats;
	}

}
