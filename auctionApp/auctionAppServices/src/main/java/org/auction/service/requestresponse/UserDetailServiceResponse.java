/**
 * 
 */
package org.auction.service.requestresponse;

import java.util.List;

import org.auction.data.User;

/**
 * @author Kirankumar
 *
 */
public class UserDetailServiceResponse extends AbstractServiceResponse {
	
	List<User> userList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
