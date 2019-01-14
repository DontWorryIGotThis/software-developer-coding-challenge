/**
 * 
 */
package org.auction.service;

import java.util.UUID;

import org.apache.log4j.Logger;
import org.auction.dao.RegisterVehicleDAO;
import org.auction.data.Vehicle;
import org.auction.service.requestresponse.RegisterVehicleServiceRequest;
import org.auction.service.requestresponse.RegisterVehicleServiceResponse;
import org.auction.service.requestresponse.ServiceResponseScenario;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Kirankumar
 *
 */
public class RegisterVehicleService extends AbstractAuctionService<RegisterVehicleServiceRequest, RegisterVehicleServiceResponse> {

	private static final Logger log = Logger.getLogger(RegisterVehicleService.class);
	
	private final int UID_LENGTH = 6;
	
	@Override
	public RegisterVehicleServiceResponse makeCall(RegisterVehicleServiceRequest serviceRequest) {
		Vehicle vehicleData = getVehicleData(serviceRequest);
		try {
			vehicleData = (Vehicle) auctionDAO.fireQuery(vehicleData);
		}catch(Exception ex) {
			log.error("RegisterVehicleService: error occured while calling DAO "+ex.getMessage());
			throw ex;
		}
		return getServiceResponse(vehicleData);
	}
	
	private String getVehicleId() {
		String vehicleId = UUID.randomUUID().toString().substring(0, UID_LENGTH);
		return vehicleId;
	}
	
	private Vehicle getVehicleData(RegisterVehicleServiceRequest serviceRequest) {
		Vehicle vehicleData = new Vehicle();
		vehicleData.setMake(serviceRequest.getMake());
		vehicleData.setMilesDriven(serviceRequest.getMilesDriven());
		vehicleData.setModel(serviceRequest.getModel());
		vehicleData.setVehicleId(getVehicleId());
		vehicleData.setWinningBid(0);
		return vehicleData;
	}
	
	private RegisterVehicleServiceResponse getServiceResponse(Vehicle vehicleData) {
		RegisterVehicleServiceResponse serviceResponse = new RegisterVehicleServiceResponse();
		serviceResponse.setVehicleId(vehicleData.getVehicleId());
		serviceResponse.setScenario(ServiceResponseScenario.SUCCESS);
		return serviceResponse;
	}
	
	@Autowired
	public void setRegisterVehicleDAO(RegisterVehicleDAO registerVehicleDAO) {
		super.setAuctionDAO(registerVehicleDAO);
	}
}
