package com.iwe.avengers.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.iwe.avenger.dynamodb.entity.Avenger;
import com.iwe.avenger.dynamodb.manager.DynamoDBManager;

public class AvengerDAO {
	

	private DynamoDBMapper mapper = DynamoDBManager.mapper();
	
	public Avenger find(String id) {
		
		final Avenger avenger = mapper.load(Avenger.class, id);
		
		return avenger;
	}


	public Avenger create(Avenger avenger) {
		mapper.save(avenger);
		
		return avenger;
		
	}


	public Avenger remove(String id) {
		
			 return null;
		} 
	
	
	public Avenger update(Avenger avenger) {
		return null;
	}
		
		
	
}
