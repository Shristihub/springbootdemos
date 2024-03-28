package com.insuranceapp.model;

public class Insurance {

	private Integer insuranceId;
	private String policyName;
	private String brand;
	private String type;
	private int duration;
	private double premium;
	public Insurance(Integer insuranceId, String policyName, String brand, String type, int duration, double premium) {
		super();
		this.insuranceId = insuranceId;
		this.policyName = policyName;
		this.brand = brand;
		this.type = type;
		this.duration = duration;
		this.premium = premium;
	}
	public Integer getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(Integer insuranceId) {
		this.insuranceId = insuranceId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	@Override
	public String toString() {
		return "Insurance [insuranceId=" + insuranceId + ", policyName=" + policyName + ", brand=" + brand + ", type="
				+ type + ", duration=" + duration + ", premium=" + premium + "]";
	}
	
	
	
	
	
}
