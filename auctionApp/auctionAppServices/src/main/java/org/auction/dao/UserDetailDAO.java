/**
 * 
 */
package org.auction.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.auction.data.User;
import org.auction.data.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 * @author Kirankumar
 *
 */
public class UserDetailDAO extends AbstractAuctionDAO<UserDetails> {
	
	private static final Logger log = Logger.getLogger(UserDetailDAO.class);
	
	private static final String QUERY="select * from user";

	@Override
	public UserDetails fireQuery(UserDetails userDetail) {
		configureTemplate(dataSource);
		try {
		List<User> userList = jdbcTemplate.query(QUERY,new BeanPropertyRowMapper(User.class));
		userDetail.setUserList(userList);
		}catch(DataAccessException ex) {
			log.error("DAO: error occured while getting user details "+ex.getMessage());
			throw ex;
		}
		return userDetail;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

}
