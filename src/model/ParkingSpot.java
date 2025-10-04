package model;

import ENUMS.ParkingSpotType;
import abstracts.IParkingSpot;
import abstracts.IVehicle;

public class ParkingSpot implements IParkingSpot {
    private boolean available;
    private IVehicle parkedVehicle;
    private final ParkingSpotType spotType;

    public ParkingSpot(ParkingSpotType spotType) {
        if (spotType == null) {
            spotType = ParkingSpotType.DefaultSpot;
        }
        this.spotType = spotType;
        this.available = true;
        this.parkedVehicle = null;
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
}
