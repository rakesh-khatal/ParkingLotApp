package com.parkingapp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.parkingapp.common.Color;
import com.parkingapp.dao.ParkingLotDAOImpl;
import com.parkingapp.model.ParkingLotSpace;
import com.parkingapp.model.Ticket;
import com.parkingapp.model.Vehicle;

public class ParkingServiceImpl implements ParkingService {

	@Override
	public void createParkingLot(final int size) {

		ParkingLotDAOImpl.getInstance().createParkingLot(size);
		System.out.println("Created a parking lot with " + size + " slots");
	}

	@Override
	public int parkVehicle(String registrationNumber, Color color) {
		
		Vehicle vehicle = new Vehicle();
		vehicle.setColor(color);
		vehicle.setRegistrationNo(registrationNumber);

		int slotId = ParkingLotDAOImpl.getInstance().park(vehicle);

		return slotId;

	}

	@Override
	public List<Ticket> getParkedVehicleDetails() {

		Map<Vehicle, ParkingLotSpace> occupiedParkingSpaces = ParkingLotDAOImpl.getInstance().getParkedVechileDetails();
		if (occupiedParkingSpaces != null) {
			Iterator iterator = occupiedParkingSpaces.entrySet().iterator();
			List<Ticket> ticketList = new ArrayList<>();
			while (iterator.hasNext()) {

				Map.Entry pair = (Map.Entry) iterator.next();

				ParkingLotSpace parkingLotSpace = (ParkingLotSpace) pair.getValue();
				Vehicle vehicle = (Vehicle) pair.getKey();
				Ticket ticket = new Ticket();
				ticket.setParkingSlotId(parkingLotSpace.getSlotId());
				ticket.setColor(vehicle.getColor());
				ticket.setRegistrationNo(vehicle.getRegistrationNo());

				ticketList.add(ticket);

			}
			return ticketList;
		}
		return null;
	}

	@Override
	public int leaveVehicle(int slotId) {

		int emptySlotId = ParkingLotDAOImpl.getInstance().unPark(slotId);
		return emptySlotId;
	}

	@Override
	public String getRegistrationNumbersOfVehicleByColor(Color color) {
		
		return ParkingLotDAOImpl.getInstance()
				.getRegistrationNumbersOfVehicleByColor(color);
	}

	@Override
	public String getSlotNumbersOfVehicleByColour(Color color) {
		
		return ParkingLotDAOImpl.getInstance().getSlotNumbersOfVehicleByColour(color);
	}

	@Override
	public String getSlotNumberByregistrationNumbers(String registrationNumber) {
		
		return ParkingLotDAOImpl.getInstance().getSlotNumberByregistrationNumbers(registrationNumber);
	}
	
	
}
