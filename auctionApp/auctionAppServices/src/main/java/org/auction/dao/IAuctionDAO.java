/**
 * 
 */
package org.auction.dao;

/**
 * @author Kirankumar
 *
 */
public abstract interface IAuctionDAO<P> {
	
	public P fireQuery(P p);

}
