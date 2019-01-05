package org.auction.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.auction.controller.validator.AbstractValidator;
import org.auction.service.IAuctionService;

/**
 * @author Kirankumar
 *
 */
public abstract class AbstractAuctionController {
	
	private static Log logger = LogFactory.getLog(AbstractAuctionController.class);
	
	IAuctionService auctionService;
	AbstractValidator abstractValidator;
	
	protected void handleRequest() {
		
		try {
			abstractValidator.validate();
			buildServiceRequest();
			callService();
			buildModelResponse();
		}catch (Exception e) {
			logger.warn("Error while handling request");
		}
		
		
	}
	protected abstract void buildServiceRequest();
	
	protected abstract void callService();
	
	protected abstract void buildModelResponse();


	public void setAuctionService(IAuctionService auctionService) {
		this.auctionService = auctionService;
	}
	public void setAbstractValidator(AbstractValidator abstractValidator) {
		this.abstractValidator = abstractValidator;
	}

}
