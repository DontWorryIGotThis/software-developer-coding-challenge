package org.auction.dao;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.auction.data.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;

public class RegisterVehicleDAO extends AbstractAuctionDAO<Vehicle> {
	
	private static Logger log = Logger.getLogger(RegisterVehicleDAO.class);
	private final String QUERY = "insert into vehicle (vehicleid,make,model,milesdriven) values (?,?,?,?)";

	@Override
	public Vehicle fireQuery(Vehicle p) {
		configureTemplate(this.dataSource);
		log.info("registering vehicle to database");
		jdbcTemplate.update(QUERY, p.getVehicleId(),p.getMake(),p.getModel(),p.getMilesDriven());
		log.info("vehicle registered");
		return p;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

}
