/**
 * 
 */
package org.auction.dao;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.auction.data.Bid;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Kirankumar
 *
 */
public class RecordBidDAO extends AbstractAuctionDAO<Bid> {

	private static Logger log = Logger.getLogger(RecordBidDAO.class);
	
	private String QUERY="insert into bid (bidid,vehicleid,userid,bidamount) values (?,?,?,?)";
	
	@Override
	public Bid fireQuery(Bid p) {
		configureTemplate(dataSource);
		log.info("Recording bid in to database");
		jdbcTemplate.update(QUERY, p.getBidId(), p.getVehicleId(),p.getUserId(),p.getBidAmount());
		log.info("Bid has been recorded into the database");
		return p;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
