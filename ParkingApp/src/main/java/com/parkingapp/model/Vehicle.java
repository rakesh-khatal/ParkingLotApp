package com.parkingapp.model;

import com.parkingapp.common.Color;

public class Vehicle {
	
	private String registrationNo;
	
	private Color color;

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public int hashCode() {
		  int hash = 41;
	        hash = hash + (33 * hash) + this.registrationNo.hashCode();;
	        return hash;
	}
	@Override
	public boolean equals(Object obj) {
		
		 return (((Vehicle) obj).registrationNo == this.registrationNo);
	}

}
