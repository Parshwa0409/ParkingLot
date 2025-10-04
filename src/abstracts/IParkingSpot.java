package abstracts;

import ENUMS.ParkingSpotType;

public interface IParkingSpot {
    boolean isAvailable();
    void parkVehicle(IVehicle vehicle);
    void removeVehicle();
    ParkingSpotType getSpotType();
}
