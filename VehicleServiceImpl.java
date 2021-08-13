package com.cts.ai.iot.smartmeter.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.ai.iot.smartmeter.bean.VehicleSensorData;
import com.cts.ai.iot.smartmeter.dao.VehicleSensorDao;
import com.cts.ai.iot.smartmeter.model.VehicleSensor;

@Service
public class VehicleServiceImpl implements VehicleSensorService {

	private static final String BRAKE_ASSIST = "Brake Assist";
	
	private static final String LANE_ASSIST = "Lane Assist";
	
	@Autowired
	VehicleSensorDao vehicleSensorDao;
	
	@Override
	public ArrayList<VehicleSensor> getVehicleSensorDetails(String driverId, String vehicleId) {
		ArrayList<VehicleSensor> vehicleSensorDetails = vehicleSensorDao.getVehicleSensorDetails(vehicleId, driverId);
		return vehicleSensorDetails;
	}

	@Override
	public VehicleSensorData calculateFactorValue(ArrayList<VehicleSensor> vehicleSensorDetails) {
		VehicleSensorData vehicleSensorData = new VehicleSensorData();
		Double finalFactorValue = new Double(0);
		
		for (VehicleSensor vehicleSensor : vehicleSensorDetails) {
			String sensorType = vehicleSensor.getSensorType();
			int count = vehicleSensor.getCount();
			Double factorValue = new Double(0);
			if(count > 0 && count < 5) {
				if(BRAKE_ASSIST.equalsIgnoreCase(sensorType))
					factorValue = 0.3;
				if(LANE_ASSIST.equalsIgnoreCase(sensorType))
					factorValue = 0.1;
				
			} else if(count >= 5 && count <10) {
				if(BRAKE_ASSIST.equalsIgnoreCase(sensorType))
					factorValue = 0.5;
				if(LANE_ASSIST.equalsIgnoreCase(sensorType))
					factorValue = 0.2;
				
			} else if(count >= 10 && count <20) {
				if(BRAKE_ASSIST.equalsIgnoreCase(sensorType))
					factorValue = 0.7;
				if(LANE_ASSIST.equalsIgnoreCase(sensorType))
					factorValue = 0.4;
				
			} else if(count>=20){
				if(BRAKE_ASSIST.equalsIgnoreCase(sensorType))
					factorValue = 0.9;
				if(LANE_ASSIST.equalsIgnoreCase(sensorType))
					factorValue = 0.6;
			}
			factorValue = factorValue * count;
			finalFactorValue = finalFactorValue + factorValue;
		}
		finalFactorValue = finalFactorValue/100;
		if(vehicleSensorDetails !=null && !vehicleSensorDetails.isEmpty()) {
			vehicleSensorData.setDriverId(vehicleSensorDetails.get(0).getDriverId());
			vehicleSensorData.setVehicleId(vehicleSensorDetails.get(0).getVehicleId());
			vehicleSensorData.setFactorValue(BigDecimal.valueOf(finalFactorValue) );
		}
		return vehicleSensorData;
		
	}
}
