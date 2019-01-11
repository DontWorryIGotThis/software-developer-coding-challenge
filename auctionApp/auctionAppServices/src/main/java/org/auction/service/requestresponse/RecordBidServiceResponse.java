package org.auction.service.requestresponse;

public class RecordBidServiceResponse extends AbstractServiceResponse {
	String bidId;

	public String getBidId() {
		return bidId;
	}
	public void setBidId(String bidId) {
		this.bidId = bidId;
	}
}
