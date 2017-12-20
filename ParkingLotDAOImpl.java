package com.parkingapp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.parkingapp.common.VehilcleSize;
import com.parkingapp.model.ParkingLot;
import com.parkingapp.model.ParkingLotSpace;
import com.parkingapp.model.Ticket;
import com.parkingapp.model.Vehicle;

public class ParkingLotDAOImpl implements ParkingLotDAO {

	private static ParkingLotDAOImpl parkingLotDAOImpl = null;

	private ParkingLotDAOImpl() {
	}

	public static ParkingLotDAOImpl getInstance() {
		if (parkingLotDAOImpl == null) {
			parkingLotDAOImpl = new ParkingLotDAOImpl();
		}
		return parkingLotDAOImpl;
	}

	private List<ParkingLotSpace> parkingSpaceList = null;

	private Map<Vehicle, ParkingLotSpace> occupiedParkingSpaces;

	@Override
	public void createParkingLot(int size) {
		
		ParkingLot parkingLot = new ParkingLot(1, size, null, createParkingLotSpace(size));// assumed floor number as 1
		occupiedParkingSpaces = new HashMap<>();
	}

	public List<ParkingLotSpace> createParkingLotSpace(int size) {
		parkingSpaceList = new ArrayList<>(size);
		for (int i = 1; i <= size; i++) {
			parkingSpaceList.add(new ParkingLotSpace(i));
		}
		return parkingSpaceList;
	}

	private ParkingLotSpace getFirstEmptySlot(List<ParkingLotSpace> parkingLotSpaceList) {
		Iterator<ParkingLotSpace> parkingLotIterator = parkingSpaceList.iterator();
		boolean isSlotFound = false;
		ParkingLotSpace emptySlot = null;

		while (parkingLotIterator.hasNext() && !isSlotFound) {
			emptySlot = parkingLotIterator.next();
			if (!emptySlot.isOccupied()) {
				isSlotFound = true;
				return emptySlot;
			}
		}
		return null;
	}

	public int park(Vehicle vehicle) {
		ParkingLotSpace parkingLotSpace;
		if ((parkingLotSpace = getFirstEmptySlot(parkingSpaceList)) != null) {
			parkingLotSpace = setParkingLotSpaceValues(parkingLotSpace);
			occupiedParkingSpaces.put(vehicle, parkingLotSpace);
			return parkingLotSpace.getSlotId();
		}

		return 0;
	}

	private ParkingLotSpace setParkingLotSpaceValues(ParkingLotSpace parkingLotSpace) {
		parkingLotSpace.setSize(VehilcleSize.MEDIUM); // I have considered all
														// vehicles as medium
		parkingLotSpace.setOccupied(true);
		parkingLotSpace.setSlotId(parkingLotSpace.getSlotId());
		return parkingLotSpace;
	}

	public int unPark(int slotId) {
		
		if (occupiedParkingSpaces != null) {
			Iterator iterator = occupiedParkingSpaces.entrySet().iterator();
			List<Ticket> ticketList = new ArrayList<>();
			while (iterator.hasNext()) {

				Map.Entry pair = (Map.Entry) iterator.next();

				ParkingLotSpace parkingLotSpace = (ParkingLotSpace) pair.getValue();
				Vehicle vehicle = (Vehicle) pair.getKey();

				if (slotId == parkingLotSpace.getSlotId()) {
					
					occupiedParkingSpaces.remove(vehicle);
					
					Iterator<ParkingLotSpace> parkingLotIterator = parkingSpaceList.iterator();
					
					while (parkingLotIterator.hasNext()) {
						ParkingLotSpace lotSpace = parkingLotIterator.next();
						if (parkingLotSpace.equals(lotSpace)) {
							lotSpace.setOccupied(false);
							return slotId;

						}
					}

				}

			}
			
		}
		return 0;
	}

	@Override
	public Map<Vehicle, ParkingLotSpace> getParkedVechileDetails() {

		return occupiedParkingSpaces;
	}

}
