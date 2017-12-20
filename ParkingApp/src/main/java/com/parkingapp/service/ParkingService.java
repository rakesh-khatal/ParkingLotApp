/**
 * 
 */
package com.parkingapp.service;

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
	public void parkVehicle(String registrationNumber, String color);
}
