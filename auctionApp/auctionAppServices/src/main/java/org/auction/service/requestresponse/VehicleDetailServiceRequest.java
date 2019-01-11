/**
 * 
 */
package org.auction.service.requestresponse;

/**Set the VehicleID to '*' for represent all vehicles
 * 
 * @see org.auction.service.requestresponse.VehicleAttributeMatcher
 * 
 * @author Kirankumar
 *
 */
public class VehicleDetailServiceRequest extends AbstractServiceRequest {
	
	String vehicleId;

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
}
