/**
 * 
 */
package org.auction.service.requestresponse;

/**
 * @author Kirankumar
 *
 */
public enum VehicleQuantityMatcher {
	ALL("*");
	
	private String symbol;
	
	private VehicleQuantityMatcher(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

}
