package org.auction.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
@RequestMapping(value="/recordbid")
public class RecordBidController extends AbstractAuctionController {
	
	private static final String viewId = "/WEB-INF/jsp/bidsuccess";
	private static Log logger = LogFactory.getLog(RecordBidController.class);
	
	@RequestMapping(method=RequestMethod.POST)
	public String handleRequest(@RequestBody RecordBidModel recordBidModel) {
		super.handleRequest();
		return viewId;
	}

	protected void buildServiceRequest() {
		logger.info("service request:");
		
	}

	protected void callService() {
//		auctionService.makeCall();
		
	}

	protected void buildModelResponse() {
		logger.info("Extracted Model:");
		
	}

}
