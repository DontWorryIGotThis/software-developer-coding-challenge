package org.auction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Kirankumar
 *
 */
@Controller
public class RecordBidController extends AbstractAuctionController {
	
	@RequestMapping(value="/recordbid", method=RequestMethod.GET)
	public void handleRequest() {
		super.handleRequest();
	}

}
