/**
 * 
 */
package com.parkingapp.service;

import java.util.List;

import com.parkingapp.model.Ticket;

/**
 * @author rakesh.khatal
 *
 */
public interface ParkingService {

	/**
	 * This method is use to create parking lot of {@value #size}
	 * @param size
	 */
	public void createParkingLot(final int size);
	public int parkVehicle(String registrationNumber, String color);
	public List<Ticket> getParkedVehicleDetails();
}
