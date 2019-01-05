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
public abstract class AbstractAuctionService<P extends AbstractServiceRequest, Q extends AbstractServiceResponse> implements IAuctionService<P,Q> {
	
	

}
