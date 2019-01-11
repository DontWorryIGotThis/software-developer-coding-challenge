/**
 * 
 */
package org.auction.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.auction.controller.model.AllVehicleModel;
import org.auction.controller.model.RecordBidModel;
import org.auction.data.Vehicle;
import org.auction.service.VehicleDetailService;
import org.auction.service.requestresponse.AbstractServiceRequest;
import org.auction.service.requestresponse.AbstractServiceResponse;
import org.auction.service.requestresponse.VehicleDetailServiceRequest;
import org.auction.service.requestresponse.VehicleDetailServiceResponse;
import org.auction.service.requestresponse.VehicleAttributeMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Kirankumar
 *
 */
@Controller
public class AllVehicleController extends AbstractAuctionController<AllVehicleModel> {
	
	private static final Logger log = Logger.getLogger(AllVehicleController.class);
	
	@RequestMapping(value="${allvehicle.get.uri}", method=RequestMethod.GET)
	public String handleRequest(Model model) {
		AllVehicleModel allVehicle = new AllVehicleModel();
		RecordBidModel recordBidModel = new RecordBidModel();
		try {
			super.handleRequest(allVehicle);
			model.addAttribute("allVehicle", allVehicle);
			model.addAttribute("recordBidModel",recordBidModel);
			return vIEW_NAME;
		}catch(Exception e) {
			log.error("Error occured while getting all vehicle details");
			return FAILURE_FORWARD;
		}
	}


	@Override
	protected AbstractServiceRequest buildServiceRequest(AllVehicleModel p) {
		VehicleDetailServiceRequest vehicleDetailServiceRequest = new VehicleDetailServiceRequest();
		vehicleDetailServiceRequest.setVehicleId(VehicleAttributeMatcher.ALL.getSymbol());
		return vehicleDetailServiceRequest;
	}

	@Override
	protected void buildModelResponse(AllVehicleModel allVehicle, AbstractServiceResponse serviceResponse) {
		VehicleDetailServiceResponse response = (VehicleDetailServiceResponse) serviceResponse;
		allVehicle.setVehicleList((List<Vehicle>) response.getVehicleList());
	}
	
	@Autowired
	public void setVehicleDetailService(VehicleDetailService vehicleDetailService) {
		super.setAuctionService(vehicleDetailService);
	}

	@Value("${recordbid.view.get}")
	public void setVIEW_NAME(String vIEW_NAME) {
		super.setVIEW_NAME(vIEW_NAME);
	}
}
