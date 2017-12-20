package com.parkingapp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.parkingapp.common.VehilcleSize;
import com.parkingapp.model.ParkingLot;
import com.parkingapp.model.ParkingLotSpace;
import com.parkingapp.model.Vehicle;

public class ParkingLotDAOImpl implements ParkingLotDAO{
	
    private static ParkingLotDAOImpl parkingLotDAOImpl = null;
    
    private ParkingLotDAOImpl(){
    }
    
    public static ParkingLotDAOImpl getInstance(){
		if(parkingLotDAOImpl == null){
			parkingLotDAOImpl = new ParkingLotDAOImpl();
		}
	return parkingLotDAOImpl;
    }
    
	private List<ParkingLotSpace> parkingSpaceList = null;
	
	private Map<Vehicle,ParkingLotSpace> occupiedParkingSpaces;
	
	@Override
	public void createParkingLot(int size) {
		//Create Singleton Object
		ParkingLot parkingLot = new ParkingLot(1, size, null, createParkingLotSpace(size));
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
            }
        }
        return emptySlot;
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
		parkingLotSpace.setSize(VehilcleSize.MEDIUM);  //I have considered all vehicles as medium
		parkingLotSpace.setOccupied(true);
		parkingLotSpace.setSlotId(parkingLotSpace.getSlotId());
		return parkingLotSpace;
	}
	
	 public void unPark(Vehicle vehicle) {
		 	occupiedParkingSpaces.get(vehicle).setOccupied(false);
	        occupiedParkingSpaces.remove(vehicle);
	    }

	@Override
	public Map<Vehicle,ParkingLotSpace> getParkedVechileDetails() {
		
		return occupiedParkingSpaces;
	}
 
}
