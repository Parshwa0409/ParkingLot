package factories;

import abstracts.ParkingSpotAllotmentStrategy;
import model.ParkingLot;
import strategy.parkingAllotment.FirstAvailableSpotParkingAllotment;
import strategy.parkingAllotment.RandomSpotParkingAllotment;

public class ParkingAllotmentFactory {
    public static ParkingSpotAllotmentStrategy getParkingAllotmentStrategy(int strategyType, ParkingLot lot){
        ParkingSpotAllotmentStrategy strategy = null;

        if(strategyType == 1)
             strategy = new FirstAvailableSpotParkingAllotment(lot);
        else if(strategyType == 2)
            strategy = new RandomSpotParkingAllotment(lot);
        else
            throw new IllegalArgumentException("Invalid strategy type");

        return strategy;
    }
}
