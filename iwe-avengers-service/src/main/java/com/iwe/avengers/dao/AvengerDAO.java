package com.iwe.avengers.dao;

import java.util.HashMap;
import java.util.Map;

import com.iwe.avenger.dynamodb.entity.Avenger;

public class AvengerDAO {
	
	public Map<String, Avenger> mapper = new HashMap<>();
	
	
	public AvengerDAO() {
		mapper.put("sdsa-sasa-asas-sasa", new Avenger("sdsa-sasa-asas-sasa", "Iron Man", "Tony Stark"));
		mapper.put("sdsa-sasa-asas-sasaaaa", new Avenger("sdsa-sasa-asas-sasaaaa", "Batman", "Bruce Wayne"));
		
	}
	

	public Avenger find(String id) {
		
		return mapper.get(id);
	}


	public Avenger create(Avenger avenger) {
		
		String id = mapper.size() + "";
		avenger.setId(id);
		
		mapper.put(id, avenger);
		
		return avenger;
		
	}


	public Avenger remove(String id) {
		
			 return mapper.remove(id);
		} 
		
		
	
}
