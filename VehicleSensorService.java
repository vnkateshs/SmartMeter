package com.cts.ai.iot.smartmeter.service;

import java.util.ArrayList;

import com.cts.ai.iot.smartmeter.bean.VehicleSensorData;
import com.cts.ai.iot.smartmeter.model.VehicleSensor;

public interface VehicleSensorService {

	public ArrayList<VehicleSensor> getVehicleSensorDetails(String driverId, String vehicleId);
	
	public VehicleSensorData calculateFactorValue(ArrayList<VehicleSensor> vehicleSensorDetails);
}
