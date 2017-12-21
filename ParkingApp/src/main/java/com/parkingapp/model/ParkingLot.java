package com.parkingapp.model;

import java.util.List;

/**
 * @author rakesh.khatal
 *
 */
public class ParkingLot {

	private int numberOfFloor;
	private int size;
	private ParkingLotSign parkingLotSign;
	private List<ParkingLotSpace> parkingLotSpace;
	
	public ParkingLot(int numberOfFloor, int size, ParkingLotSign parkingLotSign,
			List<ParkingLotSpace> parkingLotSpace) {
		super();
		this.numberOfFloor = numberOfFloor;
		this.size = size;
		this.parkingLotSign = parkingLotSign;
		this.parkingLotSpace = parkingLotSpace;
	}

	public int getNumberOfFloor() {
		return numberOfFloor;
	}

	public void setNumberOfFloor(int numberOfFloor) {
		this.numberOfFloor = numberOfFloor;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	public ParkingLotSign getParkingLotSign() {
		return parkingLotSign;
	}
	public void setParkingLotSign(ParkingLotSign parkingLotSign) {
		this.parkingLotSign = parkingLotSign;
	}

	public List<ParkingLotSpace> getParkingLotSpace() {
		return parkingLotSpace;
	}

	public void setParkingLotSpace(List<ParkingLotSpace> parkingLotSpace) {
		this.parkingLotSpace = parkingLotSpace;
	}
	
}
