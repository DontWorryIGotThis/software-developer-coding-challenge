/**
 * 
 */
package org.auction.data;

import java.util.List;

/**
 * @author Kirankumar
 *
 */
public class BidHistory {
	
	String VehicleId;
	List<Bid> bidHistoryList;
	public String getVehicleId() {
		return VehicleId;
	}
	public void setVehicleId(String vehicleId) {
		VehicleId = vehicleId;
	}
	public List<Bid> getBidHistoryList() {
		return bidHistoryList;
	}
	public void setBidHistoryList(List<Bid> bidHistoryList) {
		this.bidHistoryList = bidHistoryList;
	}
}
