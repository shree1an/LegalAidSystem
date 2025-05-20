package com.eNyaya.model;

import java.time.LocalDate;

public class ClientModel {
    private int clientID;
    private String clientName;
    private String clientEmail;

    private String clientNumber;
    private String clientPassword;
    private LocalDate dateOfBirth;
    private String gender;
    
    public ClientModel() {
    	
    }
    
    public ClientModel(String clientEmail, String clientPassword) {
    	this.clientEmail = clientEmail;
		this.clientPassword = clientPassword;
    }
    
	public ClientModel(String clientName, String clientEmail, String clientNumber,
			String clientPassword, LocalDate dateOfBirth, String gender) {
		super();
		this.clientName = clientName;
		this.clientEmail = clientEmail;

		this.clientNumber = clientNumber;
		this.clientPassword = clientPassword;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}
	
	public ClientModel(int clientID, String clientName, String clientEmail, String clientNumber,
			String clientPassword, LocalDate dateOfBirth, String gender) {
		super();
		this.clientID = clientID;
		this.clientName = clientName;
		this.clientEmail = clientEmail;

		this.clientNumber = clientNumber;
		this.clientPassword = clientPassword;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}
	
	public int getClientID() {
		return clientID;
	}
	
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	
	public String getClientName() {
		return clientName;
	}
	
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	public String getClientEmail() {
		return clientEmail;
	}
	
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	

	public String getClientNumber() {
		return clientNumber;
	}
	
	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber;
	}
	
	public String getClientPassword() {
		return clientPassword;
	}
	
	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
 
    
}