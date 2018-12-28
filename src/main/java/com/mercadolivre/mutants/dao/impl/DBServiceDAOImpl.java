package com.mercadolivre.mutants.dao.impl;

import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.mercadolivre.mutants.dao.DBServiceDAO;
import com.mercadolivre.mutants.dao.DynamoDAO;
import com.mercadolivre.mutants.exception.DatabaseException;
import com.mercadolivre.mutants.model.Humano;
import com.mercadolivre.mutants.model.Mutante;

/**
 * DynamoDB Implementation of data access layer
 * 
 */
@Service
public class DBServiceDAOImpl extends DynamoDAO implements DBServiceDAO {
	
	public DBServiceDAOImpl() {
		super();
	}
	
	@Override
	public void insert(Mutante mutante)  throws DatabaseException{
		mapper.save(mutante);
	}
	
	@Override
	public void insert(Humano humano)  throws DatabaseException{
		mapper.save(humano);
	}

	@Override
	public int getHumansCount()  throws DatabaseException {
		DynamoDBScanExpression dbScanExpression = new DynamoDBScanExpression();
		return mapper.count(Humano.class, dbScanExpression);
	}

	@Override
	public int getMutantsCount()  throws DatabaseException {
		DynamoDBScanExpression dbScanExpression = new DynamoDBScanExpression();
		return mapper.count(Mutante.class, dbScanExpression);
	}
}
