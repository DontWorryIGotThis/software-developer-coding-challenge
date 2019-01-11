/**
 * 
 */
package org.auction.dao;

import org.auction.data.AbstractData;

/**
 * @author Kirankumar
 *
 */
public abstract interface IAuctionDAO<P> {
	
	public P fireQuery(P p);

}
