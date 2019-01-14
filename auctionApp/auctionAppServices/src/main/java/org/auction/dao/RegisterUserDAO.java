package org.auction.dao;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.auction.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

/**
 * @author Kirankumar
 *
 */

public class RegisterUserDAO extends AbstractAuctionDAO<User> {
	
	private static final Logger log = Logger.getLogger(RegisterUserDAO.class);
	
	private final String QUERY="insert into user (userid,email,name) values (?,?,?)";

	public User fireQuery(User p) {
		configureTemplate(this.dataSource);
		log.info("Registering user to database");
		try {
		jdbcTemplate.update(QUERY, p.getUserId(), p.getEmail(), p.getName());
		}catch(DataAccessException ex) {
			log.error("DAO: error occured while inserting user details \n"+ex.getMessage());
			throw ex;
		}
		log.info("User successfully registered");
		return p;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

}
