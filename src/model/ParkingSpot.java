package model;

import enums.VehicleType;
import abstracts.IVehicle;

public class ParkingSpot {
    private boolean available;
    private IVehicle parkedVehicle;
    private final VehicleType spotType;
    private final int floorNumber;

    public ParkingSpot(VehicleType spotType, int floorNumber) {
        this.spotType = spotType;
        this.available = true;
        this.parkedVehicle = null;
        this.floorNumber = floorNumber;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void parkVehicle(IVehicle vehicle) {
        setParkedVehicle(vehicle);
        this.available = false;
    }

    public void removeVehicle() {
        setParkedVehicle(null);
        this.available = true;
    }

    public IVehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(IVehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
