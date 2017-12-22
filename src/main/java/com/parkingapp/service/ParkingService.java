/**
 * 
 */
package com.parkingapp.service;

import java.util.List;

import com.parkingapp.common.Color;
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
	/**
	 * This method is use to park the vehicle
	 * @param registrationNumber
	 * @param color
	 */
	public int parkVehicle(final String registrationNumber, Color color);
	
	/**
	 * This method is use to get the all park vehicles available in parking lot
	 * @param slotId
	 */
	public List<Ticket> getParkedVehicleDetails();
	
	/**
	 * This method is use to empty parking slot
	 * @param slotId
	 */
	public int leaveVehicle(final int slotId);
	
	public String getRegistrationNumbersOfVehicleByColor(Color color);
	public String getSlotNumbersOfVehicleByColour(Color color);
	public String getSlotNumberByregistrationNumbers(final String registrationNumber);
}
