package com.parkingapp.dao;

import java.util.Map;

import com.parkingapp.common.Color;
import com.parkingapp.model.ParkingLotSpace;
import com.parkingapp.model.Vehicle;

public interface ParkingLotDAO {
	/**
	 * This method is use to create parking lot of {@value #size}
	 * @param size
	 */
	public void createParkingLot(final int size);
	public int park(final Vehicle vehicle);
	public Map<Vehicle,ParkingLotSpace> getParkedVechileDetails();
	public int unPark(final int slotId);
	public String getRegistrationNumbersOfVehicleByColor(Color color);
	public String getSlotNumbersOfVehicleByColour(Color color);
	public String getSlotNumberByregistrationNumbers(final String registrationNumber);
}
