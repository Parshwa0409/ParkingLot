package strategy.parkingAllotment;

import abstracts.ParkingSpotAllotmentStrategy;
import enums.VehicleType;
import model.ParkingLot;
import model.ParkingSpot;

public class FirstAvailableSpotParkingAllotment extends ParkingSpotAllotmentStrategy {
    public FirstAvailableSpotParkingAllotment(ParkingLot parkingLot) {
        super(parkingLot);
    }

    @Override
    public ParkingSpot findSpot(VehicleType vehicleType) {
        return this.parkingLot.getParkingFloors().stream()
                .flatMap(floor -> floor.getParkingSpots().stream())
                .filter(spot -> spot.isAvailable() && spot.getSpotType() == vehicleType)
                .findFirst()
                .orElse(null);
    }
}
