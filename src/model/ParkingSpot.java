package model;

import ENUMS.ParkingSpotType;
import abstracts.IParkingSpot;
import abstracts.IVehicle;

public class ParkingSpot implements IParkingSpot {
    private boolean available;
    private IVehicle parkedVehicle;
    private ParkingSpotType spotType = ParkingSpotType.DefaultSpot;

    public ParkingSpot(ParkingSpotType spotType) {
        this.available = true;
        this.parkedVehicle = null;
        this.spotType = spotType;
    }

    public IVehicle getParkedVehicle() {
        return parkedVehicle;
    }

    @Override
    public ParkingSpotType getSpotType() {
        return spotType;
    }

    @Override
    public boolean isAvailable() {
        return this.available;
    }

    @Override
    public void parkVehicle(IVehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.available = false;
    }

    @Override
    public void removeVehicle() {
        this.parkedVehicle = null;
        this.available = true;
    }

    @Override
    public double cost() {
        return spotType.getParkingCost();
    }
}
