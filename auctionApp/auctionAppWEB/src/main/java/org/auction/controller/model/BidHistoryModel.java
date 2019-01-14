/**
 * 
 */
package org.auction.controller.model;

import java.util.List;

import org.auction.data.BidHistoryDetail;
import org.auction.data.Vehicle;

/**
 * @author Kirankumar
 *
 */
public class BidHistoryModel {
	
	List<BidHistoryDetail> bidHistoryDetailList;
	String desiredVehicleId;
	Vehicle vehicle;

	public List<BidHistoryDetail> getBidHistoryDetailList() {
		return bidHistoryDetailList;
	}
	public void setBidHistoryDetailList(List<BidHistoryDetail> bidHistoryDetailList) {
		this.bidHistoryDetailList = bidHistoryDetailList;
	}
	public String getDesiredVehicleId() {
		return desiredVehicleId;
	}
	public void setDesiredVehicleId(String desiredVehicleId) {
		this.desiredVehicleId = desiredVehicleId;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
