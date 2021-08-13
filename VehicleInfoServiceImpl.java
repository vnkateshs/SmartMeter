package com.cts.ai.iot.smartmeter.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.ai.iot.smartmeter.bean.VehicleInfoBean;
import com.cts.ai.iot.smartmeter.bean.VehicleInput;
import com.cts.ai.iot.smartmeter.bean.VenicleInfoResponse;
import com.cts.ai.iot.smartmeter.dao.VehicleInfoDao;
import com.cts.ai.iot.smartmeter.model.VehicleInfo;

@Service("VehicleInfoService")
public class VehicleInfoServiceImpl implements VehicleInfoService {

	@Autowired
	VehicleInfoDao vehicleInfoDao;

	@Override
	public ArrayList<VehicleInfo> getVehicleInfoByLocation(String location) {
		// TODO Auto-generated method stub
		ArrayList<VehicleInfo> vehicleInfo = vehicleInfoDao.getVehicleInfoByLocation(location);
		return vehicleInfo;
	}


	@Override
	public VenicleInfoResponse getVehicleDetails(VehicleInput vehicleInput) {
		// TODO Auto-generated method stub
		VenicleInfoResponse vehicleInfo = vehicleInfoDao.getVehicleDetails(vehicleInput);
		return vehicleInfo;
	}

}
