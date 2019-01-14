/**
 * 
 */
package org.auction.controller;

import org.auction.controller.model.BidHistoryModel;
import org.auction.service.BidHistoryService;
import org.auction.service.requestresponse.AbstractServiceRequest;
import org.auction.service.requestresponse.AbstractServiceResponse;
import org.auction.service.requestresponse.BidHistoryServiceRequest;
import org.auction.service.requestresponse.BidHistoryServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Kirankumar
 *
 */
@Controller
public class BidHistoryController extends AbstractAuctionController<BidHistoryModel> {

	@Value("${bidhistory.view.get}")
	private String VIEW_NAME_GET;
	
	@RequestMapping(value="${bidhistory.get.uri}", method=RequestMethod.GET)
	public String handleRequest(Model model) {
		BidHistoryModel bidHistoryModel = new BidHistoryModel();
		model.addAttribute("bidHistoryModel", bidHistoryModel);
		return VIEW_NAME_GET;
	}
	
	@RequestMapping(value="${bidhistory.post.uri}", method=RequestMethod.POST)
	public String handlRequest(@ModelAttribute("bidHistoryModel")BidHistoryModel bidHistoryModel) {
		return super.handleRequest(bidHistoryModel);
	}
	
	@Override
	protected AbstractServiceRequest buildServiceRequest(BidHistoryModel bidHistoryModel) {
		BidHistoryServiceRequest serviceRequest = new BidHistoryServiceRequest();
		serviceRequest.setDesiredVehicleId(bidHistoryModel.getDesiredVehicleId());
		return serviceRequest;
	}

	@Override
	protected void buildModelResponse(BidHistoryModel p, AbstractServiceResponse serviceResponse) {
		BidHistoryServiceResponse response = (BidHistoryServiceResponse) serviceResponse;
		p.setBidHistoryDetailList(response.getBidHistoryDetailList());
		p.setVehicle(response.getVehicle());
	}
	
	@Autowired
	public void setBidHistoryService(BidHistoryService bidHistoryService) {
		super.setAuctionService(bidHistoryService);
	}
	
	@Value("${bidhistory.view.success}")
	public void setVIEW_NAME(String vIEW_NAME) {
		super.setVIEW_NAME(vIEW_NAME);
	}
}
