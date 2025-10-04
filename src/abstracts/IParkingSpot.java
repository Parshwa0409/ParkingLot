package abstracts;

import ENUMS.ParkingSpotType;

public interface IParkingSpot {
    boolean isAvailable();
    void parkVehicle(IVehicle vehicle);
    void removeVehicle();
    IVehicle getParkedVehicle();
    ParkingSpotType getSpotType();
    double cost();
}
