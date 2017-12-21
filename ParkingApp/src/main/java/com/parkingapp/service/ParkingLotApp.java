package com.parkingapp.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.parkingapp.common.Color;
import com.parkingapp.common.InputAction;
import com.parkingapp.model.Ticket;

/**
 * @author rakesh.khatal
 *
 */
public class ParkingLotApp {

	private static final String INPUT_SEPERATOR = "\\s+";

	private static boolean quit = false;

	public static void main(String[] args) {
		String[] array = null;
		if (args.length > 0) {

			try {

				File file = new File(args[0]);

				BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

				String readLine = "";

				while ((readLine = bufferedReader.readLine()) != null) {
					System.out.println(readLine);
					array = readLine.split(INPUT_SEPERATOR);
					decideOperation(array);
				}

			} catch (IOException e) {
				System.out.println("Error in reading file");
			}

		} else {
			System.out.println("Please enter input command");

			Scanner scanner = new Scanner(System.in);
			while (!quit) {
				array = scanner.nextLine().split(INPUT_SEPERATOR);
				decideOperation(array);
			}

			scanner.close();
		}

	}

	public static void decideOperation(final String[] array) {

		final ParkingService parkingService = new ParkingServiceImpl();

		try {
			InputAction inputAction = null;
			try {
				inputAction = InputAction.valueOf(array[0].toUpperCase());

				switch (inputAction) {
				case CREATE_PARKING_LOT:

					parkingService.createParkingLot(Integer.parseInt(array[1]));

					break;

				case PARK:

					String registrationNumber = array[1];
					String color = array[2];
					try {

						int slotId = parkingService.parkVehicle(registrationNumber, Color.valueOf(color.toUpperCase()));

						if (slotId != 0)
							System.out.println("Allocated slot number: " + slotId);
						else
							System.out.println("Sorry, parking lot is full");

					} catch (Exception e) {
						System.out.println("Please enter valid color");
					}

					break;

				case STATUS:

					List<Ticket> tickets = parkingService.getParkedVehicleDetails();

					if (tickets != null && !tickets.isEmpty()) {
						Iterator<Ticket> ticketIterator = tickets.iterator();
						System.out.println("Slot No	" + "Registration No.	" + "Colour");
						while (ticketIterator.hasNext()) {
							Ticket ticket = ticketIterator.next();
							System.out.println(ticket.getParkingSlotId() + "	" + ticket.getRegistrationNo() + "	"
									+ ticket.getColor());

						}
					} else {
						System.out.println("No parking Lot is available.");
					}

					break;

				case LEAVE:

					int leavedSlotId = parkingService.leaveVehicle(Integer.parseInt(array[1]));
					if (leavedSlotId != 0)
						System.out.println("Slot number " + leavedSlotId + " is free");
					else
						System.out.println("Please enter valid input");

					break;

				case REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR:

					String registrationNumbers = parkingService
							.getRegistrationNumbersOfVehicleByColor(Color.valueOf(array[1].toUpperCase()));
					System.out.println(registrationNumbers);
					break;

				case SLOT_NUMBERS_FOR_CARS_WITH_COLOUR:
					String slotNumbersByColor = parkingService
							.getSlotNumbersOfVehicleByColour(Color.valueOf(array[1].toUpperCase()));
					System.out.println(slotNumbersByColor);
					break;

				case SLOT_NUMBER_FOR_REGISTRATION_NUMBER:

					String slotNumbersByregistrationNumber = parkingService
							.getSlotNumberByregistrationNumbers(array[1]);
					System.out.println(slotNumbersByregistrationNumber);
					break;
				case QUIT:
					quit = true;
					break;
				default:
					System.out.println("Please enter valid command");
					break;
				}
			} catch (IllegalArgumentException exception) {
				System.out.println("Please enter valid command");
			}

		} catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println("Please enter valid input");
		} catch (IllegalArgumentException exception) {
			System.out.println("Please enter valid color");
		}
	}

}
