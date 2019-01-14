/**
 * 
 */
package org.auction.dao;

import java.util.List;

import javax.sql.DataSource;

import org.auction.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 * @author Kirankumar
 *
 */
public class UserDetailDAO extends AbstractAuctionDAO<UserDetails> {
	
	private static final String QUERY="select * from user";

	@Override
	public UserDetails fireQuery(UserDetails userDetail) {
		configureTemplate(dataSource);
		List<User> userList = jdbcTemplate.query(QUERY,new BeanPropertyRowMapper(User.class));
		userDetail.setUserList(userList);
		return userDetail;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

}
