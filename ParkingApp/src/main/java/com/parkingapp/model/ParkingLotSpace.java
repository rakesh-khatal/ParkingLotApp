package com.parkingapp.model;

import com.parkingapp.common.VehilcleSize;

/**
 * @author rakesh.khatal
 *
 */
public class ParkingLotSpace {
	
	private VehilcleSize size;
	
	private int slotId;

	private boolean isOccupied = false;
	
	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public VehilcleSize getSize() {
		return size;
	}

	public void setSize(VehilcleSize size) {
		this.size = size;
	}
	
	@Override
    public boolean equals(Object o) {
        return (((ParkingLotSpace) o).slotId == this.slotId);
    }
 
    @Override
    public int hashCode() {
        int hash = 41;
        hash = hash + (33 * hash) + this.slotId;
        return hash;
    }  
	

}
