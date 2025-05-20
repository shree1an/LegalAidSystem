package com.eNyaya.model;

import java.time.LocalDate;

public class LawyerModel {
	private int lawyerID;
    private String lawyerName;
    private String lawyerEmail;
    private String lawyerNumber;
    private String lawyerPassword;
    private String licenseNumber;
    private LocalDate dateJoined;
    private String status;
    private String district;
    private String province;
    
    public LawyerModel() {
    	
    }
    
    public LawyerModel(String lawyerEmail, String lawyerPassword) {
    	this.lawyerEmail = lawyerEmail;
    	this.lawyerPassword = lawyerPassword;
    	
    }
    
    public LawyerModel(String lawyerName, String lawyerEmail, String lawyerNumber, String lawyerPassword,
			String licenseNumber, LocalDate dateJoined, String status, String district, String province) {
		super();
		this.lawyerName = lawyerName;
		this.lawyerEmail = lawyerEmail;
		this.lawyerNumber = lawyerNumber;
		this.lawyerPassword = lawyerPassword;
		this.licenseNumber = licenseNumber;
		this.dateJoined = dateJoined;
		this.status = status;
		this.district = district;
		this.province = province;
	}
    

	public LawyerModel(int lawyerID, String lawyerName, String lawyerEmail, String lawyerNumber, String lawyerPassword,
			String licenseNumber, LocalDate dateJoined, String status, String district, String province) {
		super();
		this.lawyerID = lawyerID; 
		this.lawyerName = lawyerName;
		this.lawyerEmail = lawyerEmail;
		this.lawyerNumber = lawyerNumber;
		this.lawyerPassword = lawyerPassword;
		this.licenseNumber = licenseNumber;
		this.dateJoined = dateJoined;
		this.status = status;
		this.district = district;
		this.province = province;
	}

	public String getLawyerName() {
		return lawyerName;
	}

	public void setLawyerName(String lawyerName) {
		this.lawyerName = lawyerName;
	}

	public String getLawyerEmail() {
		return lawyerEmail;
	}

	public void setLawyerEmail(String lawyerEmail) {
		this.lawyerEmail = lawyerEmail;
	}

	public String getLawyerNumber() {
		return lawyerNumber;
	}

	public void setLawyerNumber(String lawyerNumber) {
		this.lawyerNumber = lawyerNumber;
	}

	public String getLawyerPassword() {
		return lawyerPassword;
	}

	public void setLawyerPassword(String lawyerPassword) {
		this.lawyerPassword = lawyerPassword;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public LocalDate getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(LocalDate dateJoined) {
		this.dateJoined = dateJoined;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public int getLawyerID() {
		return lawyerID;
	}

	public void setLawyerID(int lawyerID) {
		this.lawyerID = lawyerID;
	}
    
    
	
	
    
}