package model;

import ENUMS.VehicleType;
import abstracts.IParkingSpot;
import abstracts.IVehicle;

public class ParkingSpot implements IParkingSpot {
    private boolean available;
    private IVehicle parkedVehicle;
    private final VehicleType spotType;

    public ParkingSpot(VehicleType spotType) {
        this.spotType = spotType;
        this.available = true;
        this.parkedVehicle = null;
    }

    @Override
    public VehicleType getSpotType() {
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
}
