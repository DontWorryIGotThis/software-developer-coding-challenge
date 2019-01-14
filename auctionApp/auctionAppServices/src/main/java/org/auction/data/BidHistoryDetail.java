/**
 * 
 */
package org.auction.data;

import org.auction.data.Bid;

/**
 * @author Kirankumar
 *
 */
public class BidHistoryDetail {
	
	Bid bid;
	String userName;
	public BidHistoryDetail(Bid bid, String userName) {
		this.setBid(bid);
		this.setUserName(userName);
	}
	
	public Bid getBid() {
		return bid;
	}
	public void setBid(Bid bid) {
		this.bid = bid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
