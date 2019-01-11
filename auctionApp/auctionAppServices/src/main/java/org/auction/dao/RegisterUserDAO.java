package org.auction.dao;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.auction.data.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Kirankumar
 *
 */

public class RegisterUserDAO extends AbstractAuctionDAO<User> {
	
	private final String QUERY="insert into user (userid,email,name) values (?,?,?)";
	private static Logger log = Logger.getLogger(RegisterUserDAO.class);

	public User fireQuery(User p) {
		configureTemplate(this.dataSource);
		log.info("Registering user to database");
		jdbcTemplate.update(QUERY, p.getUserId(), p.getEmail(), p.getName());
		log.info("User successfully registered");
		return p;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

}
