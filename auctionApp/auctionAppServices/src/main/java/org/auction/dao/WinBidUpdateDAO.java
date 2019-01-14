/**
 * 
 */
package org.auction.dao;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.auction.data.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

/**
 * @author Kirankumar
 *
 */
public class WinBidUpdateDAO extends AbstractAuctionDAO<Vehicle> {
	
	private static final Logger log = Logger.getLogger(WinBidUpdateDAO.class);
	
	private static final String QUERY="update vehicle set winningbid = ? where vehicleid = ?";

	@Override
	public Vehicle fireQuery(Vehicle vehicle) {
		configureTemplate(dataSource);
		Long bidAmount = vehicle.getWinningBid();
		try {
		jdbcTemplate.update(QUERY, bidAmount, vehicle.getVehicleId());
		}catch(DataAccessException ex) {
			log.error("DAO: Error occured while updating winning bid");
			throw ex;
		}
		return vehicle;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

}
