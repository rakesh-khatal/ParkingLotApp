package com.parkingapp.model;

import com.parkingapp.common.Color;

public class Ticket {
	
	private String registrationNo;
	
	private Color color;
	
	private int parkingSlotId;

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

	public int getParkingSlotId() {
		return parkingSlotId;
	}

	public void setParkingSlotId(int parkingSlotId) {
		this.parkingSlotId = parkingSlotId;
	}
	
	

}
