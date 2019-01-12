/**
 * 
 */
package org.auction.service.requestresponse;

/**
 * @author Kirankumar
 *
 */
public enum VehicleAttribute {
	ALL("*"),
	MAKE("make"),
	MODEL("model"),
	MILESDRIVEN("milesdriven"),
	WINNINGBID("winningbid");
	
	private String symbol;
	
	private VehicleAttribute(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

}
