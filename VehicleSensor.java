package com.cts.ai.iot.smartmeter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@Entity
@Table(name = "vehiclesensorinformation")

public class VehicleSensor {

	@Id
	@Column(name = "ID", unique = true, updatable = false, nullable = false)
	@GeneratedValue
	private long id;
	
	@Column(name = "datereported")
	private String dateReported;
	
	@Column(name = "driverid")
	private String driverId;
	
	@Column(name = "vehicleid")
	private String vehicleId;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zip")
	private Integer zip;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "sensortype")
	private String sensorType;
	
	@Column(name = "faultcount")
	private Integer count;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSensorType() {
		return sensorType;
	}

	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
