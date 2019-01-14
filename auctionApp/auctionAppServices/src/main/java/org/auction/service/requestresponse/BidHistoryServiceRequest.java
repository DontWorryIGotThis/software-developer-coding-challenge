/**
 * 
 */
package org.auction.service.requestresponse;

/**
 * @author Kirankumar
 *
 */
public class BidHistoryServiceRequest extends AbstractServiceRequest {
	
	String desiredVehicleId;

	public String getDesiredVehicleId() {
		return desiredVehicleId;
	}

	public void setDesiredVehicleId(String desiredVehicleId) {
		this.desiredVehicleId = desiredVehicleId;
	}
}
