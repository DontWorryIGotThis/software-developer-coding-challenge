/**
 * 
 */
package org.auction.service.requestresponse;

/**
 * @author Kirankumar
 *
 */
public class UserDetailServiceRequest extends AbstractServiceRequest {
	
	String userId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
