package org.auction.controller;

import org.apache.log4j.Logger;
import org.auction.controller.validator.AbstractValidator;
import org.auction.service.IAuctionService;

/**
 * @author Kirankumar
 *
 */
public abstract class AbstractAuctionController<P> {
	
	private static Logger logger = Logger.getLogger(RecordBidController.class);
	protected static final String FAILURE_FORWARD ="failure";
	
	IAuctionService auctionService;
	AbstractValidator abstractValidator;
	
	protected void handleRequest(P p) {
		
		try {
			abstractValidator.validate(p);
			buildServiceRequest();
			callService();
			buildModelResponse(p);
		}catch (Exception e) {
			logger.warn("Error while handling request");
		}
	}
	protected abstract void buildServiceRequest();
	
	protected abstract void callService();
	
	protected abstract void buildModelResponse(P p);


	public void setAuctionService(IAuctionService auctionService) {
		this.auctionService = auctionService;
	}
	public void setAbstractValidator(AbstractValidator abstractValidator) {
		this.abstractValidator = abstractValidator;
	}

}
