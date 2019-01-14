/**
 * 
 */
package org.auction.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.auction.data.Bid;
import org.auction.data.BidHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 * @author Kirankumar
 *
 */
public class BidHistoryDAO extends AbstractAuctionDAO<BidHistory> {
	
	private static Logger log = Logger.getLogger(BidHistoryDAO.class);
	
	
	private static final String QUERY_OPERATION="select * from bid where vehicleid = ?";

	@Override
	public BidHistory fireQuery(BidHistory bidHistory) {
		configureTemplate(dataSource);
		String vehicleId = bidHistory.getVehicleId();
		try {
		List<Bid> bidList = jdbcTemplate.query(QUERY_OPERATION, new Object[] {vehicleId}, new BeanPropertyRowMapper(Bid.class));
		bidHistory.setBidHistoryList(bidList);
		}catch(DataAccessException ex) {
			log.error("DAO: error while firing query \n"+ex.getMessage());
			throw ex;
		}
		return bidHistory;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

}
