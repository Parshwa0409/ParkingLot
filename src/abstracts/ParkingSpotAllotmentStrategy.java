package abstracts;

import enums.VehicleType;
import model.ParkingLot;
import model.ParkingSpot;

public abstract class ParkingSpotAllotmentStrategy {
    public final ParkingLot parkingLot;

    public ParkingSpotAllotmentStrategy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public abstract ParkingSpot findSpot(VehicleType vehicleType);

    public boolean isSpotAvailable(VehicleType vehicleType) {
        return parkingLot.getParkingFloors().stream()
                .flatMap(floor -> floor.getParkingSpots().stream())
                .anyMatch(spot -> spot.isAvailable() && spot.getSpotType() == vehicleType);
    }
}
