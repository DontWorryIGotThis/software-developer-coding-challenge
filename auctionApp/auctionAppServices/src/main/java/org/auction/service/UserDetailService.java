/**
 * 
 */
package org.auction.service;

import org.apache.log4j.Logger;
import org.auction.dao.UserDetailDAO;
import org.auction.data.UserDetails;
import org.auction.service.requestresponse.UserDetailServiceRequest;
import org.auction.service.requestresponse.UserDetailServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Kirankumar
 *
 */
public class UserDetailService extends AbstractAuctionService<UserDetailServiceRequest, UserDetailServiceResponse> {

	private static final Logger log = Logger.getLogger(UserDetailService.class);
	
	@Override
	public UserDetailServiceResponse makeCall(UserDetailServiceRequest p) {
		UserDetailServiceResponse serviceResponse = new UserDetailServiceResponse();
		UserDetails userDetails = new UserDetails();
		try {
		userDetails = (UserDetails) auctionDAO.fireQuery(userDetails);
		}catch(Exception ex) {
			log.error("UserDetailService: error occured while calling DAO \n"+ ex.getMessage());
			throw ex;
		}
		serviceResponse.setUserList(userDetails.getUserList());
		return serviceResponse;
	}
	
	@Autowired
	public void setUserDetailDAO(UserDetailDAO userDetailDAO) {
		super.setAuctionDAO(userDetailDAO);
	}
}
