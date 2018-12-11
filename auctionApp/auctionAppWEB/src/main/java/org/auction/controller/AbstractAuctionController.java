package org.auction.controller;

import org.auction.controller.validator.AbstractValidator;
import org.auction.service.AbstractAuctionService;

/**
 * @author Kirankumar
 *
 */
public abstract class AbstractAuctionController {
	
	AbstractAuctionService abstractAuctionService;
	AbstractValidator abstractValidator;
	
	protected void handleRequest() {
		
		abstractValidator.validate();
		abstractAuctionService.makeCall();
		
		
	}

}
