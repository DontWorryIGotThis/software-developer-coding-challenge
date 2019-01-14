/**
 * 
 */
package org.auction.dao;

import java.util.List;

import org.auction.data.User;

/**
 * @author Kirankumar
 *
 */
public class UserDetails {
	
	List<User> userList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
