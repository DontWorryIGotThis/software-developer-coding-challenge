package org.auction.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.auction.dao.VehicleDetailDAO;
import org.auction.data.Vehicle;
import org.auction.data.VehicleDetails;
import org.auction.service.requestresponse.ServiceResponseScenario;
import org.auction.service.requestresponse.VehicleDetailServiceRequest;
import org.auction.service.requestresponse.VehicleDetailServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This service can retrieve all vehicle details or one specific vehicle detail
 * using vehicleID
 * 
 * @author Kirankumar
 */
public class VehicleDetailService extends AbstractAuctionService<VehicleDetailServiceRequest, VehicleDetailServiceResponse> {

	@Override
	public VehicleDetailServiceResponse makeCall(VehicleDetailServiceRequest serviceRequest) {
		VehicleDetails vehicleDetails = getVehicleDetails(serviceRequest);
		vehicleDetails =(VehicleDetails) auctionDAO.fireQuery(vehicleDetails);
		return getServiceResponse(vehicleDetails);
	}
	
	private VehicleDetails getVehicleDetails(VehicleDetailServiceRequest serviceRequest){
		VehicleDetails vehicleDetails = new VehicleDetails();
		vehicleDetails.setVehicleAttribute(serviceRequest.getVehicleAttribute());
		vehicleDetails.setDesiredVehicleID(serviceRequest.getDesiredVehicleId());
		return vehicleDetails;
	}
	
	private VehicleDetailServiceResponse getServiceResponse(VehicleDetails vehicleDetails) {
		VehicleDetailServiceResponse serviceResponse = new VehicleDetailServiceResponse();
		serviceResponse.setVehicleList(getExtractedVehicleDetails(vehicleDetails));
		serviceResponse.setScenario(ServiceResponseScenario.SUCCESS);
		return serviceResponse;
	}
	
	private List<Vehicle> getExtractedVehicleDetails(VehicleDetails vehicleDetails){
		List<Vehicle> vehicleListExtract = new ArrayList<Vehicle>();
		Iterator<Vehicle> iterator = vehicleDetails.getVehicleList().iterator();
		Vehicle tempVehicle;
		while(iterator.hasNext()) {
			tempVehicle=iterator.next();
			Vehicle newVehicle = new Vehicle();
			newVehicle.setMake(tempVehicle.getMake());
			newVehicle.setMilesDriven(tempVehicle.getMilesDriven());
			newVehicle.setModel(tempVehicle.getModel());
			newVehicle.setVehicleId(tempVehicle.getVehicleId());
			newVehicle.setWinningBid(tempVehicle.getWinningBid());
			vehicleListExtract.add(newVehicle);
		}
		return vehicleListExtract;
	}
	
	@Autowired
	public void setVehicleDetailDAO(VehicleDetailDAO vehicleDetailDAO) {
		super.setAuctionDAO(vehicleDetailDAO);
	}

}
