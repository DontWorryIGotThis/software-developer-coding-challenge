package org.auction.controller;

import org.apache.log4j.Logger;
import org.auction.controller.validator.AbstractValidator;
import org.auction.service.IAuctionService;
import org.auction.service.requestresponse.AbstractServiceRequest;
import org.auction.service.requestresponse.AbstractServiceResponse;

/**
 * @author Kirankumar
 *
 */
public abstract class AbstractAuctionController<P> {
	
	private static Logger logger = Logger.getLogger(RecordBidController.class);
	protected static final String FAILURE_FORWARD ="failure";
	
	protected String vIEW_NAME;
	
	protected IAuctionService auctionService;
	protected AbstractValidator abstractValidator;
	
	protected String handleRequest(P p) {
		
		try {
			//abstractValidator.validate(p);
			AbstractServiceRequest serviceRequest = buildServiceRequest(p);
			AbstractServiceResponse serviceResponse = callService(serviceRequest);
			buildModelResponse(p, serviceResponse);
		}catch (Exception e) {
			logger.warn("Error while handling request");
			return FAILURE_FORWARD;
		}
		return vIEW_NAME;
	}
	
	protected AbstractServiceResponse callService(AbstractServiceRequest serviceRequest) {
		return this.auctionService.makeCall(serviceRequest);
	}
	
	protected abstract AbstractServiceRequest buildServiceRequest(P p);
	
	protected abstract void buildModelResponse(P p, AbstractServiceResponse serviceResponse);

	public void setAuctionService(IAuctionService auctionService) {
		this.auctionService = auctionService;
	}
	public void setAbstractValidator(AbstractValidator abstractValidator) {
		this.abstractValidator = abstractValidator;
	}
	public void setVIEW_NAME(String vIEW_NAME) {
		this.vIEW_NAME = vIEW_NAME;
	}

}
