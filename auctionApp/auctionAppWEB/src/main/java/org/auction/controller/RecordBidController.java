package org.auction.controller;

import org.apache.log4j.Logger;
import org.auction.controller.model.RecordBidModel;
import org.auction.service.RecordBidService;
import org.auction.service.requestresponse.AbstractServiceRequest;
import org.auction.service.requestresponse.AbstractServiceResponse;
import org.auction.service.requestresponse.RecordBidServiceRequest;
import org.auction.service.requestresponse.RecordBidServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Kirankumar
 *
 */
@Controller
public class RecordBidController extends AbstractAuctionController<RecordBidModel> {
	
	private static Logger log = Logger.getLogger(RecordBidController.class);
	
	
	@RequestMapping(value="${recordbid.post.uri}", method=RequestMethod.POST)
	public String handleIncomingRequest(@ModelAttribute("recordBidModel") RecordBidModel recordBidModel) {
		return super.handleRequest(recordBidModel);
	}

	@Override
	protected AbstractServiceRequest buildServiceRequest(RecordBidModel recordBidModel) {
		RecordBidServiceRequest serviceRequest = new RecordBidServiceRequest();
		serviceRequest.setBidAmount(recordBidModel.getBidAmount());
		serviceRequest.setUserId(recordBidModel.getUserId());
		serviceRequest.setVehicleId(recordBidModel.getVehicleId());
		return serviceRequest;
	}
	
	@Override
	protected void buildModelResponse(RecordBidModel p, AbstractServiceResponse serviceResponse) {
		RecordBidServiceResponse response = (RecordBidServiceResponse) serviceResponse;
		p.setBidId(response.getBidId());
	}
	
	@Autowired
	public void setRecordBidService(RecordBidService recordBidService) {
		this.auctionService=recordBidService;
	}
	
	@Value("${recordbid.view.success}")
	public void setRecordBidView(String vIEW_NAME) {
		super.setVIEW_NAME(vIEW_NAME);
	}
}
