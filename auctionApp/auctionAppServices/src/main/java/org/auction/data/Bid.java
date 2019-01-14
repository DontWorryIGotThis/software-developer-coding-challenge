/**
 * 
 */
package org.auction.data;

/**
 * @author Kirankumar
 *
 */
public class Bid {
	public String userId;
	public String vehicleId;
	public Long bidAmount;
	public String bidId;
	
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
	public String getBidId() {
		return bidId;
	}
	public void setBidId(String bidId) {
		this.bidId = bidId;
	}
}
