/**
 * 
 */
package org.auction.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.auction.dao.BidHistoryDAO;
import org.auction.data.Bid;
import org.auction.data.BidHistory;
import org.auction.data.BidHistoryDetail;
import org.auction.data.User;
import org.auction.data.Vehicle;
import org.auction.service.requestresponse.BidHistoryServiceRequest;
import org.auction.service.requestresponse.BidHistoryServiceResponse;
import org.auction.service.requestresponse.UserDetailServiceRequest;
import org.auction.service.requestresponse.UserDetailServiceResponse;
import org.auction.service.requestresponse.VehicleAttribute;
import org.auction.service.requestresponse.VehicleDetailServiceRequest;
import org.auction.service.requestresponse.VehicleDetailServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Kirankumar
 *
 */
public class BidHistoryService extends AbstractAuctionService<BidHistoryServiceRequest, BidHistoryServiceResponse> {

	@Autowired
	IAuctionService<UserDetailServiceRequest, UserDetailServiceResponse> userDetailService;
	
	@Autowired
	IAuctionService<VehicleDetailServiceRequest, VehicleDetailServiceResponse> vehicleDetailService;
	
	@Override
	public BidHistoryServiceResponse makeCall(BidHistoryServiceRequest serviceRequest) {
		BidHistoryServiceResponse serviceResponse = getBidHistory(serviceRequest);
		Vehicle vehicle = getVehicle(serviceRequest.getDesiredVehicleId());
		assembleBidHistoryDetails(serviceResponse, vehicle);
		return serviceResponse;
	}
	
	private BidHistoryServiceResponse getBidHistory(BidHistoryServiceRequest serviceRequest) {
		BidHistoryServiceResponse serviceResponse = new BidHistoryServiceResponse();
		BidHistory bidHistory = new BidHistory();
		bidHistory.setVehicleId(serviceRequest.getDesiredVehicleId());
		bidHistory = (BidHistory) auctionDAO.fireQuery(bidHistory);
		serviceResponse.setBidHistoryList(bidHistory.getBidHistoryList());
		return serviceResponse;
	}
	
	private void assembleBidHistoryDetails(BidHistoryServiceResponse serviceResponse, Vehicle vehicle) {
		HashMap<String,User> userMap = getUserMap();
		setDetailList(serviceResponse, userMap, vehicle);
	}
	
	private BidHistoryServiceResponse setDetailList(BidHistoryServiceResponse serviceResponse,
												HashMap<String,User> userMap,
												Vehicle vehicle){
		List<Bid> bidHistoryList = serviceResponse.getBidHistoryList();
		serviceResponse.setVehicle(vehicle);
		List<BidHistoryDetail> bidHistoryDetailList = new ArrayList<BidHistoryDetail>();
		for(Bid bid : bidHistoryList) {
			String userName = userMap.get(bid.getUserId()).getName();
			BidHistoryDetail bidHistoryDetail = new BidHistoryDetail(bid, userName);
			bidHistoryDetailList.add(bidHistoryDetail);
		}
		serviceResponse.setBidHistoryDetailList(bidHistoryDetailList);
		return serviceResponse;
	}
	
	private HashMap<String,User> getUserMap() {
		UserDetailServiceRequest request = new UserDetailServiceRequest();
		UserDetailServiceResponse response = userDetailService.makeCall(request);
		HashMap<String, User> userMap = makeUserMap(response.getUserList());
		return userMap;
	}
	
	private Vehicle getVehicle(String vehicleId) {
		VehicleDetailServiceRequest request = new VehicleDetailServiceRequest();
		request.setDesiredVehicleId(vehicleId);
		request.setVehicleAttribute(VehicleAttribute.ALL);
		VehicleDetailServiceResponse response = vehicleDetailService.makeCall(request);
		return response.getVehicleList().get(0);
	}
	
	private HashMap<String,User>makeUserMap(List<User> userList){
		HashMap<String, User> userMap = new HashMap<String,User>();
		for(User user : userList) {
			userMap.put(user.getUserId(), user);
		}
		return userMap;
	}

	@Autowired
	public void setBidHistoryDAO(BidHistoryDAO bidHistoryDAO) {
		super.setAuctionDAO(bidHistoryDAO);
	}

}
