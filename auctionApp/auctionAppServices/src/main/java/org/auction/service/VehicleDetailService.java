package org.auction.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.auction.dao.VehicleDetailDAO;
import org.auction.data.Vehicle;
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
		List<Vehicle> vehicleList = getDesiredVehiclesIds(serviceRequest);
		vehicleList =(List<Vehicle>) auctionDAO.fireQuery(vehicleList);
		return getServiceResponse(vehicleList);
	}
	
	private List<Vehicle> getDesiredVehiclesIds(VehicleDetailServiceRequest serviceRequest){
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleId(serviceRequest.getVehicleId());
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		vehicleList.add(vehicle);
		return vehicleList;
	}
	
	private VehicleDetailServiceResponse getServiceResponse(List<Vehicle> vehicleList) {
		VehicleDetailServiceResponse serviceResponse = new VehicleDetailServiceResponse();
		serviceResponse.setVehicleList(getExtractedVehicleDetails(vehicleList));
		serviceResponse.setScenario(ServiceResponseScenario.SUCCESS);
		return serviceResponse;
	}
	
	private List<Vehicle> getExtractedVehicleDetails(List<Vehicle> vehicleList){
		List<Vehicle> vehicleListExtract = new ArrayList<Vehicle>();
		Iterator<Vehicle> iterator = vehicleList.iterator();
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
