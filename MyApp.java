package com.parkingapp.service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.parkingapp.model.Ticket;

public class MyApp {

	private static final String INPUT_SEPERATOR = "\\s+";

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (true) {
			String[] array = scanner.nextLine().split(INPUT_SEPERATOR);
			decideOperation(array);
		}
		// TO do
		// scanner.close();
	}

	public static void decideOperation(final String[] array) {

		final ParkingService parkingService = new ParkingServiceImpl();
		
		try {
			switch (array[0]) {
			case "create_parking_lot":

				parkingService.createParkingLot(Integer.parseInt(array[1]));

				break;
				
			case "park":

				String registrationNumber = array[1];
				String color = array[2];

				int slotId = parkingService.parkVehicle(registrationNumber, color);
				if(slotId != 0)
					System.out.println("Allocated slot number: " + slotId);
				else
					System.out.println("Sorry, parking lot is full");

				break;
				
			case "status":

				List<Ticket> tickets = parkingService.getParkedVehicleDetails();
				
				 if(tickets != null){
					 Iterator<Ticket> ticketIterator = tickets.iterator();
					 System.out.println("Slot No	" + "Registration No.	" + "Colour");
				        while (ticketIterator.hasNext()) {
				         Ticket ticket = ticketIterator.next();
				         System.out.println(ticket.getParkingSlotId() + "	" + ticket.getRegistrationNo() + "	" + ticket.getColor());
				            
				        }
				 }else{
					 System.out.println("No parking Lot is available.");
				 }

				break;
				
			case "leave":
				
				int leavedSlotId = parkingService.leaveVehicle(Integer.parseInt(array[1]));
				if(leavedSlotId != 0)
					System.out.println("Slot number " + leavedSlotId + " is free");
				else
					System.out.println("Please enter valid input");

				break;
				
			default:
				System.out.println("Please enter valid command");
				break;
			}
			
		} catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println("Please enter valid input");
		}
	}

}
