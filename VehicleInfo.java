package com.cts.ai.iot.smartmeter.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@Entity
@Table(name = "vehicleinformation")

public class VehicleInfo {

	@Id
	@Column(name = "ID", unique = true, updatable = false, nullable = false)
	@GeneratedValue
	private long id;

	@Column(name = "date")
	private Date date;

	@Column(name = "driverid")
	private String driverid;

	@Column(name = "vehicleid")
	private String vehicleid;

	@Column(name = "state")
	private String state;

	@Column(name = "location")
	private String location;

	@Column(name = "age")
	private int age;
	
	@Column(name = "accidents")
	private double accidents;
	
	@Column(name = "speeding")
	private double speeding;
	
	
	@Column(name = "claims")
	private double claims;
	
	@Column(name = "vehicletype")
	private String vehicletype;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	public String getDriverid() {
		return driverid;
	}

	public void setDriverid(String driverid) {
		this.driverid = driverid;
	}

	public String getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(String vehicleid) {
		this.vehicleid = vehicleid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getAccidents() {
		return accidents;
	}

	public void setAccidents(double accidents) {
		this.accidents = accidents;
	}

	public double getSpeeding() {
		return speeding;
	}

	public void setSpeeding(double speeding) {
		this.speeding = speeding;
	}

	public double getClaims() {
		return claims;
	}

	public void setClaims(double claims) {
		this.claims = claims;
	}

	public String getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}

	

	

	
}
