package ENUMS;

public enum ParkingSpotType {

    TwoWheelerSpot(VehicleType.TwoWheeler, 40),
    ThreeWheelerSpot(VehicleType.ThreeWheeler, 50),
    FourWheelerSpot(VehicleType.FourWheeler, 60),
    DefaultSpot(VehicleType.DefaultVehicleType, 60);


    private final VehicleType vehicleType;
    private final double parkingCost;

    ParkingSpotType(VehicleType vehicleType, int parkingCost) {
        this.vehicleType = vehicleType;
        this.parkingCost = parkingCost;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public double getParkingCost() {
        return parkingCost;
    }

    public static ParkingSpotType getAppropriateSpotType(VehicleType vehicleType) {
        for(ParkingSpotType type : values()){
            if(type.vehicleType == vehicleType ){
                return type;
            }
        }

        throw new RuntimeException("Invalid Vehicle Type");
    }


}
