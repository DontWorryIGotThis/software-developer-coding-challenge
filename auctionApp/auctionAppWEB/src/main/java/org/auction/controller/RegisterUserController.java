package org.auction.controller;

import org.auction.controller.model.RegisterUserModel;
import org.auction.service.RegisterUserService;
import org.auction.service.requestresponse.AbstractServiceResponse;
import org.auction.service.requestresponse.RegisterUserServiceRequest;
import org.auction.service.requestresponse.RegisterUserServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Kirankumar
 *
 */

@Controller
public class RegisterUserController extends AbstractAuctionController<RegisterUserModel> {
	
	@Value("${register.user.view.get}")
	private String VIEW_NAME_GET;
	
	@RequestMapping(value="${register.user.get.uri}", method=RequestMethod.GET)
	public String handleRequest(Model model) {
		model.addAttribute("registerModel", new RegisterUserModel());
		return VIEW_NAME_GET;
	}
	
	@RequestMapping(value="${register.user.post.uri}", method=RequestMethod.POST)
	public String handleRequest(@ModelAttribute("registerModel") RegisterUserModel registerModel, Model model) {
		return super.handleRequest(registerModel);
	}
	
	protected RegisterUserServiceRequest buildServiceRequest(RegisterUserModel registerUserModel) {
		RegisterUserServiceRequest serviceRequest = new RegisterUserServiceRequest();
		serviceRequest.setEmail(registerUserModel.getEmail());
		serviceRequest.setName(registerUserModel.getName());
		return serviceRequest;
	}

	protected void buildModelResponse(RegisterUserModel registerModel, AbstractServiceResponse serviceResponse) {
		RegisterUserServiceResponse response = (RegisterUserServiceResponse) serviceResponse;
		registerModel.setUserId(response.getUserId());
	}
	
	@Autowired
	public void setService(RegisterUserService registerUserService) {
		this.auctionService = registerUserService;
	}
	
	@Value("${register.user.view.success}")
	public void setVIEW_NAME(String vIEW_NAME) {
		super.setVIEW_NAME(vIEW_NAME);
	}

}
