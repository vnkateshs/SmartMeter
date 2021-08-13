package com.cts.ai.iot.smartmeter.dao;

import java.util.ArrayList;

import com.cts.ai.iot.smartmeter.bean.VehicleInput;
import com.cts.ai.iot.smartmeter.bean.VenicleInfoResponse;
import com.cts.ai.iot.smartmeter.model.VehicleInfo;

public interface VehicleInfoDao {

	public ArrayList<VehicleInfo> getVehicleInfoByLocation(String location);

	public VenicleInfoResponse getVehicleDetails(VehicleInput vehicleInput);
	
}
