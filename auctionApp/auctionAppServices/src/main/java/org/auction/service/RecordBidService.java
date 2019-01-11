/**
 * 
 */
package org.auction.service;

import java.util.UUID;

import org.auction.dao.RecordBidDAO;
import org.auction.data.Bid;
import org.auction.service.requestresponse.RecordBidServiceRequest;
import org.auction.service.requestresponse.RecordBidServiceResponse;
import org.auction.service.requestresponse.ServiceResponseScenario;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Kirankumar
 *
 */
public class RecordBidService extends AbstractAuctionService<RecordBidServiceRequest, RecordBidServiceResponse> {

	@Override
	public RecordBidServiceResponse makeCall(RecordBidServiceRequest serviceRequest) {
		Bid bid=getBid(serviceRequest);
		bid =(Bid) auctionDAO.fireQuery(bid);
		return getServiceResponse(bid);
	}
	
	public Bid getBid(RecordBidServiceRequest serviceRequest) {
		Bid bid = new Bid();
		String bidId= UUID.randomUUID().toString().substring(0, 7);
		bid.setBidAmount(serviceRequest.getBidAmount());
		bid.setUserId(serviceRequest.getUserId());
		bid.setVehicleId(serviceRequest.getVehicleId());
		bid.setBidId(bidId);
		return bid;
	}
	
	public RecordBidServiceResponse getServiceResponse(Bid bid) {
		RecordBidServiceResponse serviceResponse = new RecordBidServiceResponse();
		serviceResponse.setScenario(ServiceResponseScenario.SUCCESS);
		serviceResponse.setBidId(bid.getBidId());
		return serviceResponse;
	}
	
	@Autowired
	public void setRecordBidDAO(RecordBidDAO recordBidDAO) {
		this.setAuctionDAO(recordBidDAO);
	}

}
