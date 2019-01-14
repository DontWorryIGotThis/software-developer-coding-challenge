/**
 * 
 */
package org.auction.dao;

import java.util.List;

import javax.sql.DataSource;

import org.auction.data.Bid;
import org.auction.data.BidHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 * @author Kirankumar
 *
 */
public class BidHistoryDAO extends AbstractAuctionDAO<BidHistory> {
	
	private static final String QUERY_OPERATION="select * from bid where vehicleid = ?";

	@Override
	public BidHistory fireQuery(BidHistory bidHistory) {
		configureTemplate(dataSource);
		String vehicleId = bidHistory.getVehicleId();
		List<Bid> bidList = jdbcTemplate.query(QUERY_OPERATION, new Object[] {vehicleId}, new BeanPropertyRowMapper(Bid.class));
		bidHistory.setBidHistoryList(bidList);
		return bidHistory;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

}
