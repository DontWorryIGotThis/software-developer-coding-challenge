package org.auction.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.auction.data.Vehicle;
import org.auction.data.VehicleDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class VehicleDetailDAO extends AbstractAuctionDAO<VehicleDetails> {
	
	private static final Logger log = Logger.getLogger(VehicleDetailDAO.class);
	
	private static final String QUERY_1="select * from vehicle";
	private static final String QUERY_2="select * from vehicle where vehicleid = ?";

	@Override
	public VehicleDetails fireQuery(VehicleDetails vehicleDetails) {
		configureTemplate(dataSource);
		try {
		List<Vehicle> vehicleList = getVehicleList(vehicleDetails);
		vehicleDetails.setVehicleList(vehicleList);
		}catch(DataAccessException ex) {
			log.error("DAO: error occured while fetching vehicle details \n"+ex.getMessage());
			throw ex;
		}
		return vehicleDetails;
	}
	
	private List<Vehicle> getVehicleList(VehicleDetails vehicleDetails) {
		String vehicleId = vehicleDetails.getDesiredVehicleID();
		if(vehicleDetails.getDesiredVehicleID()==null) {
			return jdbcTemplate.query(QUERY_1,new BeanPropertyRowMapper(Vehicle.class));
		}else {
			return jdbcTemplate.query(QUERY_2,new Object[] {vehicleId} ,new BeanPropertyRowMapper(Vehicle.class));
		}
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
}
