package org.auction.dao;

import java.util.List;

import javax.sql.DataSource;

import org.auction.data.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class VehicleDetailDAO extends AbstractAuctionDAO<List<Vehicle>> {
	
	private final String QUERY_OPERATION="select ";
	private final String QUERY_PREDICATE=" from vehicle";

	@Override
	public List<Vehicle> fireQuery(List<Vehicle> p) {
		configureTemplate(dataSource);
		String vehicleID = p.get(0).getVehicleId();
		String sqlQuery = QUERY_OPERATION+vehicleID+QUERY_PREDICATE;
		List<Vehicle> vehicleList = jdbcTemplate.query(sqlQuery, new BeanPropertyRowMapper(Vehicle.class));
		return vehicleList;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

}
