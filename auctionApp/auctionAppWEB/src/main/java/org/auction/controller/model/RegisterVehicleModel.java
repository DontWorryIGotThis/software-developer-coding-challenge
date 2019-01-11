/**
 * 
 */
package org.auction.controller.model;

/**
 * @author Kirankumar
 *
 */
public class RegisterVehicleModel {
	
	String make;
	String model;
	long milesDriven;
	String vehicleId;
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public long getMilesDriven() {
		return milesDriven;
	}
	public void setMilesDriven(long milesDriven) {
		this.milesDriven = milesDriven;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
}
