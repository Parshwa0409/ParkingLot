package model;

import enums.VehicleType;

public class SpotAssignmentStrategy {
    private final ParkingLot parkingLot;

    public SpotAssignmentStrategy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingSpot findSpot(VehicleType vehicleType) {
        return parkingLot.getParkingFloors().stream()
                .flatMap(floor -> floor.getParkingSpots().stream())
                .filter(spot -> spot.isAvailable() && spot.getSpotType() == vehicleType)
                .findFirst()
                .orElse(null);
    }

    public boolean isSpotAvailable(VehicleType vehicleType) {
        return parkingLot.getParkingFloors().stream()
                .flatMap(floor -> floor.getParkingSpots().stream())
                .anyMatch(spot -> spot.isAvailable() && spot.getSpotType() == vehicleType);
    }
}
