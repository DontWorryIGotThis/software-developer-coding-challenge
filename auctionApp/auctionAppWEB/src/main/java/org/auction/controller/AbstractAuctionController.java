package org.auction.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.auction.controller.validator.AbstractValidator;
import org.auction.service.AbstractAuctionService;

/**
 * @author Kirankumar
 *
 */
public abstract class AbstractAuctionController {
	
	private static Log logger = LogFactory.getLog(AbstractAuctionController.class);
	
	AbstractAuctionService abstractAuctionService;
	AbstractValidator abstractValidator;
	
	protected void handleRequest() {
		
		try {
			abstractValidator.validate();
		}catch (Exception e) {
			logger.error("Error while validating request");
		}
		abstractAuctionService.makeCall();
		
		
	}

	public void setAbstractAuctionService(AbstractAuctionService abstractAuctionService) {
		this.abstractAuctionService = abstractAuctionService;
	}

	public void setAbstractValidator(AbstractValidator abstractValidator) {
		this.abstractValidator = abstractValidator;
	}

}
