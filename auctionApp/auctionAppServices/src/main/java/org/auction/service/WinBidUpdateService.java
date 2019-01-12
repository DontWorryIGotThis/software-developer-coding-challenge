/**
 * 
 */
package org.auction.service;

import org.auction.dao.WinBidUpdateDAO;
import org.auction.data.Vehicle;
import org.auction.service.requestresponse.ServiceResponseScenario;
import org.auction.service.requestresponse.WinBidUpdateServiceRequest;
import org.auction.service.requestresponse.WinBidUpdateServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This service is designed to update the vehicle details with the winning bid amount
 * Ideally called with a new bid amount greater than the current bid amount is detected
 * 
 * @see org.auction.service.RecordBidService
 * 
 * @author Kirankumar
 *
 */
public class WinBidUpdateService extends AbstractAuctionService<WinBidUpdateServiceRequest, WinBidUpdateServiceResponse> {

	@Override
	public WinBidUpdateServiceResponse makeCall(WinBidUpdateServiceRequest serviceRequest) {
		Vehicle vehicle = serviceRequest.getVehicle();
		vehicle = (Vehicle) auctionDAO.fireQuery(vehicle);
		WinBidUpdateServiceResponse serviceResponse = new WinBidUpdateServiceResponse();
		serviceResponse.setScenario(ServiceResponseScenario.SUCCESS);
		return serviceResponse;
	}
		
	@Autowired
	public void setWinBidUpdateDAO(WinBidUpdateDAO winBidUpdateDAO) {
		super.setAuctionDAO(winBidUpdateDAO);
	}
}
