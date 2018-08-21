package com.iwe.avengers;

import java.util.NoSuchElementException;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.iwe.avenger.dynamodb.entity.Avenger;
import com.iwe.avenger.lambda.exception.AvengerNotFoundException;
import com.iwe.avenger.lambda.response.HandlerResponse;
import com.iwe.avengers.dao.AvengerDAO;

public class SearchAvengersHandler implements RequestHandler<Avenger, HandlerResponse> {

	
	private AvengerDAO dao = new AvengerDAO();
	
	
	@Override
	public HandlerResponse handleRequest(final Avenger avenger, final Context context) {
		
		HandlerResponse response = null;
		 Avenger retriviedAvenger = null;
		
		try {
		
		String id = avenger.getId();
		
		context.getLogger().log("[#] - Searching Avenger wiht id:" + id);
		
		retriviedAvenger = dao.find(id);
			
		}catch (NoSuchElementException e) {
			throw new AvengerNotFoundException("[NotFound] - Avenger notFound");
		}
		
		response =  HandlerResponse.builder().setStatusCode(200).setObjectBody(retriviedAvenger).build();
		return response;
		
	}
}
