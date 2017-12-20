package com.parkingapp.service;

import com.parkingapp.common.Color;
import com.parkingapp.dao.ParkingLotDAO;
import com.parkingapp.dao.ParkingLotDAOImpl;
import com.parkingapp.model.Vehicle;

public class ParkingServiceImpl implements ParkingService{

	private final ParkingLotDAO parkingLotDAO = new ParkingLotDAOImpl();
	@Override
	public void createParkingLot(final int size) {
		
		parkingLotDAO.createParkingLot(size);
		System.out.println("Created a parking lot with " + size + " slots");
	}
	
	@Override
	public void parkVehicle(String registrationNumber, String color) {
		
		Vehicle vehicle = new Vehicle();
		vehicle.setColor(Color.BLACK);
		vehicle.setRegistrationNo(registrationNumber);
		
		//parkingLotDAO.park(vehicle);
	}

}
