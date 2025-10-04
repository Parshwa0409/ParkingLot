package factories;

import ENUMS.ParkingSpotType;
import ENUMS.VehicleType;

public class ParkingSpotTypeFactory {
    public static ParkingSpotType getSpotType(VehicleType vehicleType){
        ParkingSpotType parkingSpotType = null;

        switch (vehicleType){
            case TwoWheeler -> parkingSpotType = ParkingSpotType.TwoWheelerSpot;
            case ThreeWheeler -> parkingSpotType =  ParkingSpotType.ThreeWheelerSpot;
            case FourWheeler -> parkingSpotType = ParkingSpotType.FourWheelerSpot;
            default -> parkingSpotType = ParkingSpotType.DefaultSpot;
        }

        return parkingSpotType;
    }
}
