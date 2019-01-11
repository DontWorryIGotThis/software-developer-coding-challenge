/**
 * 
 */
package org.auction.service.requestresponse;

/**
 * @author Kirankumar
 *
 */
public class RegisterVehicleServiceResponse extends AbstractServiceResponse {
	
	String vehicleId;

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
}
