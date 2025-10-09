package abstracts;

import ENUMS.VehicleType;

public interface IParkingSpot {
    boolean isAvailable();
    void parkVehicle(IVehicle vehicle);
    void removeVehicle();
    VehicleType getSpotType();
}
