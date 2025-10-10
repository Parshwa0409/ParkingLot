package model;

import enums.VehicleType;
import abstracts.IVehicle;

public class Vehicle implements IVehicle {
    private final String licensePlate;
    private final VehicleType type;

    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    @Override
    public String getLicensePlate() {
        return this.licensePlate;
    }

    @Override
    public VehicleType getVehicleType() {
        return this.type;
    }
}
