package com.mercadolivre.mutants.dao;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public abstract class DynamoDAO {
	
	protected AmazonDynamoDB client;
	protected DynamoDB dynamoDB;
	protected DynamoDBMapper mapper;
	
	public DynamoDAO() {
		
	    client = AmazonDynamoDBClientBuilder.standard()
				.withRegion(Regions.fromName("us-east-1"))
				.build();
	   
	    mapper = new DynamoDBMapper(client);
	}

}
