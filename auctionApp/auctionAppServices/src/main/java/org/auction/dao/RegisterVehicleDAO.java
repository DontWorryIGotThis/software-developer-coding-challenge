package org.auction.dao;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.auction.data.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

public class RegisterVehicleDAO extends AbstractAuctionDAO<Vehicle> {
	
	private static Logger log = Logger.getLogger(RegisterVehicleDAO.class);
	private final String QUERY = "insert into vehicle (vehicleid,make,model,milesdriven,winningbid) values (?,?,?,?,?)";

	@Override
	public Vehicle fireQuery(Vehicle p) {
		configureTemplate(this.dataSource);
		log.info("registering vehicle to database");
		try {
		jdbcTemplate.update(QUERY, p.getVehicleId(),p.getMake(),p.getModel(),p.getMilesDriven(),p.getWinningBid());
		}catch(DataAccessException ex) {
			log.error("DAO: error occured while registering vehicle \n"+ ex.getMessage());
			throw ex;
		}
		log.info("vehicle registered");
		return p;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

}
