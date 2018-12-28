package com.mercadolivre.mutants.service;

import com.mercadolivre.mutants.exception.ServiceException;
import com.mercadolivre.mutants.model.Stats;

public interface StatsService {
	
	public Stats getStats() throws ServiceException;

}
