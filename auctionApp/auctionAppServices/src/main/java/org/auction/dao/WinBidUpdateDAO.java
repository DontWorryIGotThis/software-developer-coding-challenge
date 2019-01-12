/**
 * 
 */
package org.auction.dao;

import javax.sql.DataSource;

import org.auction.data.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Kirankumar
 *
 */
public class WinBidUpdateDAO extends AbstractAuctionDAO<Vehicle> {
	
	private static final String QUERY="update vehicle set winningbid = ? where vehicleid = ?";

	@Override
	public Vehicle fireQuery(Vehicle vehicle) {
		configureTemplate(dataSource);
		Long bidAmount = vehicle.getWinningBid();
		jdbcTemplate.update(QUERY, bidAmount, vehicle.getVehicleId());
		return vehicle;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

}
