package org.auction.controller.model;

import java.util.ArrayList;
import java.util.List;

import org.auction.data.Vehicle;

/**
 * @author Kirankumar
 *
 */
public class RecordBidModel {
	
	public String userId;
	public String vehicleId;
	public Long bidAmount;
	public List<Vehicle> vehicleList = new ArrayList<Vehicle>();
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public Long getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(Long bidAmount) {
		this.bidAmount = bidAmount;
	}
}
