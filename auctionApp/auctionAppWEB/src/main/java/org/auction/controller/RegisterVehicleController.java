/**
 * 
 */
package org.auction.controller;

import org.auction.controller.model.RegisterVehicleModel;
import org.auction.service.RegisterVehicleService;
import org.auction.service.requestresponse.AbstractServiceRequest;
import org.auction.service.requestresponse.AbstractServiceResponse;
import org.auction.service.requestresponse.RegisterVehicleServiceRequest;
import org.auction.service.requestresponse.RegisterVehicleServiceResponse;
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
public class RegisterVehicleController extends AbstractAuctionController<RegisterVehicleModel> {
	
	
	@Value("${register.vehicle.view.get}")
	private String VIEW_NAME_GET;
	
	@RequestMapping(value="${register.vehicle.get.uri}", method=RequestMethod.GET)
	public String handleRequest(Model model) {
		RegisterVehicleModel vehicleModel = new RegisterVehicleModel();
		model.addAttribute("registerVehicle", vehicleModel);
		return VIEW_NAME_GET;
	}
	
	@RequestMapping(value="${register.vehicle.post.uri}", method=RequestMethod.POST)
	public String handleRequest(@ModelAttribute("registerVehicle") RegisterVehicleModel vehicleModel) {
		return super.handleRequest(vehicleModel);
	}

	@Override
	protected AbstractServiceRequest buildServiceRequest(RegisterVehicleModel vehicleModel) {
		RegisterVehicleServiceRequest serviceRequest = new RegisterVehicleServiceRequest();
		serviceRequest.setMake(vehicleModel.getMake());
		serviceRequest.setMilesDriven(vehicleModel.getMilesDriven());
		serviceRequest.setModel(vehicleModel.getModel());
		return serviceRequest;
	}

	@Override
	protected void buildModelResponse(RegisterVehicleModel p, AbstractServiceResponse serviceResponse) {
		RegisterVehicleServiceResponse response = (RegisterVehicleServiceResponse) serviceResponse;
		p.setVehicleId(response.getVehicleId());
	}
	
	@Autowired
	public void setRegisterVehicleService(RegisterVehicleService registerVehicleService) {
		super.setAuctionService(registerVehicleService);
	}
	
	@Value("${register.vehicle.view.success}")
	public void setVIEW_NAME(String vIEW_NAME) {
		super.setVIEW_NAME(vIEW_NAME);
	}

}
