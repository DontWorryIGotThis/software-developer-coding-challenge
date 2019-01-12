package org.auction.dao;

import java.util.List;

import javax.sql.DataSource;

import org.auction.data.Vehicle;
import org.auction.data.VehicleDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class VehicleDetailDAO extends AbstractAuctionDAO<VehicleDetails> {
	
	private static final String QUERY_OPERATION="select ";
	private static final String QUERY_PREDICATE=" from vehicle";
	private static final String QUERY_CLAUSE=" where vehicleid = '";

	@Override
	public VehicleDetails fireQuery(VehicleDetails vehicleDetails) {
		configureTemplate(dataSource);
		String sqlQuery = getQueryStatement(vehicleDetails);
		List<Vehicle> vehicleList = jdbcTemplate.query(sqlQuery, new BeanPropertyRowMapper(Vehicle.class));
		vehicleDetails.setVehicleList(vehicleList);
		return vehicleDetails;
	}
	
	private String getQueryStatement(VehicleDetails vehicleDetails) {
		String vehicleAttribute= vehicleDetails.getVehicleAttribute().getSymbol();
		String vehicleId = vehicleDetails.getDesiredVehicleID();
		if(vehicleDetails.getDesiredVehicleID()==null) {
			return QUERY_OPERATION+vehicleAttribute+QUERY_PREDICATE;
		}else {
			return QUERY_OPERATION+vehicleAttribute+QUERY_PREDICATE+QUERY_CLAUSE+vehicleId+"'";
		}
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

}
