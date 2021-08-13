package com.cts.ai.iot.smartmeter.bean;

import java.math.BigDecimal;

public class VehicleSensorData {

	private String dateReported;
	private String driverId;
	private String vehicleId;
	private BigDecimal factorValue;
	public String getDateReported() {
		return dateReported;
	}
	public void setDateReported(String dateReported) {
		this.dateReported = dateReported;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public BigDecimal getFactorValue() {
		return factorValue;
	}
	public void setFactorValue(BigDecimal factorValue) {
		this.factorValue = factorValue;
	}
	
	
		
}
