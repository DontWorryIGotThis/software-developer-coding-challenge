package org.auction.data;

public class Vehicle {
	String make;
	String model;
	Long milesDriven;
	String vehicleId;
	Long winningBid;

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
	public long getWinningBid() {
		return winningBid;
	}
	public void setWinningBid(long winningBid) {
		this.winningBid = winningBid;
	}
	
}
