package strategy.parkingAllotment;

import abstracts.ParkingSpotAllotmentStrategy;
import enums.VehicleType;
import model.ParkingLot;
import model.ParkingSpot;

import java.util.List;
import java.util.Random;

public class RandomSpotParkingAllotment extends ParkingSpotAllotmentStrategy {
    public RandomSpotParkingAllotment(ParkingLot parkingLot) {
        super(parkingLot);
    }

    @Override
    public ParkingSpot findSpot(VehicleType vehicleType) {
        List<ParkingSpot> availableSpots = this.parkingLot.getParkingFloors().stream()
                .flatMap(floor -> floor.getParkingSpots().stream())
                .filter(spot -> spot.isAvailable() && spot.getSpotType() == vehicleType)
                .toList();

        Random random = new Random();
        return availableSpots.get(random.nextInt(availableSpots.size()));
    }
}
