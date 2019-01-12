/**
 * 
 */
package org.auction.service.requestresponse;

/**Set the VehicleID to '*' for represent all vehicles
 * 
 * @see org.auction.service.requestresponse.VehicleAttribute
 * 
 * @author Kirankumar
 *
 */
public class VehicleDetailServiceRequest extends AbstractServiceRequest {
	
	String desiredVehicleId;
	VehicleAttribute vehicleAttribute;

	public String getDesiredVehicleId() {
		return desiredVehicleId;
	}
	public void setDesiredVehicleId(String vehicleId) {
		this.desiredVehicleId = vehicleId;
	}
	public VehicleAttribute getVehicleAttribute() {
		return vehicleAttribute;
	}
	public void setVehicleAttribute(VehicleAttribute vehicleAttribute) {
		this.vehicleAttribute = vehicleAttribute;
	}
}
