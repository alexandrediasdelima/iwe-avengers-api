package com.iwe.avengers;

import java.util.NoSuchElementException;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.iwe.avenger.dynamodb.entity.Avenger;
import com.iwe.avenger.lambda.exception.AvengerNotFoundException;
import com.iwe.avenger.lambda.response.HandlerResponse;
import com.iwe.avengers.dao.AvengerDAO;

public class RemoveAvengerHandler implements RequestHandler<Avenger, HandlerResponse> {
	
private AvengerDAO dao = new AvengerDAO();
	
	@Override
	public HandlerResponse handleRequest(final Avenger avenger, final Context context) {

		final String id = avenger.getId();

		context.getLogger().log("[#] - Searching Avenger with id: " + id);

		try {
			
			Avenger avengerToRemove = dao.find(avenger.getId());
			dao.remove(avengerToRemove);
			context.getLogger().log("[#] - Avenger found! Removing...");
		
		} catch(NoSuchElementException e) {
			throw new AvengerNotFoundException("[NotFound] - Avenger id");
		}

		final HandlerResponse response = HandlerResponse.builder().build();

		return response;
	}
}