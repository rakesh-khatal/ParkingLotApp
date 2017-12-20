package com.parkingapp.service;

import java.util.Scanner;

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
		switch (array[0]) {
		case "create_parking_lot":

			parkingService.createParkingLot(Integer.parseInt(array[1]));

			break;
			
		case "park":

			String registrationNumber = array[1];
			String color = array[2];

			parkingService.parkVehicle(registrationNumber, color);

			break;
		}
	}

}
