package org.auction.service;

import java.util.UUID;

import org.apache.log4j.Logger;
import org.auction.dao.RegisterUserDAO;
import org.auction.data.User;
import org.auction.service.requestresponse.RegisterUserServiceRequest;
import org.auction.service.requestresponse.RegisterUserServiceResponse;
import org.auction.service.requestresponse.ServiceResponseScenario;
import org.springframework.beans.factory.annotation.Autowired;

public class RegisterUserService extends AbstractAuctionService<RegisterUserServiceRequest, RegisterUserServiceResponse> {

	private static final Logger log = Logger.getLogger(RegisterUserService.class);
	
	private final int UID_LENGTH= 5;
	
	@Override
	public RegisterUserServiceResponse makeCall(RegisterUserServiceRequest serviceRequest) {
		User userData = getUserData(serviceRequest);
		try {
		userData = (User) auctionDAO.fireQuery(userData);
		}catch(Exception ex) {
			log.error("Service: error occured while calling DAO");
			throw ex;
		}
		return getServiceResponse(userData);
	}
	
	private String generateRandomID() {
		return UUID.randomUUID().toString().substring(0, UID_LENGTH);
	}
	
	private User getUserData(RegisterUserServiceRequest serviceRequest) {
		String userID = generateRandomID();
		User userData = new User();
		userData.setEmail(serviceRequest.getEmail());
		userData.setName(serviceRequest.getName());
		userData.setUserId(userID);
		return userData;
	}
	
	private RegisterUserServiceResponse getServiceResponse(User userData) {
		RegisterUserServiceResponse serviceResponse = new RegisterUserServiceResponse();
		serviceResponse.setUserId(userData.getUserId());
		serviceResponse.setScenario(ServiceResponseScenario.SUCCESS);
		return serviceResponse;
	}
	
	@Autowired
	public void setRegisterUserDAO(RegisterUserDAO registerUserDAO) {
		super.setAuctionDAO(registerUserDAO);
	}

}
