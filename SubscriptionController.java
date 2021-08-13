package com.cts.ai.iot.smartmeter.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ai.iot.smartmeter.bean.VehicleSensorData;
import com.cts.ai.iot.smartmeter.model.VehicleSensor;
import com.cts.ai.iot.smartmeter.service.VehicleSensorService;

@CrossOrigin(origins = "*")
@RestController
public class SubscriptionController {

	@Autowired
	VehicleSensorService vehicleSensorService;
	
	@RequestMapping(value = { "/vehicleSensorInfo" }, method = RequestMethod.POST)
	public ArrayList<VehicleSensor> getVehicleSensorInfo(@RequestParam String driverId,@RequestParam String vehicleId) {


		// Return some HTML
		ArrayList<VehicleSensor> vehicleInfo = vehicleSensorService.getVehicleSensorDetails(driverId, vehicleId);

		return vehicleInfo;
	}
	
	@RequestMapping(value = { "/vehicleSensorFactorValue" }, method = RequestMethod.GET)
	public VehicleSensorData getFactorValueFOrsensor(@RequestParam String driverId,@RequestParam String vehicleId) {


		// Return some HTML
		ArrayList<VehicleSensor> vehicleInfo = vehicleSensorService.getVehicleSensorDetails(driverId, vehicleId);
		VehicleSensorData vehicleSesnordata = vehicleSensorService.calculateFactorValue(vehicleInfo);
		
		
		
		return vehicleSesnordata;
	}
}
