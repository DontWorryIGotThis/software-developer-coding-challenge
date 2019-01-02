package org.auction.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Kirankumar
 *
 */
@Controller
@RequestMapping(value="/recordbid")
public class RecordBidController extends AbstractAuctionController {
	
	private static Log logger = LogFactory.getLog(RecordBidController.class);
	
	@RequestMapping(method=RequestMethod.GET)
	public void handleRequest() {
		super.handleRequest();
	}

}
