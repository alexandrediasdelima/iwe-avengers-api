package com.iwe.avengers;

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

		String id = avenger.getId();
		
		context.getLogger().log("[#] - delete Avenger wiht id:" + id);
		
		Avenger avengerResponse = dao.find(id);
		
		if(avengerResponse == null) {
			throw new AvengerNotFoundException("[NotFound] - Avenger id" + id + "not found");
		} else {
			dao.remove(id);
		}
		
		final HandlerResponse response = HandlerResponse.builder().setStatusCode(204).setObjectBody(avengerResponse).build();
		
		return response;
		
		
	}
}
