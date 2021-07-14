package com.pack.dto;

import java.util.Date;

public class DonorDTO {
	
	private  String  email;
	
	private  Long    phone;
	
	private  Date    lastDonationDate;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public Date getLastDonationDate() {
		return lastDonationDate;
	}
	public void setLastDonationDate(Date lastDonationDate) {
		this.lastDonationDate = lastDonationDate;
	}
	
	

}
