/**
 * 
 */
package org.auction.service;

import org.auction.dao.UserDetailDAO;
import org.auction.dao.UserDetails;
import org.auction.service.requestresponse.UserDetailServiceRequest;
import org.auction.service.requestresponse.UserDetailServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Kirankumar
 *
 */
public class UserDetailService extends AbstractAuctionService<UserDetailServiceRequest, UserDetailServiceResponse> {

	@Override
	public UserDetailServiceResponse makeCall(UserDetailServiceRequest p) {
		UserDetails userDetails = new UserDetails();
		userDetails = (UserDetails) auctionDAO.fireQuery(userDetails);
		UserDetailServiceResponse serviceResponse = new UserDetailServiceResponse();
		serviceResponse.setUserList(userDetails.getUserList());
		return serviceResponse;
	}
	
	@Autowired
	public void setUserDetailDAO(UserDetailDAO userDetailDAO) {
		super.setAuctionDAO(userDetailDAO);
	}
}
