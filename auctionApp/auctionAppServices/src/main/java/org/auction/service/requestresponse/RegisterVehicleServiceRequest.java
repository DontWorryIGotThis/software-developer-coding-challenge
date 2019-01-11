/**
 * 
 */
package org.auction.service.requestresponse;

/**
 * @author Kirankumar
 *
 */
public class RegisterVehicleServiceRequest extends AbstractServiceRequest {
	
	String make;
	String model;
	Long milesDriven;

	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public long getMilesDriven() {
		return milesDriven;
	}
	public void setMilesDriven(long milesDriven) {
		this.milesDriven = milesDriven;
	}
}
