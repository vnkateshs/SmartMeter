package com.cts.ai.iot.smartmeter.dao;

import java.util.ArrayList;

import com.cts.ai.iot.smartmeter.model.VehicleSensor;

public interface VehicleSensorDao {

	public ArrayList<VehicleSensor> getVehicleSensorDetails(String vehicleId, String driverId);
}
