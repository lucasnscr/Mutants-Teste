package com.mercadolivre.mutants.dao;

import com.mercadolivre.mutants.exception.DatabaseException;
import com.mercadolivre.mutants.model.Humano;
import com.mercadolivre.mutants.model.Mutante;

public interface DBServiceDAO {
	
	public void insert(Mutante mutante) throws DatabaseException;
	
	public void insert(Humano humano) throws DatabaseException;
	
	public int getHumansCount() throws DatabaseException;
	
	public int getMutantsCount() throws DatabaseException;
}
