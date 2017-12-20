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

public class ParkingServiceImpl implements ParkingService{

	@Override
	public void createParkingLot(final int size) {
		
		ParkingLotDAOImpl.getInstance().createParkingLot(size);
		System.out.println("Created a parking lot with " + size + " slots");
	}
	
	@Override
	public int parkVehicle(String registrationNumber, String color) {
		
		Vehicle vehicle = new Vehicle();
		vehicle.setColor(Color.BLACK);
		vehicle.setRegistrationNo(registrationNumber);
		
		int slotId = ParkingLotDAOImpl.getInstance().park(vehicle);
		
		return slotId;
					
	}

	@Override
	public List<Ticket> getParkedVehicleDetails() {

		Map<Vehicle,ParkingLotSpace> occupiedParkingSpaces = ParkingLotDAOImpl.getInstance().getParkedVechileDetails();
		Iterator iterator = occupiedParkingSpaces.entrySet().iterator();
		List<Ticket> ticketList = new ArrayList<>();
	    while (iterator.hasNext()) {
	    	
	        Map.Entry pair = (Map.Entry)iterator.next();
	        
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

}
