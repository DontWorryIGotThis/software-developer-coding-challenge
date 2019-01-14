/**
 * 
 */
package org.auction.service.requestresponse;

import java.util.List;

import org.auction.data.Bid;
import org.auction.data.BidHistoryDetail;
import org.auction.data.Vehicle;

/**
 * @author Kirankumar
 *
 */
public class BidHistoryServiceResponse extends AbstractServiceResponse {
	
	List<Bid> BidHistoryList;
	List<BidHistoryDetail> bidHistoryDetailList;
	Vehicle vehicle;

	public List<Bid> getBidHistoryList() {
		return BidHistoryList;
	}

	public void setBidHistoryList(List<Bid> bidHistoryList) {
		BidHistoryList = bidHistoryList;
	}

	public List<BidHistoryDetail> getBidHistoryDetailList() {
		return bidHistoryDetailList;
	}

	public void setBidHistoryDetailList(List<BidHistoryDetail> bidHistoryDetail) {
		this.bidHistoryDetailList = bidHistoryDetail;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
}
