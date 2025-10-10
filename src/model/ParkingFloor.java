package model;

import enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    List<ParkingSpot> parkingSpots;
    private final int floorNumber;

    public ParkingFloor(int floorNumber) {
        this.parkingSpots = new ArrayList<>();
        this.floorNumber = floorNumber;
    }

    public void setParkingSpots(List<ParkingSpot> spots) {
        this.parkingSpots = spots;
    }

    public boolean hasAvailableSpot(VehicleType type) {
        return parkingSpots.stream()
                .anyMatch(spot -> spot.getSpotType() == type && spot.isAvailable());
    }

    public ParkingSpot getAvailableSpot(VehicleType type) {
        return parkingSpots.stream()
                .filter(spot -> spot.getSpotType() == type && spot.isAvailable())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No available spots of type: " + type + " on floor: " + floorNumber));
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }
}
