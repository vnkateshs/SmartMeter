package com.cts.ai.iot.smartmeter.bean;

public class VehicleInput {

	public String location;
	public String vehicleId;
	public String dateOfbirth;
	public double factor;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getDateOfbirth() {
		return dateOfbirth;
	}
	public void setDateOfbirth(String dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}
	public VehicleInput(String location, String vehicleId, String dateOfbirth) {
		super();
		this.location = location;
		this.vehicleId = vehicleId;
		this.dateOfbirth = dateOfbirth;
	}
	public VehicleInput(String vehicleId) {
		super();
		this.vehicleId = vehicleId;
	}
	public double getFactor() {
		return factor;
	}
	public void setFactor(double factor) {
		this.factor = factor;
	}
	public VehicleInput(String location, String vehicleId, String dateOfbirth, double factor) {
		super();
		this.location = location;
		this.vehicleId = vehicleId;
		this.dateOfbirth = dateOfbirth;
		this.factor = factor;
	}
	public VehicleInput() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
