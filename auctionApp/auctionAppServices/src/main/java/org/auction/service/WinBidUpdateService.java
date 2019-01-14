/**
 * 
 */
package org.auction.service;

import org.apache.log4j.Logger;
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

	private static final Logger log = Logger.getLogger(WinBidUpdateService.class);
	
	@Override
	public WinBidUpdateServiceResponse makeCall(WinBidUpdateServiceRequest serviceRequest) {
		WinBidUpdateServiceResponse serviceResponse = new WinBidUpdateServiceResponse();
		Vehicle vehicle = serviceRequest.getVehicle();
		try {
		vehicle = (Vehicle) auctionDAO.fireQuery(vehicle);
		serviceResponse.setScenario(ServiceResponseScenario.SUCCESS);
		}catch(Exception ex) {
			log.error("Service: Error occured while calling DAO \n"+ex.getMessage());
			throw ex;
		}
		return serviceResponse;
	}
		
	@Autowired
	public void setWinBidUpdateDAO(WinBidUpdateDAO winBidUpdateDAO) {
		super.setAuctionDAO(winBidUpdateDAO);
	}
}
