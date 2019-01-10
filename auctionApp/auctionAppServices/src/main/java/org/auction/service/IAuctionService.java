/**
 * 
 */
package org.auction.service;

import org.auction.service.requestresponse.AbstractServiceRequest;
import org.auction.service.requestresponse.AbstractServiceResponse;

/**
 * @author Kirankumar
 *
 */
public interface IAuctionService<P extends AbstractServiceRequest, Q extends AbstractServiceResponse> {
	
	public Q makeCall (P p);
		

}
