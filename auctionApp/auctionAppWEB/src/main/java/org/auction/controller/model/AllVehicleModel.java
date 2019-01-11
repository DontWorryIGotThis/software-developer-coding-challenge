/**
 * 
 */
package org.auction.controller.model;

import java.util.List;

import org.auction.data.Vehicle;

/**
 * @author Kirankumar
 *
 */
public class AllVehicleModel {
	
	List<Vehicle> vehicleList;

	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}
}
