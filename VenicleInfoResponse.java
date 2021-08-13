package com.cts.ai.iot.smartmeter.bean;

import java.util.ArrayList;

public class VenicleInfoResponse {

	public double total;
	public double ageAvgTotal;
	public double locationAvgTotal;
	public double vehicleAvgTotal;
	public ArrayList<VehicleInfoBean> ageList;
	public ArrayList<VehicleInfoBean> locationList;
	public ArrayList<VehicleInfoBean> vehicleList;
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public ArrayList<VehicleInfoBean> getAgeList() {
		return ageList;
	}
	public void setAgeList(ArrayList<VehicleInfoBean> ageList) {
		this.ageList = ageList;
	}
	public ArrayList<VehicleInfoBean> getLocationList() {
		return locationList;
	}
	public void setLocationList(ArrayList<VehicleInfoBean> locationList) {
		this.locationList = locationList;
	}
	public ArrayList<VehicleInfoBean> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(ArrayList<VehicleInfoBean> vehicleList) {
		this.vehicleList = vehicleList;
	}
	public double getAgeAvgTotal() {
		return ageAvgTotal;
	}
	public void setAgeAvgTotal(double ageAvgTotal) {
		this.ageAvgTotal = ageAvgTotal;
	}
	public double getLocationAvgTotal() {
		return locationAvgTotal;
	}
	public void setLocationAvgTotal(double locationAvgTotal) {
		this.locationAvgTotal = locationAvgTotal;
	}
	public double getVehicleAvgTotal() {
		return vehicleAvgTotal;
	}
	public void setVehicleAvgTotal(double vehicleAvgTotal) {
		this.vehicleAvgTotal = vehicleAvgTotal;
	}
	
	
	
	
	
	
}
