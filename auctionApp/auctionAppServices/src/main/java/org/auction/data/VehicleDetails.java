/**
 * 
 */
package org.auction.data;

import java.util.List;

import org.auction.service.requestresponse.VehicleAttribute;

/**
 * @author Kirankumar
 *
 */
public class VehicleDetails {
	
	List<Vehicle> vehicleList;
	VehicleAttribute vehicleAttribute;
	String desiredVehicleID;
	
	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}
	public VehicleAttribute getVehicleAttribute() {
		return vehicleAttribute;
	}
	public void setVehicleAttribute(VehicleAttribute vehicleAttribute) {
		this.vehicleAttribute = vehicleAttribute;
	}
	public String getDesiredVehicleID() {
		return desiredVehicleID;
	}
	public void setDesiredVehicleID(String desiredVehicleID) {
		this.desiredVehicleID = desiredVehicleID;
	}
}
