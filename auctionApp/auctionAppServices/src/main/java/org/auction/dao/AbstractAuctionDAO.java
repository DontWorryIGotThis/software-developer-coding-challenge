/**
 * 
 */
package org.auction.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Kirankumar
 *
 */
public abstract class AbstractAuctionDAO<P> implements IAuctionDAO<P>{
	
	protected DataSource dataSource;
	protected JdbcTemplate jdbcTemplate;

	public void configureTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
