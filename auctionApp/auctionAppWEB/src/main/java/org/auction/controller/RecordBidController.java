package org.auction.controller;

import org.apache.log4j.Logger;
import org.auction.controller.model.RecordBidModel;
import org.auction.service.RecordBidService;
import org.auction.service.requestresponse.AbstractServiceRequest;
import org.auction.service.requestresponse.AbstractServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Kirankumar
 *
 */
@Controller
public class RecordBidController extends AbstractAuctionController<RecordBidModel> {
	
	private static Logger logger = Logger.getLogger(RecordBidController.class);
	
	
	@Value("${recordbid.view.get}")
	private String vIEW_NAME_GET;
	
	@RequestMapping(value="${recordbid.get.uri}", method=RequestMethod.GET)
	public String handleRequest(Model model){
		super.handleRequest(null);
		
		RecordBidModel recordBidModel = new RecordBidModel();
		model.addAttribute("recordBidModel", recordBidModel);
		return vIEW_NAME_GET;
	}
	
	@RequestMapping(value="${recordbid.post.uri}", method=RequestMethod.POST)
	public String handleIncomingRequest(@ModelAttribute("recordBidModel") RecordBidModel recordBidModel) {
		//super.handleRequest(recordBidModel);
		return vIEW_NAME;
	}

	@Override
	protected AbstractServiceRequest buildServiceRequest(RecordBidModel p) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected void buildModelResponse(RecordBidModel p, AbstractServiceResponse serviceResponse) {
		// TODO Auto-generated method stub
		
	}
	
	@Value("${recordbid.view.success}")
	public void setRecordBidView(String vIEW_NAME) {
		super.setVIEW_NAME(vIEW_NAME);
	}


}
