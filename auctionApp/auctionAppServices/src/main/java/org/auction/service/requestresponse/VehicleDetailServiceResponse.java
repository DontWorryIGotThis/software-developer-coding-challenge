/**
 * 
 */
package org.auction.service.requestresponse;

import java.util.List;

import org.auction.data.Vehicle;

/**
 * @author Kirankumar
 *
 */
public class VehicleDetailServiceResponse extends AbstractServiceResponse {
	private List<Vehicle> vehicleList;

	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}
}
