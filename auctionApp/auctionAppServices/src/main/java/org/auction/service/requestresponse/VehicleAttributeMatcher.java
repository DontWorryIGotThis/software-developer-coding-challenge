/**
 * 
 */
package org.auction.service.requestresponse;

/**
 * @author Kirankumar
 *
 */
public enum VehicleAttributeMatcher {
	ALL("*"),
	MAKE("make"),
	MODEL("model"),
	MILESDRIVEN("milesdriven"),
	WINNINGBID("winningbid");
	
	private String symbol;
	
	private VehicleAttributeMatcher(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

}
