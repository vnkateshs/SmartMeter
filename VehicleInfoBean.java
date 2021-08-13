package com.cts.ai.iot.smartmeter.bean;

public class VehicleInfoBean {

	private double avgAccident;
	private double avgClaims;
	private double avgSpeedings;
	private String type;
	public double getAvgAccident() {
		return avgAccident;
	}
	public void setAvgAccident(double avgAccident) {
		this.avgAccident = avgAccident;
	}
	public double getAvgClaims() {
		return avgClaims;
	}
	public void setAvgClaims(double avgClaims) {
		this.avgClaims = avgClaims;
	}
	public double getAvgSpeedings() {
		return avgSpeedings;
	}
	public void setAvgSpeedings(double avgSpeedings) {
		this.avgSpeedings = avgSpeedings;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public VehicleInfoBean(double avgAccident, double avgClaims, double avgSpeedings, String type) {
		super();
		this.avgAccident = avgAccident;
		this.avgClaims = avgClaims;
		this.avgSpeedings = avgSpeedings;
		this.type = type;
	}
	public VehicleInfoBean(double avgAccident, double avgClaims, double avgSpeedings) {
		super();
		this.avgAccident = avgAccident;
		this.avgClaims = avgClaims;
		this.avgSpeedings = avgSpeedings;
	}
	
	
	
	
	
	
	
	
	
	
}
