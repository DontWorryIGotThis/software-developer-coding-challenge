package org.auction.controller;

import org.apache.log4j.Logger;
import org.auction.controller.model.RecordBidModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Kirankumar
 *
 */
@Controller
public class RecordBidController extends AbstractAuctionController<RecordBidModel> {
	
	private static final String viewName = "bidsuccess";
	private static Logger logger = Logger.getLogger(RecordBidController.class);
	
	@RequestMapping(value="/recordbid", method=RequestMethod.POST)
	public String handleIncomingRequest(/*@RequestBody RecordBidModel recordBidModel*/) {
		//super.handleRequest(recordBidModel);
		return viewName;
	}

	protected void buildServiceRequest() {
		logger.info("service request:");
		
	}

	protected void callService() {
//		auctionService.makeCall();
		
	}

	protected void buildModelResponse(RecordBidModel recordBidModel) {
		logger.info("Extracted Model:");
		
	}

}
