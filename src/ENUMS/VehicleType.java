package ENUMS;

public enum VehicleType {
    TwoWheeler(1,"TwoWheeler"),
    ThreeWheeler(2, "ThreeWheeler"),
    FourWheeler(3,"FourWheeler"),
    DefaultVehicleType(4,"DefaultVehicleType");

    private int code;
    private final String vehicleType;

    VehicleType(int code, String vehicleType) {
        this.code = code;
        this.vehicleType = vehicleType;
    }

    public String getVehicleType(int code) {
        for(VehicleType type : VehicleType.values()){
            if(type.code == code){
                return type.vehicleType;
            }
        }

        throw new RuntimeException("Invalid Vehicle Type Code");
    }

}
