package org.auction.controller;

import org.auction.controller.model.RegisterUserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Kirankumar
 *
 */


public class RegisterUserController extends AbstractAuctionController<RegisterUserModel> {

	private static final String VIEW_NAME ="registersuccess";
	
	@RequestMapping(value="/registeruser", method=RequestMethod.POST)
	public String handleIncomingRequest(/*@RequestBody RegisterUserModel registerModel*/) {
		//super.handleRequest(registerModel);
		return VIEW_NAME;
	}
	protected void buildServiceRequest() {

	}

	protected void callService() {

	}

	protected void buildModelResponse(RegisterUserModel registerModel) {
		// TODO Auto-generated method stub

	}

}
