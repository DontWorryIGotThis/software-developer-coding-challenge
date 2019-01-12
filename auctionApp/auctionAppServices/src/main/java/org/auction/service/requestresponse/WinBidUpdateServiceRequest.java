/**
 * 
 */
package org.auction.service.requestresponse;

import org.auction.data.Vehicle;

/**
 * @author Kirankumar
 *
 */
public class WinBidUpdateServiceRequest extends AbstractServiceRequest {
	Vehicle vehicle;

	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
