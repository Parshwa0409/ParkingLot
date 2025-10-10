package enums;

public enum VehicleType {
    TwoWheeler(1,"TwoWheeler", 20),
    ThreeWheeler(2, "ThreeWheeler", 30),
    FourWheeler(3,"FourWheeler", 40),
    DefaultVehicleType(4,"DefaultVehicleType", 10);

    private final int code;
    private final String vehicleType;
    private final int parkingCost;

    VehicleType(int code, String vehicleType, int cost) {
        this.code = code;
        this.vehicleType = vehicleType;
        this.parkingCost = cost;
    }

    public String getVehicleType(int code) {
        for(VehicleType type : VehicleType.values()){
            if(type.code == code){
                return type.vehicleType;
            }
        }
        throw new RuntimeException("Invalid Vehicle Type Code");
    }

    public int getParkingCost() {
        return parkingCost;
    }
}
