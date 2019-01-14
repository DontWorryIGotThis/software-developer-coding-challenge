/**
 * 
 */
package org.auction.service;

import java.util.UUID;

import org.auction.dao.RecordBidDAO;
import org.auction.data.Bid;
import org.auction.data.Vehicle;
import org.auction.service.requestresponse.RecordBidServiceRequest;
import org.auction.service.requestresponse.RecordBidServiceResponse;
import org.auction.service.requestresponse.ServiceResponseScenario;
import org.auction.service.requestresponse.VehicleAttribute;
import org.auction.service.requestresponse.VehicleDetailServiceRequest;
import org.auction.service.requestresponse.VehicleDetailServiceResponse;
import org.auction.service.requestresponse.WinBidUpdateServiceRequest;
import org.auction.service.requestresponse.WinBidUpdateServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Kirankumar
 *
 */
public class RecordBidService extends AbstractAuctionService<RecordBidServiceRequest, RecordBidServiceResponse> {
	
	private final int UID_LENGTH = 7;
	@Autowired
	IAuctionService<VehicleDetailServiceRequest, VehicleDetailServiceResponse> vehicleDetailService;
	
	@Autowired
	IAuctionService<WinBidUpdateServiceRequest, WinBidUpdateServiceResponse> winBidUpdateService;

	@Override
	public RecordBidServiceResponse makeCall(RecordBidServiceRequest serviceRequest) {
		Bid bid = makeRecordBidCall(serviceRequest);
		if(checkForWinningBid(serviceRequest)) {
			updateWinningBid(serviceRequest);
		}
		return getServiceResponse(bid);
	}
	
	
	/* Methods for recording the Bid*/
	private Bid makeRecordBidCall(RecordBidServiceRequest serviceRequest) {
		Bid bid=getBid(serviceRequest);
		bid =(Bid) auctionDAO.fireQuery(bid);
		return bid;
	}
	
	private Bid getBid(RecordBidServiceRequest serviceRequest) {
		Bid bid = new Bid();
		String bidId= UUID.randomUUID().toString().substring(0, UID_LENGTH);
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
	
	/*Methods for checking winning Bid*/
	private boolean checkForWinningBid(RecordBidServiceRequest bidRequest) {
		long newBid = bidRequest.getBidAmount();
		long oldBid= getOldBidAmount(bidRequest.getVehicleId());
		return (newBid > oldBid) ? true : false;
	}
	
	private long getOldBidAmount(String vehicleId) {
		VehicleDetailServiceRequest serviceRequest = getVehicleDetailsServiceRequest(vehicleId);
		VehicleDetailServiceResponse serviceResponse = vehicleDetailService.makeCall(serviceRequest);
		return serviceResponse.getVehicleList().get(0).getWinningBid();
	}
	
	private VehicleDetailServiceRequest getVehicleDetailsServiceRequest(String vehicleId) {
		VehicleDetailServiceRequest vehicleRequest = new VehicleDetailServiceRequest();
		vehicleRequest.setDesiredVehicleId(vehicleId);
		vehicleRequest.setVehicleAttribute(VehicleAttribute.ALL);
		return vehicleRequest;
	}
	
	/*Methods for updating the winning Bid*/
	private void updateWinningBid(RecordBidServiceRequest recordBidRequest) {
		WinBidUpdateServiceRequest serviceRequest = getWinBidUpdateServiceRequest(recordBidRequest);
		winBidUpdateService.makeCall(serviceRequest);
	}
	
	private WinBidUpdateServiceRequest getWinBidUpdateServiceRequest(RecordBidServiceRequest recordBidRequest) {
		WinBidUpdateServiceRequest serviceRequest = new WinBidUpdateServiceRequest();
		Vehicle vehicle = getUpdatedVehicle(recordBidRequest);
		serviceRequest.setVehicle(vehicle);
		return serviceRequest;
	}
	
	private Vehicle getUpdatedVehicle(RecordBidServiceRequest serviceRequest) {
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleId(serviceRequest.getVehicleId());
		vehicle.setWinningBid(serviceRequest.getBidAmount());
		return vehicle;
	}
	
	@Autowired
	public void setRecordBidDAO(RecordBidDAO recordBidDAO) {
		this.setAuctionDAO(recordBidDAO);
	}

}
